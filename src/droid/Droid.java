package droid;

import mechanics.StatusDamage;

import java.text.DecimalFormat;
import java.util.Random;

import static mechanics.StatusDamage.status.*;

public class Droid {
    protected String name;
    protected double damage;
    protected double health;
    protected double resistSl;
    protected double resistIm;
    protected double resistFi;
    protected double resistIc;
    protected double ignore;
    protected double armor;
    protected double shield;
    protected double evasion;

    public Droid(double health, double damage, String name) {
        this.health = health;
        this.damage = damage;
        this.name = name;

        this.resistSl = 0;
        this.resistIm = 0;
        this.resistFi = 0;
        this.resistIc = 0;
        this.armor = 0;
        this.evasion = 0;
        this.shield = 0;
        this.ignore = 0;
    }

    public StatusDamage getDamage() {
        return new StatusDamage(Slash, 0);
    }

    public String getName() {
        return name;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public double getHit(StatusDamage damage) {
        Random random = new Random();

        double actualDamage;

        switch (damage.getStatus()) {
            case Slash:
                actualDamage = (damage.getDmg()-ignore) * resistSl;
                break;
            case Impact:
                actualDamage = (damage.getDmg()-ignore) * resistIm * (1 - ((double) armor / 100));
                break;
            case Fire:
                actualDamage = (damage.getDmg()-ignore) * resistFi * (1 - ((double) armor / 100));
                break;
            case Ice:
                actualDamage = (damage.getDmg()-ignore) * resistIc * (1 - ((double) armor / 100));
                break;
            default:
                System.out.println("Something go wrong");
                actualDamage = 0;
                break;
        }

        if (random.nextInt(100) > evasion) {
            if (this.shield > 0) {
                this.shield -= actualDamage;
            } else {
                this.health -= actualDamage;
            }

            if (health < 0) {
                health = 0;
            }
            return actualDamage;
        }

        return 0;
    }

    @Override
    public String toString() {
        DecimalFormat numberFormat = new DecimalFormat("#.00");
        return name + " health " + numberFormat.format(health);
    }
}
