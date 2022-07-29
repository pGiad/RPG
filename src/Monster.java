public class Monster extends Living {
    public int defense, damageMin, damageMax;
    public double dodgeChance;

    enum MonsterKind {
        Dragon,
        Exoskeleton,
        Spirit
    }

    public Monster(String name, MonsterKind kind) {       // Constructor
        super(name, 5, 1000);
        if (kind == MonsterKind.Dragon) {
            defense = 300;
            damageMin = 200;
            damageMax = 300;
            dodgeChance = 0.2;
        } else if (kind == MonsterKind.Exoskeleton) {
            defense = 500;
            damageMin = 100;
            damageMax = 250;
            dodgeChance = 0.2;
        } else if (kind == MonsterKind.Spirit) {
            defense = 300;
            damageMin = 100;
            damageMax = 250;
            dodgeChance = 0.4;
        }

        System.out.println("Constructed a Monster of MonsterKind: " + kind + ", named: " + name);       // Print message
        System.out.println("Defense: " + defense);
        System.out.println("damageMin: " + damageMin);
        System.out.println("damageMax: " + damageMax);
        System.out.println("dodgeChance: " + dodgeChance);
    }

    public static void main(String[] args) {
        new Monster("White Spirit", MonsterKind.Spirit);
    }
}