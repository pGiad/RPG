package main.java.gr.pgiad.rpg.item;

public class Weapon extends Item {
    private int attack;
    private boolean twoHands;

    // Constructor
    public Weapon(String name, int minLevel, int attack, boolean twoHands) {
        super(name, 50 * minLevel, minLevel);
        this.attack = attack;
        this.twoHands = twoHands;

        System.out.println("Constructed a Weapon named: " + this.getName());       // Print message
        System.out.println("Price: " + this.getPrice());
        System.out.println("Minimum Level: " + this.getMinLevel());
        System.out.println("Damage: " + this.getAttack());
        System.out.println("2 Hands Needed: " + this.getTwoHands());
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public boolean getTwoHands() {
        return twoHands;
    }

    public void setTwoHandsNeeded(boolean twoHands) {
        this.twoHands = twoHands;
    }

    public static void main(String[] args) {
        new Weapon("Blade of Power", 5, 100, true);
    }
}
