package droid;

import mechanics.StatusDamage;

import java.util.Random;

import static mechanics.StatusDamage.status.Slash;

public class NinjaDroid extends Droid {

    public NinjaDroid(double health, double damage, String name) {
        super(health, damage, name);
        this.resistSl = 2;
        this.resistIm = 1.2;
        this.resistFi = 1.1;
        this.resistIc = 1.1;
        this.evasion = 25;
    }

    @Override
    public StatusDamage getDamage() {
        return new StatusDamage(Slash, this.damage);
    }


}
