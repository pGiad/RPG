package main.java.gr.pangiad.rpg;

import java.util.Scanner;

public class Grid {
    public static String name;
    public String postName() { return name; }
    public static Hero.HeroKind heroKind;
    public Hero.HeroKind postHeroKind() { return heroKind; }
    public static Hero myHero;
    public Hero postHero() { return myHero; }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Choose a main.java.gr.pangiad.rpg.Hero: ");
        System.out.println("1. Warrior");
        System.out.println("2. Sorcerer");
        System.out.println("3. Paladin");

        while (true) {
            int choice = scan.nextInt();
            if (choice == 1) {
                System.out.println("You Chose a Warrior! What's his name?");
                scan.nextLine();
                name = scan.nextLine();
                heroKind = Hero.HeroKind.Warrior;
                myHero = new Hero(name, heroKind);
                break;
            } else if (choice == 2) {
                System.out.println("You chose a Sorcerer! What's his name?");
                scan.nextLine();
                name = scan.nextLine();
                heroKind = Hero.HeroKind.Sorcerer;
                myHero = new Hero(name, heroKind);
                break;
            } else if (choice == 3) {
                System.out.println("You chose a Paladin! What's his name?");
                scan.nextLine();
                name = scan.nextLine();
                heroKind = Hero.HeroKind.Paladin;
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