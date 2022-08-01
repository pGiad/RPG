package main.java.gr.pangiad.rpg.item;

public abstract class Item {
    public String name;
    public int price, minLevel;

    // Constructor
    public Item(String nm, int prc, int minLev) {
        name = nm;
        price = prc;
        minLevel = minLev;
    }
}
