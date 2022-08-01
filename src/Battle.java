import java.util.Scanner;

public class Battle extends Grid {
    private int heroMove(Hero myHero, Monster monster) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Choose your move: ");
        System.out.println("1. Attack");
        System.out.println("2. Cast Spell");
        System.out.println("3. Use Potion");
        System.out.println("4. Equip Armor & Weapon");

        while (true) {
            int choice = scan.nextInt();
            if (choice == 1) {
                myHero.roundAttack = myHero.strength + myHero.weaponDamage;
                monster.currentHP -= myHero.roundAttack;
                break;
            } else if (choice == 2) {
                // Choose one of your spells
                break;
            } else if (choice == 3) {
                // Choose one of your potions
                break;
            } else if (choice == 4) {
                // Choose armor and weapons from your inventory
                break;
            } else {
                System.out.println("Choose again...");
            }
        }
        return monster.currentHP;
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private int monsterMove(Hero myHero, Monster monster) {
        int attack = getRandomNumber(monster.damageMin, monster.damageMax);
        myHero.currentHP -= attack;
        return myHero.currentHP;
    }

    public void main(Hero myHero) {
        double threshold = Math.random();
        Monster monster;
        if (threshold < 0.33) {
            monster = new Monster("Name", Monster.MonsterKind.Dragon, myHero.level);
            System.out.println("Choose Dragon");
        } else if (threshold < 0.66) {
            monster = new Monster("Name", Monster.MonsterKind.Exoskeleton, myHero.level);
            System.out.println("Choose Exoskeleton");
        } else {
            monster = new Monster("Name", Monster.MonsterKind.Spirit, myHero.level);
            System.out.println("Choose Spirit");
        }

        while (true) {
            System.out.println("Hero's life: " + myHero.currentHP);
            System.out.println("Monster's life: " + monster.currentHP);
            if (heroMove(myHero, monster) <= 0) break;        // Hero won
            if (monsterMove(myHero, monster) <= 0) break;     // Monster won
            /* Restore Health Power */
            if (myHero.currentHP < myHero.healthPower - 50) myHero.currentHP += 50;
            else myHero.currentHP += (myHero.healthPower - myHero.currentHP);
            if (monster.currentHP < monster.healthPower - 50) monster.currentHP += 50;
            else monster.currentHP += (monster.healthPower - monster.currentHP);
            System.out.println("Health restored");
            /* Restore Magic Power */
            if (myHero.currentMP < myHero.magicPower - 50) myHero.currentMP += 50;
            else myHero.currentMP += (myHero.magicPower - myHero.currentMP);
            System.out.println("Magic power restored");
        }
        // If Hero lost the battle
        if (myHero.currentHP <= 0) {
            System.out.println("You lost the battle");
            myHero.currentHP = myHero.healthPower / 2;
            myHero.money = myHero.money / 2;
        }
        // If Hero won the battle
        else {
            System.out.println("You won the battle");
            myHero.money += (100 * myHero.level);
            myHero.experience += (100 * myHero.level);
        }
    }
}
