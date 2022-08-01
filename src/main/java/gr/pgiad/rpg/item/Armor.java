package main.java.gr.pgiad.rpg.item;

public class Armor extends Item {
    private int defense;

    // Constructor
    public Armor(String name, int minLevel, int defense) {
        super(name, 50 * minLevel, minLevel);
        this.defense = defense;

        System.out.println("Constructed an Armor named: " + this.getName());      // Print message
        System.out.println("Price: " + this.getPrice());
        System.out.println("Minimum Level: " + this.getMinLevel());
        System.out.println("Defense: " + this.getDefense());
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public static void main(String[] args) {
        new Armor("Heavy Armor", 5, 200);
    }
}
