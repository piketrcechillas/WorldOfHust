package worldOfHust;
import java.util.Random;
import java.io.IOException;

import java.util.Scanner;
import worldOfHust.Player;

public class WorldOfHustGame {
	 	public static Scanner USERINPUT = new Scanner(System.in);
	    public static Random RD = new Random();
	    public static Tile[][] Map;
	    public static Player newPlayer;
	    public static Tile currTile;

	    public static void main(String[] args) throws IOException {
	        mainMenu();
	    }

	    public static void mainMenu() throws IOException {
	        boolean status = false;
	        do {
	            IO.Welcome();
	            String selection = USERINPUT.nextLine();
	            switch (selection) {
	                case "1":
	                    newGame();
	                    status = true;
	                    break;
	                case "2":
	                    {loadPlayer();
	                    loadGame();
	                    }
	                    status = true;
	                    break;
	                case "3":
	                    exit();
	                    status = true;
	                    break;
	            }

	        } while (status == false);

	    }

	    public static void newGame() throws IOException {
	        Map map = new Map();
	        boolean status = false;
	        do {
	            IO.newGameIntroduction();
	            String selection = USERINPUT.nextLine();
	            switch (selection) {
	                case "1":
	                    status = IO.displayPlayerStats("Warrior", "Cong khoe, thu khoe "
	                            + "ky nang can bang.",
	                            100, 20, 30, 3, 0.10);
	                    newPlayer = Player.newWarrior();
	                    break;}
	        } while (status == false);
	        
	        Item.addPotion(5, newPlayer);
            Item.addClarity(5, newPlayer);

	        
	        Map = map.newRandomMap(newPlayer);
	        
            IO.replaceGrid(newPlayer);
	        IO.printGrid(newPlayer);
	        IO.resetGrid(newPlayer);
	        
	        map.mapLogic(newPlayer, Map);
	        


	    }

	    public static Player loadPlayer() {
	    	IO.load();
	    	return newPlayer;
	    }
	    
	    public static void loadGame() throws IOException {
	    	Map map = new Map();
	    	Map = map.newLoadedMap(newPlayer);
            IO.replaceGrid(newPlayer);
	        IO.printGrid(newPlayer);
	        IO.resetGrid(newPlayer);
	        map.mapLogic(newPlayer, Map);
	    }

	    public static void exit() {
	    	System.exit(0);
	    }

}
