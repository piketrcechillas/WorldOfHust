package worldOfHust;
import java.util.Random;
import worldOfHust.Player;
import java.util.concurrent.ThreadLocalRandom;
import java.io.*;
import java.util.List;
import java.util.Arrays;

public final class Tile {

    private final String description;
    private final Monster monster;
    private final int numOfMonsters;
    private final boolean isBoss;
    static Player player;
    private int numOfMonster = 0;


    //private final boolean lighting;

    private Tile(String description, Monster monster, boolean isBoss,
            int numOfMonsters) {
        this.description = description;
        this.monster = monster;
        this.isBoss = isBoss;
        this.numOfMonsters = numOfMonsters;
    }

    public static Tile newTile() {
    	
    	String[][] OriginalMap = new String[][]{
    		{"1", "1", "1", "1", "2", "2", "0", "0", "0", "0"},
        	{"1", "1", "1", "0", "0", "0", "0", "0", "0", "0"},
        	{"1", "3", "3", "3", "0", "0", "0", "0", "0", "5"},
        	{"1", "3", "3", "3", "3", "0", "0", "0", "5", "5"},
        	{"1", "3", "3", "3", "3", "0", "0", "0", "0", "0"},
        	{"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
        	{"0", "0", "0", "0", "0", "0", "1", "0", "1", "0"},
         	{"0", "0", "0", "0", "0", "1", "0", "0", "0", "1"},
         	{"0", "0", "1", "1", "1", "1", "0", "4", "0", "1"},
         	{"1", "1", "1", "1", "1", "1", "1", "1", "1", "1"}};
    
        String description = null;
        int numOfMonsters = 0;
        
        List<Integer> weighted = Arrays.asList(1, 1, 1, 1, 1, 1, 1, 0, 0, 0);
        Random rand = new Random();
        int random = weighted.get(rand.nextInt(weighted.size()));
 
        
        String terrain = Integer.toString(WorldOfHustGame.RD.nextInt(5)+1);
        
        switch (terrain) {
            case "0":
                description = "Dong bang";
                numOfMonsters = random;
                break;
            case "1":
                description = "Rung cay";
                numOfMonsters = random;
                break;
            case "2":
                description = "Ngon nui";
                numOfMonsters = random;
                break;
            case "3":
                description = "Ho nuoc";
                numOfMonsters = random;
                break;      
            case "4":
                description = "Dam lay";
                numOfMonsters = random;
                break;
            case "5":
                description = "Nui lua";
                numOfMonsters = random;
                break;
        }
       
    
        	return new Tile(description, Monster.newMonster(), false, numOfMonsters);

      
    }
    
  public static Tile newBossTile() {  	
        String description = "Ban da den vi tri cuoi cung, hang o cua vi than rong!";
        int numOfMonsters = 1;
        return new Tile(description, Monster.newBoss(), true, numOfMonsters);
    }

	public Tile TileReader(Player player) {
		return new Tile(description, Monster.newMonster(), false,
		        numOfMonsters);}

    @Override
    public String toString() {
        return description;
    }

    public String getDescription() {
        return description;
    }

    public Monster getMonster() {
        return monster;
    }

    public int getNumOfMonsters() {
        return numOfMonsters;
    }
    
    public boolean haveMon() {
    	return numOfMonsters > 0;
    }
    
    public boolean noMon() {
    	return numOfMonsters == 0;
    }
   
}
