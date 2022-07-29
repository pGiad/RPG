public class FireSpell extends Spell {
    public double defenceReduction;
    public FireSpell(String name, int price, int minLevel, int damageMin, int damageMax, int magicPower, double defReduction) {
        super(name, price, minLevel, damageMin, damageMax, magicPower);
        defenceReduction = defReduction;

        System.out.println("Constructed an FireSpell, named: " + name);
        System.out.println("Price: " + price);
        System.out.println("Defence Reduction: " + defReduction);
    }

    public static void main(String[] args) {
        new FireSpell("HellPot", 200, 4, 100, 150, 150, 0.3);
    }
}