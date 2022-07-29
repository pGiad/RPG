public class Monster extends Living {
    public int defense, damageMin, damageMax;
    public double dodgeChance;

    enum MonsterKind {
        Dragon,
        Exoskeleton,
        Spirit
    }

    MonsterKind monsterKind;

    // Constructor
    public Monster(String name, MonsterKind kind) {
        super(name, 5, 1000);
        if (kind == MonsterKind.Dragon) {       // Dragons have better damage range
            defense = 300;
            damageMin = 200;
            damageMax = 300;
            dodgeChance = 0.2;
            monsterKind = kind;
        } else if (monsterKind == MonsterKind.Exoskeleton) {        // Exoskeletons have raised defense
            defense = 500;
            damageMin = 100;
            damageMax = 250;
            dodgeChance = 0.2;
        } else if (monsterKind == MonsterKind.Spirit) {        // Spirits have raised dodge chance
            defense = 300;
            damageMin = 100;
            damageMax = 250;
            dodgeChance = 0.4;
        }
        // Print message
        System.out.println("Constructed a Monster of MonsterKind: " + monsterKind + ", named: " + name);
        System.out.println("Defense: " + defense);
        System.out.println("damageMin: " + damageMin);
        System.out.println("damageMax: " + damageMax);
        System.out.println("dodgeChance: " + dodgeChance);
    }

    public static void main(String[] args) {
        new Monster("White Spirit", MonsterKind.Spirit);
    }
}