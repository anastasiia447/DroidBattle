package area;

import droid.Droid;
import utilits.SaveFight;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TeamArena {

    private final List<Droid> blueDroids = new ArrayList<>();
    private final List<Droid> redDroids = new ArrayList<>();
    private Droid attacker;
    private Droid defender;
    private int currentRound = 0;

    public TeamArena(List<Droid> droids) {

        for (int i = 0; i < droids.size(); i++) {
            if ((i + 1) % 2 == 0) {
                this.blueDroids.add(droids.get(i));
            } else {
                this.redDroids.add(droids.get(i));
            }
        }
    }

    public Droid startFight() throws InterruptedException {
        do {
            prepareRound();
            double actualDamage = doFight();
            printRoundInfo(actualDamage);

            TimeUnit.SECONDS.sleep(1);
            if(!defender.isAlive()){
                if(blueDroids.contains(defender)){
                    for(Droid droid: blueDroids){
                        if(droid.isAlive()){
                            defender = droid;
                        }
                    }
                }
                else{
                    for(Droid droid: redDroids){
                        if(droid.isAlive()){
                            defender = droid;
                        }
                    }
                }
            }
        } while (defender.isAlive());

        return attacker;
    }

    private double doFight() {
        return defender.getHit(attacker.getDamage());
    }

    private void printRoundInfo(double actualDamage) {
        SaveFight.log(defender.getName() + " get hit with " + actualDamage + " damage");
        SaveFight.log("Defender " + defender);
        SaveFight.log("Attacker " + attacker);
    }

    private void prepareRound() {
        initFighters();
        currentRound++;
        SaveFight.log("-------------------------------------");
        SaveFight.log("Round " + currentRound);
    }

    private void initFighters() {
        Random random = new Random();

        if (random.nextBoolean()) {
            attacker = aliveFromTeam(blueDroids);
            defender = aliveFromTeam(redDroids);
        } else {
            attacker = aliveFromTeam(redDroids);
            defender = aliveFromTeam(blueDroids);
        }
    }
    private Droid aliveFromTeam(List<Droid> droidTeam) {
        Random random = new Random();
        Droid teammate = droidTeam.get(random.nextInt(droidTeam.size()));

        while (!teammate.isAlive()) {
            teammate = droidTeam.get(random.nextInt(droidTeam.size()));
        }
        return teammate;
    }

}
