public class IceSpell extends Spell {
    public double damageReduction;
    public IceSpell(String name, int price, int minLevel, int damageMin, int damageMax, int magicPower, double dmgReduction) {
        super(name, price, minLevel, damageMin, damageMax, magicPower);
        damageReduction = dmgReduction;

        System.out.println("Constructed an IceSpell, named: " + name);
        System.out.println("Price: " + price);
        System.out.println("Damage Range Reduction: " + dmgReduction);
    }

    public static void main(String[] args) {
        new IceSpell("Frozy", 200, 4, 100, 150, 150, 0.3);
    }
}
