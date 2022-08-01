package main.java.gr.pgiad.rpg.living;

import main.java.gr.pgiad.rpg.enumeration.MonsterKind;

public class Monster extends Living {
    private int defense;
    private int damageMin;
    private int damageMax;
    private double dodgeChance;
    private MonsterKind monsterKind;

    // Constructor
    public Monster(String name, int level, int healthPower, MonsterKind monsterKind) {
        super(name, level, healthPower);
        this.monsterKind = monsterKind;
        if (this.monsterKind == MonsterKind.DRAGON) {                // Dragons have better damage range
            this.defense = 300;
            this.damageMin = 200;
            this.damageMax = 300;
            this.dodgeChance = 0.2;
        }
        else if (this.monsterKind == MonsterKind.EXOSKELETON) {     // Exoskeletons have raised defense
            this.defense = 500;
            this.damageMin = 100;
            this.damageMax = 250;
            this.dodgeChance = 0.2;
        }
        else if (this.monsterKind  == MonsterKind.SPIRIT) {         // Spirits have raised dodge chance
            this.defense = 300;
            this.damageMin = 100;
            this.damageMax = 250;
            this.dodgeChance = 0.4;
        }
        // Print message
        System.out.println("Constructed a Monster of MonsterKind: " + this.monsterKind + ", named: " + this.getName());
        System.out.println("Defense: " + this.defense);
        System.out.println("damageMin: " + this.damageMin);
        System.out.println("damageMax: " + this.damageMax);
        System.out.println("dodgeChance: " + this.dodgeChance);
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getDamageMin() {
        return damageMin;
    }

    public void setDamageMin(int damageMin) {
        this.damageMin = damageMin;
    }

    public int getDamageMax() {
        return damageMax;
    }

    public void setDamageMax(int damageMax) {
        this.damageMax = damageMax;
    }

    public double getDodgeChance() {
        return dodgeChance;
    }

    public void setDodgeChance(double dodgeChance) {
        this.dodgeChance = dodgeChance;
    }

    public MonsterKind getMonsterKind() {
        return monsterKind;
    }

    public void setMonsterKind(MonsterKind monsterKind) {
        this.monsterKind = monsterKind;
    }

    public static void main(String[] args) {
        new Monster("Monster Name", 5, 1000, MonsterKind.DRAGON);
    }
}