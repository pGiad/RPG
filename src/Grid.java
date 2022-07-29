import java.util.Scanner;

public class Grid{

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Choose a Hero: ");
        System.out.println("1. Warrior");
        System.out.println("2. Sorcerer");
        System.out.println("3. Paladin");

        while(true) {
            int choice = scan.nextInt();
            if (choice == 1) {
                System.out.println("You Chose a Warrior! What's his name?");
                scan.nextLine();
                new Hero(scan.nextLine(), Hero.HeroKind.Warrior);
                break;
            } else if (choice == 2) {
                System.out.println("You chose a Sorcerer! What's his name?");
                scan.nextLine();
                new Hero(scan.nextLine(), Hero.HeroKind.Sorcerer);
                break;
            } else if (choice == 3) {
                System.out.println("You chose a Paladin! What's his name?");
                scan.nextLine();
                new Hero(scan.nextLine(), Hero.HeroKind.Paladin);
                break;
            } else {
                System.out.println("Choose again...");
            }
        }
    }
}