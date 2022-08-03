package main.java.gr.pgiad.rpg.initializeHeroItems;

import main.java.gr.pgiad.rpg.Spell;
import main.java.gr.pgiad.rpg.enumeration.PotionKind;
import main.java.gr.pgiad.rpg.enumeration.SpellKind;
import main.java.gr.pgiad.rpg.item.Armor;
import main.java.gr.pgiad.rpg.item.Potion;
import main.java.gr.pgiad.rpg.item.Weapon;
import main.java.gr.pgiad.rpg.living.Hero;

import java.util.ArrayList;

public class InitializePaladinItems {
    public void main(Hero myHero) {
        // Set Paladin's Potions to begin with
        ArrayList<Potion> myPotions = new ArrayList<>();
        myPotions.add(new Potion("Maribor Forest", 100, 1, 50, PotionKind.DEXTERITY));
        myPotions.add(new Potion("Potion of Clearance", 100, 1, 50, PotionKind.STRENGTH));
        myHero.setPotions(myPotions);

        // Set Paladin's Spells to begin with
        ArrayList<Spell> mySpells = new ArrayList<>();
        mySpells.add(new Spell("Axii", 150, 1, 1.1, 1.2, 150, 0.2, SpellKind.ICESPELL));
        myHero.setSpells(mySpells);


        // Set Paladin's Weapons to begin with
        ArrayList<Weapon> myWeapons = new ArrayList<>();
        myWeapons.add(new Weapon("Flaming Protector", 1, 100, false));
        myHero.setWeapons(myWeapons);

        // Set Paladin's Armors to begin with
        ArrayList<Armor> myArmors = new ArrayList<>();
        myArmors.add(new Armor("Leather of the Leviathan", 1, 100));
        myArmors.add(new Armor("Kaer Morhen Armor", 1, 100));
        myHero.setArmors(myArmors);
    }
}
