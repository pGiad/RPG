package main.java.gr.pgiad.rpg.item;

public class Armor extends Item {
    private final int defense;
    private boolean equipped = false;

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

    public boolean isEquipped() {
        return equipped;
    }

    public void setEquipped(boolean equipped) {
        this.equipped = equipped;
    }

    public static void main(String[] args) {
        new Armor("Heavy Armor", 5, 200);
    }
}
