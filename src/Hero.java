public class Hero extends Living {
    // Defense is the amount of power that we reduce from the opponent's attack
    public int money, experience, defense, armorDefense, weaponDamage, magicPower, currentMP, strength, dexterity, agility;

    enum HeroKind {
        Warrior,
        Sorcerer,
        Paladin
    }

    HeroKind heroKind;

    // Constructor
    public Hero(String name, HeroKind kind) {
        super(name, 1, 1000);
        money = 200;
        experience = 0;
        defense = 0;
        armorDefense = 0;
        weaponDamage = 0;
        magicPower = 500;
        currentMP = 500;
        heroKind = kind;
        if (heroKind == HeroKind.Warrior) {     // Warrior has raised strength and agility
            strength = 700;
            dexterity = 500;
            agility = 700;
        } else if (heroKind == HeroKind.Sorcerer) {     // Sorcerer has raised dexterity and agility
            strength = 500;
            dexterity = 700;
            agility = 700;
        } else if (heroKind == HeroKind.Paladin) {      // Paladin has raised strength and dexterity
            strength = 700;
            dexterity = 700;
            agility = 500;
        }

        System.out.println("Constructed a Hero of kind: " + heroKind + ", named: " + name);       // Print message
        System.out.println("Money: " + money);
        System.out.println("XP: " + experience);
        System.out.println("Defense: " + defense);
        System.out.println("Magic Power: " + magicPower);
        System.out.println("Strength: " + strength);
        System.out.println("Dexterity: " + dexterity);
        System.out.println("Agility: " + agility);
    }

    // Function that changes the stats of the Hero when he has enough xp to level up
    public void levelUp() {
        this.level++;
        this.healthPower *= 2;
        this.magicPower *= 2;
        if (this.heroKind == HeroKind.Warrior) {
            this.strength += 300;
            this.dexterity += 200;
            this.agility += 300;
        } else if (this.heroKind == HeroKind.Sorcerer) {
            this.strength += 200;
            this.dexterity += 300;
            this.agility += 300;
        } else {
            this.strength += 300;
            this.dexterity += 300;
            this.agility += 200;
        }
    }

    // Function to give Hero extra defense if armor is equipped
    public void equipArmor(Armor armor) {
        armorDefense = armor.defense;
    }

    // Function to give Hero extra attack/strength if weapon is equipped
    public void equipWeapon(Weapon weapon) {
        weaponDamage = weapon.attack;
    }

    // Function to raise the value of a stat based on the potion kind that the Hero used
    public void usePotion(Potion potion) {
        Potion.PotionKind potionKind = potion.potionKind;
        switch (potionKind) {
            case Hp:
                this.currentHP += potion.gain;
            case Attack:
                this.strength += potion.gain;
            case Defense:
                this.defense += potion.gain;
            case MagicPower:
                this.currentMP += potion.gain;
        }
    }

    // Function to Trigger what should be done when a spell is used. This function should not be under this class...
    public void castSpell(Spell spell) {
        // Do the basics for all the spells....
        Spell.SpellKind spellKind = spell.spellKind;
        switch (spellKind) {
            case IceSpell:      // do something
            case FireSpell:     // ....
            case LightingSpell: // ....
        }
    }

    public static void main(String[] args) {
        new Hero("Arthur", HeroKind.Paladin);
    }
}
