package main.java.gr.pgiad.rpg.living;

public abstract class Living {
    private String name;
    private int level;
    private int healthPower;
    private int currentHP;

    // Constructor
    public Living(String name, int level, int healthPower) {
        this.name = name;
        this.level = level;
        this.healthPower = healthPower;
        this.currentHP = healthPower;
        System.out.println("Constructed a Living named: " + name);     // Print message
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHealthPower() {
        return healthPower;
    }

    public void setHealthPower(int healthPower) {
        this.healthPower = healthPower;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }
}