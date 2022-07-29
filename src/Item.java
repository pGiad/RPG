public abstract class Item {
    public String name;
    public int price, minLevel;

    public Item(String nm, int prc, int minLev) {
        name = nm;
        price = prc;
        minLevel = minLev;
    }
}
