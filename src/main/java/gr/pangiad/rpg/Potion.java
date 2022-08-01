package main.java.gr.pangiad.rpg;

import main.java.gr.pangiad.rpg.item.Item;

public class Potion extends Item {
    public int gain;

    // A potion can raise main.java.gr.pangiad.rpg.Hero's HP, Attack/Damage, Defense or Magic Power
    enum PotionKind {
        Strength,
        Dexterity,
        Agility
    }

    PotionKind potionKind;

    // Constructor
    public Potion(String name, int price, int minLevel, PotionKind kind, int gn) {
        super(name, price, minLevel);
        potionKind = kind;
        gain = gn;
    }
}
