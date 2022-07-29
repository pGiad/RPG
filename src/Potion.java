public class Potion extends Item {
    public int gain;

    // A potion can raise Hero's HP, Attack/Damage, Defense or Magic Power
    enum PotionKind {
        Hp,
        Attack,
        Defense,
        MagicPower
    }

    PotionKind potionKind;

    // Constructor
    public Potion(String name, int price, int minLevel, PotionKind kind, int gn) {
        super(name, price, minLevel);
        potionKind = kind;
        gain = gn;
    }
}
