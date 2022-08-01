package main.java.gr.pangiad.rpg;

/* All kinds of spells damage the enemy (damage range based on the dexterity of the main.java.gr.pangiad.rpg.Hero) but each kind has some
 * special powers
 */
public class Spell {
    public String name;
    public int price, minLevel, damageMin, damageMax, magicPower;
    double specialValuePercent;

    enum SpellKind {
        IceSpell,
        FireSpell,
        LightingSpell
    }

    SpellKind spellKind;

    // Constructor
    public Spell(String nm, int prc, int minLev, int dmgMin, int dmgMax, int magicP, double specialVal) {
        name = nm;
        price = prc;
        minLevel = minLev;
        damageMin = dmgMin;
        damageMax = dmgMax;
        magicPower = magicP;
        specialValuePercent = specialVal;
    }
}
