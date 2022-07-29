public class Hero extends Living {
    public int money, experience, magicPower, strength, dexterity, agility;

    enum HeroKind {
        Warrior,
        Sorcerer,
        Paladin
    }

    public Hero(String name, HeroKind kind) {       // Constructor
        super(name, 1, 1000);
        money = 200;
        experience = 0;
        magicPower = 500;
        if (kind == HeroKind.Warrior) {
            strength = 700;
            dexterity = 500;
            agility = 700;
        } else if (kind == HeroKind.Sorcerer) {
            strength = 500;
            dexterity = 700;
            agility = 700;
        } else if (kind == HeroKind.Paladin) {
            strength = 700;
            dexterity = 700;
            agility = 500;
        }

        System.out.println("Constructed a Hero of kind: " + kind + ", named: " + name);       // Print message
        System.out.println("Money: " + money);
        System.out.println("XP: " + experience);
        System.out.println("Magic Power: " + magicPower);
        System.out.println("Strength: " + strength);
        System.out.println("Dexterity: " + dexterity);
        System.out.println("Agility: " + agility);
    }

    public static void main(String[] args) {
        new Hero("Arthur", HeroKind.Paladin);
    }
}



