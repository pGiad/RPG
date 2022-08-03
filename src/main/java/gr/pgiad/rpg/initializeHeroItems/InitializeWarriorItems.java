package main.java.gr.pgiad.rpg.initializeHeroItems;

import main.java.gr.pgiad.rpg.Spell;
import main.java.gr.pgiad.rpg.enumeration.PotionKind;
import main.java.gr.pgiad.rpg.enumeration.SpellKind;
import main.java.gr.pgiad.rpg.item.Armor;
import main.java.gr.pgiad.rpg.item.Potion;
import main.java.gr.pgiad.rpg.item.Weapon;
import main.java.gr.pgiad.rpg.living.Hero;

import java.util.ArrayList;

public class InitializeWarriorItems {
    public void main(Hero myHero) {
        // Set Warrior's Potions to begin with
        ArrayList<Potion> myPotions = new ArrayList<>();
        myPotions.add(new Potion("Earth elemental", 100, 1, 50, PotionKind.STRENGTH));
        myPotions.add(new Potion("Enhanced Black Blood", 100, 1, 50, PotionKind.AGILITY));
        myHero.setPotions(myPotions);

        // Set Warrior's Spells to begin with
        ArrayList<Spell> mySpells = new ArrayList<>();
        mySpells.add(new Spell("Igni", 150, 1, 1.1, 1.2, 150, 0.2, SpellKind.FIRESPELL));
        myHero.setSpells(mySpells);


        // Set Warrior's Weapons to begin with
        ArrayList<Weapon> myWeapons = new ArrayList<>();
        myWeapons.add(new Weapon("Bloodsword", 1, 100, true));
        myWeapons.add(new Weapon("Aerondight Sword", 1, 100, false));
        myHero.setWeapons(myWeapons);

        // Set Warrior's Armors to begin with
        ArrayList<Armor> myArmors = new ArrayList<>();
        myArmors.add(new Armor("Hen Gaidth", 1, 100));
        myHero.setArmors(myArmors);
    }
}
