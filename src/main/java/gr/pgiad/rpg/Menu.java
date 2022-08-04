package main.java.gr.pgiad.rpg;

import main.java.gr.pgiad.rpg.living.Hero;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    // If this function returns true it means that user chose to quit game
    public static boolean menu(Hero myHero) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("------------------------------------------");
            System.out.println("----------------   MENU   ----------------");
            System.out.println("------------------------------------------");
            System.out.println();
            System.out.println("1. Resume");
            System.out.println("2. Rename Your Hero");
            System.out.println("3. Quit Game");

            try {
                int choice = scan.nextInt();
                if (choice == 1) {
                    System.out.println("Resuming...");
                    System.out.println();
                    Thread.sleep(500);
                    return false;
                } else if (choice == 2) {
                    System.out.println("What's the new name for your Hero?");
                    scan.nextLine();
                    String name = scan.nextLine();
                    myHero.setName(name);
                    System.out.println("Hero renamed to: " + myHero.getName());
                } else if (choice == 3) {
                    System.out.println("Exiting Game...");
                    Thread.sleep(500);
                    return true;
                } else {
                    System.out.println("Invalid Option. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Option. Please try again.");
                scan.nextLine();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
