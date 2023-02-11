package area;

import droid.Droid;
import utilits.SaveFight;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Arena {
    private final Droid firstDroid;
    private final Droid secondDroid;
    private Droid attacker;
    private Droid defender;
    private int currentRound = 0;

    public Arena(Droid firstDroid, Droid secondDroid) {
        this.firstDroid = firstDroid;
        this.secondDroid = secondDroid;
    }

    public Droid startFight() throws InterruptedException {
        do {
            prepareRound();
            double actualDamage = doFight();
            printRoundInfo(actualDamage);

            TimeUnit.SECONDS.sleep(1);
        } while (defender.isAlive());

        return attacker;
    }

    private void prepareRound() {
        initFighters();
        currentRound++;
        SaveFight.log("-------------------------------------");
        SaveFight.log("Round " + currentRound);
    }

    private double doFight() {
        return defender.getHit(attacker.getDamage());
    }

    private void printRoundInfo(double actualDamage) {
        SaveFight.log(defender.getName() + " get hit with " + actualDamage + " damage");
        SaveFight.log("Defender " + defender);
        SaveFight.log("Attacker " + attacker);
    }

    private void initFighters() {
        Random random = new Random();
        if (random.nextBoolean()) {
            attacker = firstDroid;
            defender = secondDroid;
        } else {
            attacker = secondDroid;
            defender = firstDroid;
        }
    }
}