public abstract class Living {
    public String name;
    public int level, healthPower;

    public Living(String nm, int lev, int hP) {         // Constructor
        name = nm;
        level = lev;
        healthPower = hP;
        System.out.println("Constructed a Living");     // Print message
    }
}