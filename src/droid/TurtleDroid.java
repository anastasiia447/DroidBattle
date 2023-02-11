package droid;

import mechanics.StatusDamage;

import static mechanics.StatusDamage.status.Fire;

public class TurtleDroid extends Droid {

    public TurtleDroid(double health, double damage, String name) {
        super(health, damage, name);
        this.resistSl = 1;
        this.resistIm = 0.9;
        this.resistFi = 0.5;
        this.resistIc = 1.5;
        this.armor = 20;
    }

    @Override
    public StatusDamage getDamage() {
        return new StatusDamage(Fire, this.damage);
    }

}
