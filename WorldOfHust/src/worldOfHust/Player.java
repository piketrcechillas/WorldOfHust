package worldOfHust;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.io.Serializable;

public class Player implements Serializable  {

    private final String name;
    private final String description;
    private int maxHitPoints;
    private int hitPoints;
    private int minDamage;
    private int maxDamage;
    private int defense;
    private double critChance;
    private int posX;
    private int posY;
    private Tile currTile;
    private List<String> inventory;
    private int Exp = 0;
    private String skillNormal;
    private int SNAtkMax;
    private int SNAtkMin;//Suc manh tan cong skillNormal
    private int SNcost;
    private String skillUltimate;
    private int SUAtkMax;
    private int SUAtkMin;
    private int SUcost;//Suc manh tan cong skillUltimate
    private int Mana;
    private int Level;
    private static final long serialVersionUID = 1;

    public Player(String name, String description, int maxHitPoints, int minDamage, int maxDamage, int defense, double critChance,  String skillNormal, int SNAtkMax, int SNAtkMin, int SNcost, String skillUltimate, int SUAtkMax, int SUAtkMin, int SUcost, int Mana, int Level) {
        this.name = name;
        this.description = description;
        this.maxHitPoints = maxHitPoints ;
        this.hitPoints = maxHitPoints;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage ;
        this.defense = defense;
        this.critChance = critChance;
        this.posX = 0;
        this.posY = 0;
        inventory = new ArrayList<>();
        this.skillNormal = skillNormal;
        this.SNAtkMax = SNAtkMax;
        this.SNAtkMin = SNAtkMin;
        this.SNcost = SNcost ;
        this.skillUltimate = skillUltimate;
        this.SUAtkMax = SUAtkMax ;
        this.SUAtkMin = SUAtkMin;
        this.SUcost = SUcost;
        this.Mana = Mana ;
        this.Level = Level;
    }
    
    public int LevelCheck() {
    	this.Level = 1;
    	if (this.Exp > 100) {this.Level = 2;}
    	if (this.Exp > 200) {this.Level = 3;}    
    	if (this.Exp > 325) {this.Level = 4;} 
        if (this.Exp > 450) {this.Level = 5;}    
    	if (this.Exp > 600) {this.Level = 6;} 
    	if (this.Exp > 750) {this.Level = 7;}
    	if (this.Exp > 900) {this.Level = 8;}    
    	if (this.Exp > 1100) {this.Level = 9;} 
    	if (this.Exp > 1300) {this.Level = 10;}    
    	if (this.Exp > 1500) {this.Level = 11;} 
    	if (this.Exp > 1700) {this.Level = 12;} 
    	return Level;
    }
    
    public Player LevelUp() {
    	this.maxDamage = maxDamage + Level*35;
    	this.minDamage = minDamage + Level*30;
    	this.hitPoints = hitPoints + Level*50;
    	this.defense = defense + Level*10;
    	this.SNAtkMax = SNAtkMax + Level*30;
    	this.SNAtkMin = SNAtkMin + Level*27;
    	this.SNcost = SNcost + Level*5;
    	this.SUAtkMax = SUAtkMax + Level*90;
    	this.SUAtkMin = SUAtkMin + Level *50;
    	this.SUcost = SUcost + Level*5;
    	this.Mana = Mana + Level*20;
    	return new Player(this.name, this.description, this.maxHitPoints, this.minDamage, this.maxDamage, this.defense, this.critChance,  this.skillNormal, this.SNAtkMax, this.SNAtkMin, this.SNcost, this.skillUltimate, this.SUAtkMax, this.SUAtkMin, this.SUcost, this.Mana, this.Level);
 }
    
    public int getLevel() {
    	return Level;
    }
    
    public int attack() {
        return WorldOfHustGame.RD.nextInt(maxDamage - minDamage + 1);
    }
    
    public int nSkill() {
    	this.Mana = Mana - SNcost;
    	return WorldOfHustGame.RD.nextInt(SNAtkMax - SNAtkMin + 1);
    }
    
    public int uSkill() {
    	this.Mana = Mana - SUcost;
    	return WorldOfHustGame.RD.nextInt(SUAtkMax - SUAtkMin + 1);
    }
    
    public int defend(Monster monster) {
        int incomingAttack = monster.attack();
        int random = WorldOfHustGame.RD.nextInt(99) + 1;
        double multiplier = ThreadLocalRandom.current().nextDouble(0.7, 1.3);
        if (random <= monster.getCritChance()) {
            incomingAttack = incomingAttack * 2;
            IO.monsterCrit(); 
        }
        IO.playerHitPointsMessage(incomingAttack, monster);
        double temp = (hitPoints * defense > incomingAttack)
                ? hitPoints - incomingAttack*multiplier : 0;
        hitPoints = (int) Math.round(temp); 
        return hitPoints;
    }

    public void heal(){
        this.hitPoints = hitPoints + 50;
        inventory.remove("potion");
    }
    
    public void resmana() {
    	this.Mana = Mana + 20;
    	inventory.remove("clarity");
    }

    public static Player newWarrior() {
        return new Player("Warrior", "Cong khoe, thu khoe "
     + "ky nang can bang.", 500, 20 ,30, 15, 10, "Braver", 70, 60, 15, "Omnislash", 250, 230, 50, 100, 1);
    }
    
    public void doubleDefense(int defense) {
    	this.defense = defense*2;
    }
    
    public void resetDefense(int defense) {
    	this.defense = defense/2;
    }
    

     public String getDescription() {
        return description;
    }

    public String getNormalSkill() {
         return skillNormal;
    }
    
    public String getUltimateSkill() {
        return skillUltimate;
    }
    
    public int getMana() {
        return Mana;
    }

    public int getSNcost() {
    	return SNcost;
    }
    
    public int getSUcost() {
    	return SUcost;
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

    public int getMaxHitPoints() {
        return maxHitPoints;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public int getDefense() {
        return defense;
    }

    public double getCritChance() {
        return critChance;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public List<String> getInventory() {
        return inventory;
    }


    public Tile getCurrTile() {
        return currTile;
    }

    public void setCurrTile(Tile tile) {
        currTile = tile;
    }

    public void setCurrX(int posX) {
        this.posX = posX;
    }

    public void setCurrY(int posY) {
        this.posY = posY;
    }
    
    public int getExp() {
    	return Exp;
    }
    
    public void setExp(int Exp) {
    	this.Exp = Exp;
    }
}