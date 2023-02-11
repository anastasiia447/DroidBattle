package mechanics;

public class StatusDamage {

    public enum status{
        Slash,
        Impact,
        Fire,
        Ice
    }
    private status StatusDmg;
    private final double dmg;

    public StatusDamage(status status, double dmg) {
        this.StatusDmg = status;
        this.dmg=dmg;
    }


    public status getStatus() {
        return StatusDmg;
    }

    public double getDmg() {
        return dmg;
    }

}
