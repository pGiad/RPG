package main.java.gr.pangiad.rpg;

import main.java.gr.pangiad.rpg.enumeration.MonsterKind;

public class Monster extends Living {
    public int defense, damageMin, damageMax;
    public double dodgeChance;

    MonsterKind monsterKind;

    // Constructor
    public Monster(String name, MonsterKind kind, int level) {
        super(name, level, 1000);
        if (kind == MonsterKind.DRAGON) {       // Dragons have better damage range
            defense = 300;
            damageMin = 200;
            damageMax = 300;
            dodgeChance = 0.2;
            monsterKind = kind;
        } else if (kind == MonsterKind.EXOSKELETON) {        // Exoskeletons have raised defense
            defense = 500;
            damageMin = 100;
            damageMax = 250;
            dodgeChance = 0.2;
            monsterKind = kind;
        } else if (kind == MonsterKind.SPIRIT) {        // Spirits have raised dodge chance
            defense = 300;
            damageMin = 100;
            damageMax = 250;
            dodgeChance = 0.4;
            monsterKind = kind;
        }
        // Print message
        System.out.println("Constructed a main.java.gr.pangiad.rpg.Monster of MonsterKind: " + monsterKind + ", named: " + name);
        System.out.println("Defense: " + defense);
        System.out.println("damageMin: " + damageMin);
        System.out.println("damageMax: " + damageMax);
        System.out.println("dodgeChance: " + dodgeChance);
    }

    public static void main(String[] args) {
        new Monster("White Spirit", MonsterKind.SPIRIT, 5);
    }
}