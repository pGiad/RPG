package main.java.gr.pgiad.rpg;

import main.java.gr.pgiad.rpg.enumeration.SpellKind;

/* All kinds of spells damage the enemy (damage range based on the dexterity of the main.java.gr.pangiad.rpg.Hero) but each kind has some
 * special powers
 */
public class Spell {
    private String name;
    private int price;
    private int minLevel;
    private int damageMin;
    private int damageMax;
    private int magicPower;
    private double specialValuePercent;
    private SpellKind spellKind;

    // Constructor
    public Spell(String name, int price, int minLevel, int damageMin, int damageMax, int magicPower
            , double specialValuePercent, SpellKind spellKind) {
        this.name = name;
        this.price = price;
        this.minLevel = minLevel;
        this.damageMin = damageMin;
        this.damageMax = damageMax;
        this.magicPower = magicPower;
        this.specialValuePercent = specialValuePercent;
        this.spellKind = spellKind;
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

    public void setMinLevel(int minLevel) {
        this.minLevel = minLevel;
    }

    public int getDamageMin() {
        return damageMin;
    }

    public void setDamageMin(int damageMin) {
        this.damageMin = damageMin;
    }

    public int getDamageMax() {
        return damageMax;
    }

    public void setDamageMax(int damageMax) {
        this.damageMax = damageMax;
    }

    public int getMagicPower() {
        return magicPower;
    }

    public void setMagicPower(int magicPower) {
        this.magicPower = magicPower;
    }

    public double getSpecialValuePercent() {
        return specialValuePercent;
    }

    public void setSpecialValuePercent(double specialValuePercent) {
        this.specialValuePercent = specialValuePercent;
    }

    public SpellKind getSpellKind() {
        return spellKind;
    }

    public void setSpellKind(SpellKind spellKind) {
        this.spellKind = spellKind;
    }
}
