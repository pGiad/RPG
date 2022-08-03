package main.java.gr.pgiad.rpg.initializeHeroItems;

import main.java.gr.pgiad.rpg.Spell;
import main.java.gr.pgiad.rpg.enumeration.PotionKind;
import main.java.gr.pgiad.rpg.enumeration.SpellKind;
import main.java.gr.pgiad.rpg.item.Armor;
import main.java.gr.pgiad.rpg.item.Potion;
import main.java.gr.pgiad.rpg.item.Weapon;
import main.java.gr.pgiad.rpg.living.Hero;

import java.util.ArrayList;

public class InitializeSorcererItems {
    public void main(Hero myHero) {
        // Set Sorcerer's Potions to begin with
        ArrayList<Potion> myPotions = new ArrayList<>();
        myPotions.add(new Potion("Enhanced Golden Oriole", 100, 1, 50, PotionKind.DEXTERITY));
        myPotions.add(new Potion("Full Moon", 100, 1, 50, PotionKind.AGILITY));
        myHero.setPotions(myPotions);

        // Set Sorcerer's Spells to begin with
        ArrayList<Spell> mySpells = new ArrayList<>();
        mySpells.add(new Spell("Igni", 150, 1, 1.1, 1.2, 150, 0.2, SpellKind.FIRESPELL));
        mySpells.add(new Spell("Axii", 150, 1, 1.1, 1.2, 150, 0.2, SpellKind.ICESPELL));
        mySpells.add(new Spell("Quen", 150, 1, 1.1, 1.2, 150, 0.2, SpellKind.LIGHTINGSPELL));
        myHero.setSpells(mySpells);


        // Set Sorcerer's Weapons to begin with
        ArrayList<Weapon> myWeapons = new ArrayList<>();
        myWeapons.add(new Weapon("Durendal", 1, 100, false));
        myHero.setWeapons(myWeapons);

        // Set Sorcerer's Armors to begin with
        ArrayList<Armor> myArmors = new ArrayList<>();
        myArmors.add(new Armor("Iron Safeguard", 1, 100));
        myHero.setArmors(myArmors);
    }
}
