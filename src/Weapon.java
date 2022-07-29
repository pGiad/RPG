public class Weapon extends Item {
    public int damage;
    public boolean twoHandsNeeded;

    public Weapon(String name, int minLevel, int dmg, boolean twoHands) {
        super(name, minLevel * 50, minLevel);
        damage = dmg;
        twoHandsNeeded = twoHands;

        System.out.println("Constructed a Weapon named: " + name);       // Print message
        System.out.println("Price: " + price);
        System.out.println("Minimum Level: " + minLevel);
        System.out.println("Damage: " + dmg);
        System.out.println("2 Hands Needed: " + twoHands);
    }

    public static void main(String[] args) {
        new Weapon("Blade of Power", 5, 100, true);
    }
}
