package main.java.gr.pgiad.rpg.initializer;

import main.java.gr.pgiad.rpg.Spell;
import main.java.gr.pgiad.rpg.enumeration.HeroKind;
import main.java.gr.pgiad.rpg.enumeration.PotionKind;
import main.java.gr.pgiad.rpg.enumeration.SpellKind;
import main.java.gr.pgiad.rpg.item.Armor;
import main.java.gr.pgiad.rpg.item.Potion;
import main.java.gr.pgiad.rpg.item.Weapon;
import main.java.gr.pgiad.rpg.living.Hero;

import java.util.ArrayList;

public class InitializeHeroItems {
    private final static ArrayList<Potion> myPotions = new ArrayList<>();
    private final static ArrayList<Spell> mySpells = new ArrayList<>();
    private final static ArrayList<Weapon> myWeapons = new ArrayList<>();
    private final static ArrayList<Armor> myArmors = new ArrayList<>();

    public static void initializeHero(Hero myHero) {
        if (myHero.getHeroKind() == HeroKind.WARRIOR) {
            // Set Warrior's Potions to begin with
            myPotions.add(new Potion("Earth elemental", 100, 1, 50, PotionKind.STRENGTH));
            myPotions.add(new Potion("Enhanced Black Blood", 100, 1, 50, PotionKind.AGILITY));

            // Set Warrior's Spells to begin with
            mySpells.add(new Spell("Igni", 150, 1, 1.1, 1.2, 150, 0.2, SpellKind.FIRESPELL));

            // Set Warrior's Weapons to begin with
            myWeapons.add(new Weapon("Bloodsword", 1, 100, true));
            myWeapons.add(new Weapon("Aerondight Sword", 1, 100, false));
            myHero.setWeapons(myWeapons);

            // Set Warrior's Armors to begin with
            myArmors.add(new Armor("Hen Gaidth", 1, 100));
        }
        else if (myHero.getHeroKind() == HeroKind.SORCERER) {
            // Set Sorcerer's Potions to begin with
            myPotions.add(new Potion("Enhanced Golden Oriole", 100, 1, 50, PotionKind.DEXTERITY));
            myPotions.add(new Potion("Full Moon", 100, 1, 50, PotionKind.AGILITY));

            // Set Sorcerer's Spells to begin with
            mySpells.add(new Spell("Igni", 150, 1, 1.1, 1.2, 150, 0.2, SpellKind.FIRESPELL));
            mySpells.add(new Spell("Axii", 150, 1, 1.1, 1.2, 150, 0.2, SpellKind.ICESPELL));
            mySpells.add(new Spell("Quen", 150, 1, 1.1, 1.2, 150, 0.2, SpellKind.LIGHTINGSPELL));

            // Set Sorcerer's Weapons to begin with
            myWeapons.add(new Weapon("Durendal", 1, 100, false));

            // Set Sorcerer's Armors to begin with
            myArmors.add(new Armor("Iron Safeguard", 1, 100));
        }
        else {
            // Set Paladin's Potions to begin with
            myPotions.add(new Potion("Maribor Forest", 100, 1, 50, PotionKind.DEXTERITY));
            myPotions.add(new Potion("Potion of Clearance", 100, 1, 50, PotionKind.STRENGTH));

            // Set Paladin's Spells to begin with
            mySpells.add(new Spell("Axii", 150, 1, 1.1, 1.2, 150, 0.2, SpellKind.ICESPELL));

            // Set Paladin's Weapons to begin with
            myWeapons.add(new Weapon("Flaming Protector", 1, 100, false));

            // Set Paladin's Armors to begin with
            myArmors.add(new Armor("Leather of the Leviathan", 1, 100));
            myArmors.add(new Armor("Kaer Morhen Armor", 1, 100));
        }
        myHero.setPotions(myPotions);
        myHero.setSpells(mySpells);
        myHero.setArmors(myArmors);
    }
}
