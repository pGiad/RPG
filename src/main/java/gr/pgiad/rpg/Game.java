package main.java.gr.pgiad.rpg;

import main.java.gr.pgiad.rpg.enumeration.HeroKind;
import main.java.gr.pgiad.rpg.living.Hero;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name;
        HeroKind heroKind;
        Hero myHero;

        System.out.println("Choose a Hero: ");
        System.out.println("1. Warrior");
        System.out.println("2. Sorcerer");
        System.out.println("3. Paladin");

        while (true) {
            int choice = scan.nextInt();
            if (choice == 1) {
                System.out.println("You Chose a Warrior! What's his name?");
                scan.nextLine();
                name = scan.nextLine();
                heroKind = HeroKind.WARRIOR;
                myHero = new Hero(name, heroKind);
                break;
            } else if (choice == 2) {
                System.out.println("You chose a Sorcerer! What's his name?");
                scan.nextLine();
                name = scan.nextLine();
                heroKind = HeroKind.SORCERER;
                myHero = new Hero(name, heroKind);
                break;
            } else if (choice == 3) {
                System.out.println("You chose a Paladin! What's his name?");
                scan.nextLine();
                name = scan.nextLine();
                heroKind = HeroKind.PALADIN;
                myHero = new Hero(name, heroKind);
                break;
            } else {
                System.out.println("Choose again...");
            }
        }

        Battle battle = new Battle();
        battle.main(myHero);
    }
}
