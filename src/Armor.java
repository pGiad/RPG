public class Armor extends Item {
    public int defense;

    public Armor(String name, int minLevel, int def) {
        super(name, minLevel * 50, minLevel);
        defense = def;

        System.out.println("Constructed an Armor named: " + name);       // Print message
        System.out.println("Price: " + price);
        System.out.println("Minimum Level: " + minLevel);
        System.out.println("Defense: " + def);
    }

    public static void main(String[] args) {
        new Armor("Heavy Armor", 5, 200);
    }
}
