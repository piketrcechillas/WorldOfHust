package worldOfHust;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import worldOfHust.Tile;


public class Monster {

    private final String name;
    private final String description;
    private final int maxHitPoints;
    private int hitPoints;
    private final int minDamage;
    private final int maxDamage;
    private final int defense;
    private final double critChance;
    private final int Exp;


    public Monster(String name, String description, int maxHitPoints,
            int minDamage, int maxDamage, int defense, double critChance,
            boolean aggression, int Exp) {
        this.name = name;
        this.description = description;
        this.maxHitPoints = maxHitPoints;
        this.hitPoints = maxHitPoints;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.defense = defense;
        this.critChance = critChance;
        this.Exp = Exp;
    }

    public int attack() {
        return WorldOfHustGame.RD.nextInt(maxDamage - minDamage - 1);
    }

    public int defend(Player player) {
        int incomingAttack = player.attack();
        int random = WorldOfHustGame.RD.nextInt(99) + 1;
        if (random <= player.getCritChance()) {
            incomingAttack = incomingAttack * 2;
            IO.playerCrit();
        }
        IO.monsterHitPointsMessage(incomingAttack, this);
        double multiplier = ThreadLocalRandom.current().nextDouble(0.7, 1.3);
        double temp = (hitPoints * defense > incomingAttack)
                ? hitPoints - incomingAttack*multiplier : 0;
        hitPoints = (int) Math.round(temp);
        return hitPoints;
    }
    
    public int defendnS(Player player) {
        int incomingAttack = player.nSkill();
        IO.monsterHitPointsMessage(incomingAttack, this);
        double multiplier = ThreadLocalRandom.current().nextDouble(0.9, 1.5);
        double temp = (hitPoints * defense > incomingAttack)
                ? hitPoints - incomingAttack*multiplier : 0;
        hitPoints = (int) Math.round(temp);
        return hitPoints;
    }
    
    public int defenduS(Player player) {
        int incomingAttack = player.uSkill();
        IO.monsterHitPointsMessage(incomingAttack, this);
        double multiplier = ThreadLocalRandom.current().nextDouble(1.3, 1.9);
        double temp = (hitPoints * defense > incomingAttack)
                ? hitPoints - incomingAttack*multiplier : 0;
        hitPoints = (int) Math.round(temp);
        return hitPoints;
    }
    
    public static Monster newMonster() {
    	Monster monster = null;
    	List<Integer> weighted = Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 5);
        Random rand = new Random();
        int random = weighted.get(rand.nextInt(weighted.size()));       
        switch (random) {
            case 1:
                monster = newSlime();
                break;
            case 2:
                monster = newOrc();
                break;
            case 3:
                monster = newDragon();
                break;
            case 4:
                monster = newGhoul();
                break;
            case 5:
                monster = newBehemoth();
                break;

        }
        return monster;
    }
    
    public static Monster newBoss() {
    	Monster monster = null;
    	monster = newPrimalBahamut();
    	return monster;
    }

    public static Monster newSlime() {
        return new Monster("Slime", "Quai vat co ban, cai gi cung yeu "
              , 30, 10, 15, 2, 10, true, 50);
    }

    public static Monster newOrc() {
        return new Monster("Orc", "Mot loai thu cuc lon, cong cao thu cao "
                , 50, 15, 20, 3, 10, true, 100);
    }

    public static Monster newDragon() {
        return new Monster("Dragon", "Mot con rong bu to chang", 100, 20, 30, 4, 11, true, 150);
    }

    public static Monster newCoeurl() {
        return new Monster("Coeurl", "Mot con thu nhanh nhen va vo cung nguy hiem", 20, 15,
                35, 2, 20, true, 200);
    }

    public static Monster newGhoul() {
        return new Monster("Ghoul", "Mot bong ma", 40, 10, 25, 2, 8, false, 250);
    }

    public static Monster newBehemoth() {
        return new Monster("Behemoth", "Quai thu vo cung nguy hiem",
                40, 10, 25, 30, 8, true, 500);
    }

    public static Monster newPrimalBahamut() {
        return new Monster("Primal Bahamut", "Chua te cua loai rong",
                300, 250, 400, 75, 100, true, 1000);
    }
    
    public String getDescription() {
        return description;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public boolean isAlive() {
        return hitPoints > 0;
    }

    
    public String getName() {
        return name;
    }
    
    public int getExp() {
    	return Exp;
    }
    
  

    @Override
    public String toString() {
        return name + " " + description;
    }

    public double getCritChance() {
        return critChance;
    }
}