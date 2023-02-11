package droid;

import mechanics.StatusDamage;

import static mechanics.StatusDamage.status.Ice;

public class PoliceDroid extends Droid {

    public PoliceDroid(double health, double damage, String name) {
        super(health, damage, name);
        this.resistSl = 1;
        this.resistIm = 0.9;
        this.resistFi = 1.4;
        this.resistIc = 0.5;
        this.shield = 6;
    }

    @Override
    public StatusDamage getDamage() {
        return new StatusDamage(Ice, this.damage);
    }


}
