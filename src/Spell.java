public abstract class Spell {
    public String name;
    public int price, minLevel, damageMin, damageMax, magicPower;

    public Spell(String nm, int prc, int minLev, int dmgMin, int dmgMax, int magicP) {
        name = nm;
        price = prc;
        minLevel = minLev;
        damageMin = dmgMin;
        damageMax = dmgMax;
        magicPower = magicP;
    }
}
