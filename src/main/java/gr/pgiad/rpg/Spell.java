package main.java.gr.pgiad.rpg;

import main.java.gr.pgiad.rpg.enumeration.SpellKind;

/* All kinds of spells damage the enemy (damage range based on the dexterity of the Hero) but each kind has some
 * special powers
 */
public record Spell(String name, int price, int minLevel, double damageMin, double damageMax, int magicPower,
                    double specialValuePercent, SpellKind spellKind) {
}
