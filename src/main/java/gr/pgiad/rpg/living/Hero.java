package main.java.gr.pgiad.rpg.living;

import main.java.gr.pgiad.rpg.Spell;
import main.java.gr.pgiad.rpg.enumeration.HeroKind;
import main.java.gr.pgiad.rpg.initializeHeroItems.InitializePaladinItems;
import main.java.gr.pgiad.rpg.initializeHeroItems.InitializeSorcererItems;
import main.java.gr.pgiad.rpg.initializeHeroItems.InitializeWarriorItems;
import main.java.gr.pgiad.rpg.item.Armor;
import main.java.gr.pgiad.rpg.item.Potion;
import main.java.gr.pgiad.rpg.item.Weapon;

import java.util.ArrayList;

public class Hero extends Living {
    // Defense is the amount of power that we reduce from the opponent's attack
    private int money;
    private int experience;
    private int levelUpExperience;
    private int defense;
    private int roundAttack;
    private int armorDefense;
    private int weaponDamage;
    private int magicPower;
    private int currentMP;
    private int strength;
    private int dexterity;
    private int agility;
    private HeroKind heroKind;
    private ArrayList<Weapon> weapons;
    private Weapon myWeapon;
    private ArrayList<Armor> armors;
    private Armor myArmor;
    private ArrayList<Potion> potions;
    private ArrayList<Spell> spells;

    // Constructor
    public Hero(String name, HeroKind heroKind) {
        super(name, 1, 1000);
        this.setHeroKind(heroKind);
        this.setMoney(200);
        this.setExperience(0);
        this.setLevelUpExperience(200);
        this.setDefense(0);
        this.setMagicPower(500);
        this.setCurrentMP(500);
        if (heroKind == HeroKind.WARRIOR) {
            this.setStrength(700);
            this.setDexterity(500);
            this.setAgility(700);
            InitializeWarriorItems warriorItems = new InitializeWarriorItems();
            warriorItems.main(this);
        } else if (heroKind == HeroKind.SORCERER) {
            this.setStrength(500);
            this.setDexterity(700);
            this.setAgility(700);
            InitializeSorcererItems sorcererItems = new InitializeSorcererItems();
            sorcererItems.main(this);
        } else if (heroKind == HeroKind.PALADIN) {
            this.setStrength(700);
            this.setDexterity(700);
            this.setAgility(500);
            InitializePaladinItems paladinItems = new InitializePaladinItems();
            paladinItems.main(this);
        }

        System.out.println("Constructed a Hero of kind: " + this.heroKind + ", named: " + this.getName());       // Print message
        System.out.println("Money: " + this.money);
        System.out.println("XP: " + this.experience);
        System.out.println("Defense: " + this.defense);
        System.out.println("Magic Power: " + this.magicPower);
        System.out.println("Strength: " + this.strength);
        System.out.println("Dexterity: " + this.dexterity);
        System.out.println("Agility: " + this.agility);
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getLevelUpExperience() {
        return levelUpExperience;
    }

    public void setLevelUpExperience(int levelUpExperience) {
        this.levelUpExperience = levelUpExperience;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getRoundAttack() {
        return roundAttack;
    }

    public void setRoundAttack(int roundAttack) {
        this.roundAttack = roundAttack;
    }

    public int getArmorDefense() {
        return armorDefense;
    }

    public void setArmorDefense(int armorDefense) {
        this.armorDefense = armorDefense;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    public int getMagicPower() {
        return magicPower;
    }

    public void setMagicPower(int magicPower) {
        this.magicPower = magicPower;
    }

    public int getCurrentMP() {
        return currentMP;
    }

    public void setCurrentMP(int currentMP) {
        this.currentMP = currentMP;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public HeroKind getHeroKind() {
        return heroKind;
    }

    public void setHeroKind(HeroKind heroKind) {
        this.heroKind = heroKind;
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(ArrayList<Weapon> weapons) {
        this.weapons = weapons;
    }

    public Weapon getMyWeapon() {
        return myWeapon;
    }

    public void setMyWeapon(Weapon myWeapon) {
        this.myWeapon = myWeapon;
    }

    public ArrayList<Armor> getArmors() {
        return armors;
    }

    public void setArmors(ArrayList<Armor> armors) {
        this.armors = armors;
    }

    public Armor getMyArmor() {
        return myArmor;
    }

    public void setMyArmor(Armor myArmor) {
        this.myArmor = myArmor;
    }

    public ArrayList<Potion> getPotions() {
        return potions;
    }

    public void setPotions(ArrayList<Potion> potions) {
        this.potions = potions;
    }

    public ArrayList<Spell> getSpells() {
        return spells;
    }

    public void setSpells(ArrayList<Spell> spells) {
        this.spells = spells;
    }

    // Function that changes the stats of the Hero when he has enough xp to level up
    public void levelUp() {
        this.setLevel(this.getLevel() + 1);
        this.setHealthPower(this.getHealthPower() * 2);
        this.setLevelUpExperience(this.getLevel() * this.getLevel() * 200);
        this.setMagicPower(this.getMagicPower() * 2);
        if (this.getHeroKind() == HeroKind.WARRIOR) {
            this.setStrength(this.getStrength() + 300);
            this.setDexterity(this.getDexterity() + 200);
            this.setAgility(this.getAgility() + 300);
        } else if (this.getHeroKind() == HeroKind.SORCERER) {
            this.setStrength(this.getStrength() + 200);
            this.setDexterity(this.getDexterity() + 300);
            this.setAgility(this.getAgility() + 300);
        } else {
            this.setStrength(this.getStrength() + 300);
            this.setDexterity(this.getDexterity() + 300);
            this.setAgility(this.getAgility() + 200);
        }
    }

    // Function to give Hero extra defense if armor is equipped
    public void equipArmor(int index) {
        if (this.getMyArmor() == null) {
            this.myArmor = new Armor(this.getArmors().get(index).getName(), this.getArmors().get(index).getMinLevel(),
                    this.getArmors().get(index).getDefense());
            this.getArmors().get(index).setEquipped(true);
        } else {
            this.setArmorDefense(this.getArmors().get(index).getDefense());
            this.getArmors().get(index).setEquipped(true);
            getMyArmor().setEquipped(false);
            setMyArmor(this.getArmors().get(index));
        }
    }

    // Function to give Hero extra attack/strength if weapon is equipped
    public void equipWeapon(int index) {
        if (this.getMyWeapon() == null) {
            this.myWeapon = new Weapon(this.getWeapons().get(index).getName(), this.getWeapons().get(index).getMinLevel(),
                    this.getWeapons().get(index).getAttack(), this.getWeapons().get(index).isTwoHands());
            this.getWeapons().get(index).setEquipped(true);
        } else {
            this.setWeaponDamage(this.getWeapons().get(index).getAttack());
            this.getWeapons().get(index).setEquipped(true);
            getMyWeapon().setEquipped(false);
            setMyWeapon(this.getWeapons().get(index));
        }
    }
}
