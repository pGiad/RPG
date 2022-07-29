public class LightingSpell extends Spell {
    public double dodgeReduction;
    public LightingSpell(String name, int price, int minLevel, int damageMin, int damageMax, int magicPower, double dodReduction) {
        super(name, price, minLevel, damageMin, damageMax, magicPower);
        dodgeReduction = dodReduction;

        System.out.println("Constructed an LightingSpell, named: " + name);
        System.out.println("Price: " + price);
        System.out.println("Dodge Chance Reduction: " + dodReduction);
    }

    public static void main(String[] args) {
        new LightingSpell("LightPower", 200, 4, 100, 150, 150, 0.2);
    }
}