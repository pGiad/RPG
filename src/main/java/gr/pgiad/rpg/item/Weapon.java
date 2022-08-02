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

        System.out.println("Constructed a Weapon named: " + this.getName());       // Print message
        System.out.println("Price: " + this.getPrice());
        System.out.println("Minimum Level: " + this.getMinLevel());
        System.out.println("Damage: " + this.getAttack());
        System.out.println("2 Hands Needed: " + this.isTwoHands());
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

    public static void main(String[] args) {
        new Weapon("Blade of Power", 5, 100, true);
    }
}
