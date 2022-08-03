package main.java.gr.pgiad.rpg.item;

public class Weapon extends Item {
    private final int attack;
    private final boolean twoHands;
    private boolean equipped = false;

    // Constructor
    public Weapon(String name, int minLevel, int attack, boolean twoHands) {
        super(name, 50 * minLevel, minLevel);
        this.attack = attack;
        this.twoHands = twoHands;
    }

    public int getAttack() {
        return attack;
    }

    public boolean isTwoHands() {
        return twoHands;
    }
    public boolean isEquipped() {
        return equipped;
    }

    public void setEquipped(boolean equipped) {
        this.equipped = equipped;
    }
}
