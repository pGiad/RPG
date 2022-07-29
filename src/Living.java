public abstract class Living {
    public String name;
    public int level, healthPower, currentHP;

    // Constructor
    public Living(String nm, int lev, int hP) {
        name = nm;
        level = lev;
        healthPower = hP;
        currentHP = hP;
        System.out.println("Constructed a Living named: " + name);     // Print message
    }
}