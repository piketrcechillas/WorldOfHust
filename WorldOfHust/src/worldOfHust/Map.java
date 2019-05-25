package worldOfHust;
import java.io.IOException;

public class Map {

    private static boolean north = false;
    private static boolean south = false;
    private static boolean west = false;
    private static boolean east = false;

    public static String[][] OriginalMap = new String[][]{
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

    public static Tile[][] newRandomMap(Player player) {
        Tile[][] tile = new Tile[10][10];
        player.setCurrX(9);
        player.setCurrY(0);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
            	if(i==0&&j==9) 
            		tile[i][j] = Tile.newBossTile();
            	else if (i==5&&j==4) 
            		tile[i][j] = Tile.newBossTile();
            	else
            		tile[i][j] = Tile.newTile();
            };      
        };
        return tile;
    }

    public static Tile[][] newLoadedMap(Player player) {
        Tile[][] tile = new Tile[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
            	if(i==0&&j==9) 
            		tile[i][j] = Tile.newBossTile();
            	else if (i==5&&j==4) 
            		tile[i][j] = Tile.newBossTile();
            	else
            		tile[i][j] = Tile.newTile();
            };   
        };  return tile; 
    }
    
    

    public boolean tileExists(int x, int y) {
        return  (rowExists(x)) && (colExists(y));
    }

    public boolean rowExists(int x){
        return  (x >= 0) && (x < 10);
    }

    public boolean colExists(int y){
        return  (y >= 0) && (y < 10);
    }

    public void playerMovement(Player player) {
        north = tileExists(player.getPosX() - 1, player.getPosY());
        south = tileExists(player.getPosX() + 1, player.getPosY() );
        east = tileExists(player.getPosX(), player.getPosY() + 1);
        west = tileExists(player.getPosX(), player.getPosY() - 1);
        IO.movePlayer(player);

    }

    public void battle(Player player, Monster monster, Tile[][] currPos) throws IOException {
        IO.battleIntro(player, currPos[player.getPosX()][player.getPosY()]);
        IO.battle(player, monster);
    }

    public void mapLogic(Player player, Tile[][] currPos) throws IOException {
        while (player.isAlive()) {
            if (player.isAlive() && currPos[player.getPosX()][player.getPosY()].getMonster().isAlive() && currPos[player.getPosX()][player.getPosY()].haveMon()) {
                battle(player, currPos[player.getPosX()][player.getPosY()]
                        .getMonster(), WorldOfHustGame.Map);
            } else if (player.isAlive() && currPos[player.getPosX()][player.getPosY()].noMon()) {
            	IO.battleSkip(player, currPos[player.getPosX()][player.getPosY()]);
                playerMovement(player);
            }
            else if (player.isAlive()) {
            	 playerMovement(player);
            }
        }
    }
    

    public static boolean isNorthDirection() {
        return north;
    }

    public static boolean isSouthDirection() {
        return south;
    }

    public static boolean isWestDirection() {
        return west;
    }

    public static boolean isEastDirection() {
        return east;
    }

}
