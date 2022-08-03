package main.java.gr.pgiad.rpg.item;

public class Armor extends Item {
    private final int defense;
    private boolean equipped = false;

    // Constructor
    public Armor(String name, int minLevel, int defense) {
        super(name, 50 * minLevel, minLevel);
        this.defense = defense;
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
}
