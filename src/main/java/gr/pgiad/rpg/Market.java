package main.java.gr.pgiad.rpg;

import main.java.gr.pgiad.rpg.enumeration.PotionKind;
import main.java.gr.pgiad.rpg.item.Armor;
import main.java.gr.pgiad.rpg.item.Potion;
import main.java.gr.pgiad.rpg.item.Weapon;
import main.java.gr.pgiad.rpg.living.Hero;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Market {
    private ArrayList<Potion> marketPotions;
    private ArrayList<Spell> marketSpells;
    private ArrayList<Weapon> marketWeapons;
    private ArrayList<Armor> marketArmors;

    public ArrayList<Potion> getMarketPotions() {
        return marketPotions;
    }

    public void setMarketPotions(ArrayList<Potion> marketPotions) {
        this.marketPotions = marketPotions;
    }

    public ArrayList<Spell> getMarketSpells() {
        return marketSpells;
    }

    public void setMarketSpells(ArrayList<Spell> marketSpells) {
        this.marketSpells = marketSpells;
    }

    public ArrayList<Weapon> getMarketWeapons() {
        return marketWeapons;
    }

    public void setMarketWeapons(ArrayList<Weapon> marketWeapons) {
        this.marketWeapons = marketWeapons;
    }

    public ArrayList<Armor> getMarketArmors() {
        return marketArmors;
    }

    public void setMarketArmors(ArrayList<Armor> marketArmors) {
        this.marketArmors = marketArmors;
    }

    public void main(Hero myHero) {
        Scanner scan = new Scanner(System.in);
        System.out.println();
        System.out.println("--------------------------------------------------");
        System.out.println("--------------------  MARKET  --------------------");
        System.out.println("--------------------------------------------------");
        System.out.println();

        System.out.println("#   Market's Potions: ");
        if (this.getMarketPotions() == null || this.getMarketPotions().isEmpty()) {
            System.out.println("Market has no available Potions.");
        } else {
            for (int i = 0; i < this.getMarketPotions().size(); i++) {
                System.out.println((i + 1) + ". " + this.getMarketPotions().get(i).getName());
            }
        }
        System.out.println();

        System.out.println("#   Market's Spells: ");
        if (this.getMarketSpells() == null || this.getMarketSpells().isEmpty()) {
            System.out.println("Market has no available Spells.");
        } else {
            for (int i = 0; i < this.getMarketSpells().size(); i++) {
                System.out.println((i + 1) + ". " + this.getMarketSpells().get(i).getName());
            }
        }
        System.out.println();

        System.out.println("#   Market's Weapons: ");
        if (this.getMarketWeapons() == null || this.getMarketWeapons().isEmpty()) {
            System.out.println("Market has no available Weapons.");
        } else {
            for (int i = 0; i < this.getMarketWeapons().size(); i++) {
                System.out.println((i + 1) + ". " + this.getMarketWeapons().get(i).getName());
            }
        }
        System.out.println();

        System.out.println("#   Market's Armors: ");
        if (this.getMarketArmors() == null || this.getMarketArmors().isEmpty()) {
            System.out.println("Market has no available Armors.");
        } else {
            for (int i = 0; i < this.getMarketArmors().size(); i++) {
                System.out.println((i + 1) + ". " + this.getMarketArmors().get(i).getName());
            }
        }
        System.out.println();
        System.out.println();

        System.out.println("#   Hero's Potions: ");
        if (myHero.getPotions() == null || myHero.getPotions().isEmpty()) {
            System.out.println("You have no Potions.");
        } else {
            for (int i = 0; i < myHero.getPotions().size(); i++) {
                System.out.println((i + 1) + ". " + myHero.getPotions().get(i).getName());
            }
        }
        System.out.println();

        System.out.println("#   Hero's Spells: ");
        if (myHero.getSpells() == null || myHero.getSpells().isEmpty()) {
            System.out.println("You have no Spells.");
        } else {
            for (int i = 0; i < myHero.getSpells().size(); i++) {
                System.out.println((i + 1) + ". " + myHero.getSpells().get(i).getName());
            }
        }
        System.out.println();

        System.out.println("#   Hero's Weapons: ");
        if (myHero.getWeapons() == null || myHero.getWeapons().isEmpty()) {
            System.out.println("You have no Weapons.");
        } else {
            for (int i = 0; i < myHero.getWeapons().size(); i++) {
                System.out.println((i + 1) + ". " + myHero.getWeapons().get(i).getName());
            }
        }
        System.out.println();

        System.out.println("#   Hero's Armors: ");
        if (myHero.getArmors() == null || myHero.getArmors().isEmpty()) {
            System.out.println("You have no Armors.");
        } else {
            for (int i = 0; i < myHero.getArmors().size(); i++) {
                System.out.println((i + 1) + ". " + myHero.getArmors().get(i).getName());
            }
        }
        System.out.println();
        System.out.println();

        while (true) {
            System.out.println("#   Kind of transaction: ");
            System.out.println("1. Buy");
            System.out.println("2. Sell");
            System.out.println("3. Leave Market");
            int transactionChoice;
            while (true) {
                try {
                    transactionChoice = scan.nextInt();
                    if (transactionChoice < 1 || transactionChoice > 3) {
                        throw new InputMismatchException();
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid Transaction. Please choose again.");
                    scan.nextLine();
                }
            }
            if (transactionChoice == 3) break;

            System.out.println();
            System.out.println("#   Kind of Item: ");
            System.out.println("1. Potion");
            System.out.println("2. Spell");
            System.out.println("3. Weapon");
            System.out.println("4. Armor");
            int itemChoice;
            while (true) {
                try {
                    itemChoice = scan.nextInt();
                    if (itemChoice > 4 || itemChoice < 1) {
                        throw new InputMismatchException();
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid Item. Please choose again.");
                    scan.nextLine();
                }
            }

            if (transactionChoice == 1) {           // If User wants to buy from market
                if (itemChoice == 1) {              // Potion
                    if (this.getMarketPotions() == null || this.getMarketPotions().isEmpty()) {
                        System.out.println("There are no Potions to buy.");
                    } else {
                        System.out.println("Available Potions to buy: ");
                        for (int i = 0; i < this.getMarketPotions().size(); i++) {
                            System.out.println((i + 1) + ". " + this.getMarketPotions().get(i).getName());
                        }
                        while (true) {
                            try {
                                int potionToBuy = scan.nextInt();
                                if (potionToBuy > 0 && potionToBuy <= this.getMarketPotions().size()) {
                                    if (myHero.getMoney() >= this.getMarketPotions().get(potionToBuy - 1).getPrice()) {
                                        if (myHero.getLevel() >= this.getMarketPotions().get(potionToBuy - 1).getMinLevel()) {
                                            myHero.setMoney(myHero.getMoney() - this.getMarketPotions().get(potionToBuy - 1).getPrice());
                                            myHero.getPotions().add(this.marketPotions.get(potionToBuy - 1));
                                            this.getMarketPotions().remove(this.marketPotions.get(potionToBuy - 1));
                                            break;
                                        } else {
                                            System.out.println("Your level is too low for this Potion.");
                                        }
                                    } else {
                                        System.out.println("You have not enough money to buy this Potion.");
                                    }
                                } else {
                                    System.out.println("Invalid potion. Please try again.");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid potion. Please try again.");
                                scan.nextLine();
                            }
                        }
                    }
                } else if (itemChoice == 2) {
                    if (this.getMarketSpells() == null || this.getMarketSpells().isEmpty()) {
                        System.out.println("There are no Spells to buy.");
                    } else {
                        System.out.println("Available Spells to buy: ");
                        for (int i = 0; i < this.getMarketSpells().size(); i++) {
                            System.out.println((i + 1) + ". " + this.getMarketSpells().get(i).getName());
                        }
                        while (true) {
                            try {
                                int spellToBuy = scan.nextInt();
                                if (spellToBuy > 0 && spellToBuy <= this.getMarketSpells().size()) {
                                    if (myHero.getMoney() >= this.getMarketSpells().get(spellToBuy - 1).getPrice()) {
                                        if (myHero.getLevel() >= this.getMarketSpells().get(spellToBuy - 1).getMinLevel()) {
                                            myHero.setMoney(myHero.getMoney() - this.getMarketSpells().get(spellToBuy - 1).getPrice());
                                            myHero.getSpells().add(this.marketSpells.get(spellToBuy - 1));
                                            this.getMarketSpells().remove(this.marketSpells.get(spellToBuy - 1));
                                            break;
                                        } else {
                                            System.out.println("Your level is too low for this Spell.");
                                        }
                                    } else {
                                        System.out.println("You have not enough money to buy this Spell.");
                                    }
                                } else {
                                    System.out.println("Invalid spell. Please try again.");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid spell. Please try again.");
                                scan.nextLine();
                            }
                        }
                    }
                } else if (itemChoice == 3) {
                    if (this.getMarketWeapons() == null || this.getMarketWeapons().isEmpty()) {
                        System.out.println("There are no Weapons to buy.");
                    } else {
                        System.out.println("Available Weapons to buy: ");
                        for (int i = 0; i < this.getMarketWeapons().size(); i++) {
                            System.out.println((i + 1) + ". " + this.getMarketWeapons().get(i).getName());
                        }
                    }
                    while (true) {
                        try {
                            int weaponToBuy = scan.nextInt();
                            if (weaponToBuy > 0 && weaponToBuy <= this.getMarketWeapons().size()) {
                                if (myHero.getMoney() >= this.getMarketWeapons().get(weaponToBuy - 1).getPrice()) {
                                    if (myHero.getLevel() >= this.getMarketWeapons().get(weaponToBuy - 1).getMinLevel()) {
                                        myHero.setMoney(myHero.getMoney() - this.getMarketWeapons().get(weaponToBuy - 1).getPrice());
                                        myHero.getWeapons().add(this.marketWeapons.get(weaponToBuy - 1));
                                        this.getMarketWeapons().remove(this.marketWeapons.get(weaponToBuy - 1));
                                        break;
                                    } else {
                                        System.out.println("Your level is too low for this Weapon.");
                                    }
                                } else {
                                    System.out.println("You have not enough money to buy this Weapon.");
                                }
                            } else {
                                System.out.println("Invalid weapon. Please try again.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid weapon. Please try again.");
                            scan.nextLine();
                        }
                    }
                } else {
                    if (this.getMarketArmors() == null || this.getMarketArmors().isEmpty()) {
                        System.out.println("There are no Armors to buy.");
                    } else {
                        System.out.println("Available Armors to buy: ");
                        for (int i = 0; i < this.getMarketArmors().size(); i++) {
                            System.out.println((i + 1) + ". " + this.getMarketArmors().get(i).getName());
                        }
                    }
                    while (true) {
                        try {
                            int armorToBuy = scan.nextInt();
                            if (armorToBuy > 0 && armorToBuy <= this.getMarketArmors().size()) {
                                if (myHero.getMoney() >= this.getMarketArmors().get(armorToBuy - 1).getPrice()) {
                                    if (myHero.getLevel() >= this.getMarketArmors().get(armorToBuy - 1).getMinLevel()) {
                                        myHero.setMoney(myHero.getMoney() - this.getMarketArmors().get(armorToBuy - 1).getPrice());
                                        myHero.getArmors().add(this.marketArmors.get(armorToBuy - 1));
                                        this.getMarketArmors().remove(this.marketArmors.get(armorToBuy - 1));
                                        break;
                                    } else {
                                        System.out.println("Your level is too low for this Armor.");
                                    }
                                } else {
                                    System.out.println("You have not enough money to buy this Armor.");
                                }
                            } else {
                                System.out.println("Invalid armor. Please try again.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid armor. Please try again.");
                            scan.nextLine();
                        }
                    }
                }
            } else {
                if (itemChoice == 1) {
                    if (myHero.getPotions() == null || myHero.getPotions().isEmpty()) {
                        System.out.println("You have no Potions to sell.");
                    } else {
                        System.out.println("Available Potions to sell: ");
                        for (int i = 0; i < myHero.getPotions().size(); i++) {
                            System.out.println((i + 1) + ". " + myHero.getPotions().get(i).getName());
                        }
                    }
                    while (true) {
                        try {
                            int potionToSell = scan.nextInt();
                            if (potionToSell > 0 && potionToSell <= myHero.getPotions().size()) {
                                myHero.setMoney(myHero.getMoney() + (myHero.getPotions().get(potionToSell - 1).getPrice() / 2));
                                this.getMarketPotions().add(myHero.getPotions().get(potionToSell - 1));
                                myHero.getPotions().remove(myHero.getPotions().get(potionToSell - 1));
                                break;
                            } else {
                                System.out.println("Invalid potion. Please try again.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid potion. Please try again.");
                            scan.nextLine();
                        }
                    }
                }
                else if (itemChoice == 2) {
                    if (myHero.getSpells() == null || myHero.getSpells().isEmpty()) {
                        System.out.println("You have no Spells to sell.");
                    } else {
                        System.out.println("Available Spells to sell: ");
                        for (int i = 0; i < myHero.getSpells().size(); i++) {
                            System.out.println((i + 1) + ". " + myHero.getSpells().get(i).getName());
                        }
                    }
                    while (true) {
                        try {
                            int spellToSell = scan.nextInt();
                            if (spellToSell > 0 && spellToSell <= myHero.getSpells().size()) {
                                myHero.setMoney(myHero.getMoney() + (myHero.getSpells().get(spellToSell - 1).getPrice() / 2));
                                this.getMarketSpells().add(myHero.getSpells().get(spellToSell - 1));
                                myHero.getSpells().remove(myHero.getSpells().get(spellToSell - 1));
                                break;
                            } else {
                                System.out.println("Invalid spell. Please try again.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid spell. Please try again.");
                            scan.nextLine();
                        }
                    }
                }
                else if (itemChoice == 3) {
                    if (myHero.getWeapons() == null || myHero.getWeapons().isEmpty()) {
                        System.out.println("You have no Weapons to sell.");
                    } else {
                        System.out.println("Available Weapons to sell: ");
                        for (int i = 0; i < myHero.getWeapons().size(); i++) {
                            System.out.println((i + 1) + ". " + myHero.getWeapons().get(i).getName());
                        }
                    }
                    while (true) {
                        try {
                            int weaponToSell = scan.nextInt();
                            if (weaponToSell > 0 && weaponToSell <= myHero.getWeapons().size()) {
                                myHero.setMoney(myHero.getMoney() + (myHero.getWeapons().get(weaponToSell - 1).getPrice() / 2));
                                this.getMarketWeapons().add(myHero.getWeapons().get(weaponToSell - 1));
                                myHero.getWeapons().remove(myHero.getWeapons().get(weaponToSell - 1));
                                break;
                            } else {
                                System.out.println("Invalid weapon. Please try again.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid weapon. Please try again.");
                            scan.nextLine();
                        }
                    }
                }
                else {
                    if (myHero.getArmors() == null || myHero.getArmors().isEmpty()) {
                        System.out.println("You have no Armors to sell.");
                    } else {
                        System.out.println("Available Armors to sell: ");
                        for (int i = 0; i < myHero.getArmors().size(); i++) {
                            System.out.println((i + 1) + ". " + myHero.getArmors().get(i).getName());
                        }
                    }
                    while (true) {
                        try {
                            int armorToSell = scan.nextInt();
                            if (armorToSell > 0 && armorToSell <= myHero.getArmors().size()) {
                                myHero.setMoney(myHero.getMoney() + (myHero.getArmors().get(armorToSell - 1).getPrice() / 2));
                                this.getMarketArmors().add(myHero.getArmors().get(armorToSell - 1));
                                myHero.getArmors().remove(myHero.getArmors().get(armorToSell - 1));
                                break;
                            } else {
                                System.out.println("Invalid armor. Please try again.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid armor. Please try again.");
                            scan.nextLine();
                        }
                    }
                }
            }
        }
    }
}
