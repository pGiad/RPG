package main.java.gr.pgiad.rpg.item;

public abstract class Item {
    private String name;
    private int price;
    private final int minLevel;

    // Constructor
    public Item(String name, int price, int minLevel) {
        this.name = name;
        this.price = price;
        this.minLevel = minLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMinLevel() {
        return minLevel;
    }
}
