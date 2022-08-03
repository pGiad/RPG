package main.java.gr.pgiad.rpg.monsterNames;

import main.java.gr.pgiad.rpg.enumeration.MonsterKind;
import main.java.gr.pgiad.rpg.living.Monster;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MonsterNames {
    private final ArrayList<String> monsterNameList = new ArrayList<>();
    private final Random rand = new Random();
    public String monsterName(MonsterKind monsterKind) {
        if (monsterKind == MonsterKind.DRAGON) {
            monsterNameList.add("Gurvinth");
            monsterNameList.add("Longtail");
            monsterNameList.add("Duno");
            monsterNameList.add("Qyzzosdo");
            monsterNameList.add("Gundur");
            monsterNameList.add("Rypha");
            monsterNameList.add("Cyga");
            monsterNameList.add("Teperruth");
            monsterNameList.add(" The Deathlord");
        }
        else if (monsterKind == MonsterKind.EXOSKELETON) {
            monsterNameList.add("Rib Schneider");
            monsterNameList.add("Aragone");
            monsterNameList.add("Pelvis");
            monsterNameList.add("Forest Wightaker");
            monsterNameList.add("Hell 'n Hunt");
            monsterNameList.add("Bridget Bones");
            monsterNameList.add("Arhuritis");
            monsterNameList.add("Rotten Exo");
            monsterNameList.add("Bhokdad");
        }
        else {
            monsterNameList.add("Aurath");
            monsterNameList.add("Hawnt");
            monsterNameList.add("Wayke");
            monsterNameList.add("The Saluting Nurse");
            monsterNameList.add("Yuto");
            monsterNameList.add("Ligh");
            monsterNameList.add("Aerin");
            monsterNameList.add("Psyche");
            monsterNameList.add("Curce");
        }
        return  monsterNameList.get(rand.nextInt(monsterNameList.size()));
    }
}
