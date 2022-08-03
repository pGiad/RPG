package main.java.gr.pgiad.rpg.initializeMarketItems;

import main.java.gr.pgiad.rpg.Market;
import main.java.gr.pgiad.rpg.Spell;
import main.java.gr.pgiad.rpg.enumeration.PotionKind;
import main.java.gr.pgiad.rpg.enumeration.SpellKind;
import main.java.gr.pgiad.rpg.item.Armor;
import main.java.gr.pgiad.rpg.item.Potion;
import main.java.gr.pgiad.rpg.item.Weapon;

import java.util.ArrayList;

public class InitializeMarketItems {
    public void mainMarketInitialize(Market market) {
        // Set Market's Potions to begin with
        ArrayList<Potion> myPotions = new ArrayList<>();
        myPotions.add(new Potion("Superior Swallow", 100, 2, 70, PotionKind.STRENGTH));
        myPotions.add(new Potion("Superior White Honey", 200, 4, 100, PotionKind.STRENGTH));
        myPotions.add(new Potion("Thunderbolt", 500, 6, 150, PotionKind.STRENGTH));
        myPotions.add(new Potion("Wolven Hour", 100, 2, 70, PotionKind.AGILITY));
        myPotions.add(new Potion("Maribor Forest", 200, 4, 100, PotionKind.AGILITY));
        myPotions.add(new Potion("Killer Whale", 500, 6, 150, PotionKind.AGILITY));
        myPotions.add(new Potion("Enhanced Tawny Owl", 100, 2, 70, PotionKind.DEXTERITY));
        myPotions.add(new Potion("Enhanced Blizzard", 200, 4, 100, PotionKind.DEXTERITY));
        myPotions.add(new Potion("Black Blood", 500, 6, 150, PotionKind.DEXTERITY));
        market.setMarketPotions(myPotions);

        // Set Market's Spells to begin with
        ArrayList<Spell> mySpells = new ArrayList<>();
        mySpells.add(new Spell("Enhanced Igni", 200, 3, 70, 130, 180, 0.3, SpellKind.FIRESPELL));
        mySpells.add(new Spell("Superior Igni", 500, 5, 100, 200, 230, 0.4, SpellKind.FIRESPELL));
        mySpells.add(new Spell("Immortal Igni", 1000, 10, 180, 300, 300, 0.5, SpellKind.FIRESPELL));
        mySpells.add(new Spell("Enhanced Axii", 200, 3, 70, 130, 180, 0.3, SpellKind.ICESPELL));
        mySpells.add(new Spell("Superior Axii", 500, 5, 100, 200, 230, 0.4, SpellKind.ICESPELL));
        mySpells.add(new Spell("Immortal Axii", 1000, 10, 180, 300, 300, 0.5, SpellKind.ICESPELL));
        mySpells.add(new Spell("Enhanced Quen", 200, 3, 70, 130, 180, 0.3, SpellKind.LIGHTINGSPELL));
        mySpells.add(new Spell("Superior Quen", 500, 5, 100, 200, 230, 0.4, SpellKind.LIGHTINGSPELL));
        mySpells.add(new Spell("Immortal Quen", 1000, 10, 180, 300, 300, 0.5, SpellKind.LIGHTINGSPELL));
        market.setMarketSpells(mySpells);


        // Set Market's Weapons to begin with
        ArrayList<Weapon> myWeapons = new ArrayList<>();
        myWeapons.add(new Weapon("Anger's Tear", 2, 110, true));
        myWeapons.add(new Weapon("Hateful Reaver", 4, 150, true));
        myWeapons.add(new Weapon("Phantom Silver Claymore", 7, 220, true));
        myWeapons.add(new Weapon("Bloodied Longsword", 3, 130, false));
        myWeapons.add(new Weapon("Warped Spellblade", 6, 200, false));
        myWeapons.add(new Weapon("Purifier", 10, 250, false));
        myWeapons.add(new Weapon("Smooth Razor", 5, 170, false));
        market.setMarketWeapons(myWeapons);

        // Set Market's Armors to begin with
        ArrayList<Armor> myArmors = new ArrayList<>();
        myArmors.add(new Armor("Girdle of Brynhildr", 2, 110));
        myArmors.add(new Armor("Final Mirror", 3, 130));
        myArmors.add(new Armor("Splintercatch", 4, 150));
        myArmors.add(new Armor("Impenetrable Fortress", 5, 170));
        myArmors.add(new Armor("Organkeeper", 6, 200));
        myArmors.add(new Armor("Nerves of Steel", 8, 230));
        myArmors.add(new Armor("Couters of Confusion", 10, 260));
        market.setMarketArmors(myArmors);
    }
}
