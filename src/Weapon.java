public class Weapon extends Item {
    public int attack;
    public boolean twoHandsNeeded;
    // Constructor
    public Weapon(String name, int minLevel, int att, boolean twoHands) {
        super(name, minLevel * 50, minLevel);
        attack = att;
        twoHandsNeeded = twoHands;

        System.out.println("Constructed a Weapon named: " + name);       // Print message
        System.out.println("Price: " + price);
        System.out.println("Minimum Level: " + minLevel);
        System.out.println("Damage: " + att);
        System.out.println("2 Hands Needed: " + twoHands);
    }

    public static void main(String[] args) {
        new Weapon("Blade of Power", 5, 100, true);
    }
}
