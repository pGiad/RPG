package main.java.gr.pgiad.rpg;

import main.java.gr.pgiad.rpg.enumeration.HeroKind;
import main.java.gr.pgiad.rpg.living.Hero;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        String name;
        HeroKind heroKind;
        Hero myHero;
        Market market = new Market();
        Inventory inventory = new Inventory();

        System.out.println("Choose a Hero: ");
        System.out.println("1. Warrior");
        System.out.println("2. Sorcerer");
        System.out.println("3. Paladin");

        while (true) {
            try {
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
                    System.out.println("Please choose again...");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please choose again...");
                scan.nextLine();
            }
        }

        System.out.println("Your map is this: (N: Non-accessible, M: Market, X: Your Hero)");
        Grid grid = new Grid();
        mainLoop:
        while (true) {
            grid.print();
            while (true) {
                System.out.println("Please select your move:");
                System.out.println("1. Up");
                System.out.println("2. Down");
                System.out.println("3. Left");
                System.out.println("4. Right");
                System.out.println("5. Menu");
                if (grid.getLastPosition().equals("M"))
                    System.out.println("6. Enter Market");
                try {
                    int choice = scan.nextInt();
                    if (choice == 1 && Move.moveUp(grid)) {
                        break;
                    } else if (choice == 2 && Move.moveDown(grid)) {
                        break;
                    } else if (choice == 3 && Move.moveLeft(grid)) {
                        break;
                    } else if (choice == 4 && Move.moveRight(grid)) {
                        break;
                    } else if (choice == 5) {
                        if (Menu.menu(myHero))
                            break mainLoop;
                    } else if (choice == 6 && grid.getLastPosition().equals("M")) {
                        break;
                    } else {
                        System.out.println("Invalid move. Please try again.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid move. Please try again.");
                    scan.nextLine();
                }
            }

            if (grid.getLastPosition().equals(" ")) {
                double chanceToBattle = Math.random();
                if (chanceToBattle > 0.5) {
                    System.out.println("You go to Battle!");
                    Battle fight = new Battle();
                    fight.battle(myHero);
                } else {
                    System.out.println("1. Check Inventory");
                    System.out.println("2. Continue");
                    while (true) {
                        try {
                            int choice = scan.nextInt();
                            if (choice == 2) break;
                            else if (choice == 1) {
                                inventory.checkInventory(myHero);
                                break;
                            } else {
                                System.out.println("Invalid Option. Please try again.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid Option. Please try again.");
                            scan.nextLine();
                        }
                    }
                }
            } else {
                market.enterMarket(myHero);
            }
            System.out.println("EXIT");
        }
    }
}
