package main.java.gr.pgiad.rpg.item;

import main.java.gr.pgiad.rpg.enumeration.PotionKind;
import main.java.gr.pgiad.rpg.item.Item;

public class Potion extends Item {
    private int gain;
    private PotionKind potionKind;

    // Constructor
    public Potion(String name, int price, int minLevel, int gain, PotionKind potionKind) {
        super(name, price, minLevel);
        this.gain = gain;
        this.potionKind = potionKind;
    }

    public int getGain() {
        return gain;
    }

    public void setGain(int gain) {
        this.gain = gain;
    }

    public PotionKind getPotionKind() {
        return potionKind;
    }

    public void setPotionKind(PotionKind potionKind) {
        this.potionKind = potionKind;
    }
}
