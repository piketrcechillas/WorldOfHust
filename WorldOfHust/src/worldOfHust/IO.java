package worldOfHust;
import java.io.*;
import java.io.Serializable;
import java.util.Collections;
import worldOfHust.Item;
import java.io.IOException;

import java.util.Arrays;
public class IO {
		public static String temp;
		public static final String ANSI_RESET = "\u001B[0m";
		public static final String ANSI_BLACK = "\u001B[30m";
		public static final String ANSI_RED = "\u001B[91m";
		public static final String ANSI_GREEN = "\u001B[32m";
		public static final String ANSI_YELLOW = "\u001B[33m";
		public static final String ANSI_BLUE = "\u001B[34m";
		public static final String ANSI_PURPLE = "\u001B[35m";
		public static final String ANSI_CYAN = "\u001B[36m";
		public static final String ANSI_WHITE = "\u001B[37m";
		

    	public static void cls() {  
    	    System.out.print("\033[H\033[2J");  
    	    System.out.flush();  
    	}    
    	
    	
		public static void playerCrit() {
	        System.out.println("Mot kich Tri mang (x2 Damage)");
	    }

	    public static void monsterCrit() {
	        System.out.println("Quai vat phat dong 1 kich Tri mang "
	                + "(x2 Damage)");
	    }

	    public static void Welcome() {
	        System.out.println("Welcome traveler.......");
	        System.out.println("To the World of HUST! ");
	        System.out.println("-----------------------");
	        System.out.println("       MAIN MENU       ");
	        System.out.println("_______________________");
	        System.out.println();
	        System.out.println(" 1.    Tro choi moi     ");
	        System.out.println();
	        System.out.println(" 2.    Tai save file      ");
	        System.out.println();
	        System.out.println(" 3.    Thoat       ");
	        System.out.println();
	        System.out.print("Hay lua chon: ");
	        System.out.println();
	        System.out.println();
	        System.out.println();
	    }

	    public static void newGameIntroduction() {
	        System.out.println("------------------");
	        System.out.println("CHON NHAN VAT CUA BAN");
	        System.out.println("------------------");
	        System.out.println();
	        System.out.println("1. WARRI0R");
	        System.out.println("----------");
	        System.out.println("Cong khoe, thu khoe " 
	        		  + "ky nang can bang..");
	        System.out.println();
	 
	    }
	   
	    public static void printGrid(Player player)
	    {  System.out.println();
	       for(int i = 0; i < 10; i++)
	       {
	          for(int j = 0; j < 10; j++)
	          {	if ((player.getPosX()==i)&&(player.getPosY()==j))
	            System.out.print("  " + Map.OriginalMap[i][j]);	 
	          	else
	          	switch (Map.OriginalMap[i][j]) {
	          		case "0":
	          			System.out.print("  " + "0");
	          			break;
	          		case "1":
	          			System.out.print("  " + "t");
	          			break;
	          		case "2":  
	          			System.out.print("  " + "^");
	          			break;
	          		case "3":
	          			System.out.print("  " + "/");	
	          			break;      
	          		case "4":
	          			System.out.print("  " + "/");	
	          			break;
	          		case "5":
	          			System.out.print("  " + "^");	
	          			break;
	        }
	          		
	        	
	          }
	          System.out.println();
	       }
	    }
	    
	    public static void replaceGrid(Player player)
	    {
	       for (int i = 0; i < 10; i++)
	       {
	          for (int j = 0; j < 10; j++)
	          {
	             if ((player.getPosX()==i)&&(player.getPosY()==j)) {
	            	 temp = Map.OriginalMap[i][j];
	            	 Map.OriginalMap[i][j] = "X";
	            	 
	          }
	       }
	    }
	    }
	    
	    public static void resetGrid(Player player)
	    {
	       for (int i = 0; i < 10; i++)
	       {
	          for (int j = 0; j < 10; j++)
	          {
	             if ((player.getPosX()==i)&&(player.getPosY()==j)) {
	            	 Map.OriginalMap[i][j] = temp;
	          }
	       }
	    }
	    }
	    
	    public static boolean displayPlayerStats(String name, String description,
	            int maxHitPoints, int minDamage, int maxDamage, int defense,
	            double critChance) {
	        System.out.println(name);
	        System.out.println("-------");
	        System.out.println(description);
	        System.out.println();
	        System.out.println("MAX HP: " + maxHitPoints);
	        System.out.println();
	        System.out.println("ATTACK: " + minDamage + "-" + maxDamage);
	        System.out.println();
	        System.out.println("DEFENSE: " + defense);
	        System.out.println();
	        System.out.println("CRIT CHANCE: " + critChance + "%");
	        System.out.println();
	        System.out.println("BAN CHAC CHAN MUON CHOI NHAN VAT NAY: " + name.toUpperCase() + "? " + "(y/n)");
	        System.out.println();
	        System.out.println();
	        System.out.println();
	        if (WorldOfHustGame.USERINPUT.nextLine().equals("y")) {
	            return true;
	        } else {
	            return false;
	        }
	    }
	    

	    public static void movePlayer(Player player) {
	    	System.out.println("Ban co muon luu tro choi khong (y/n)");
	    	if (WorldOfHustGame.USERINPUT.nextLine().equals("y"))
	           {IO.save(player);
	    		IO.savePosX(player);
	    		IO.savePosY(player);}

	    	
	    	if ((Map.isNorthDirection() == false)&&(Map.isEastDirection() == false)) {
		        	System.out.println("Chuc mung ban da den duoc lau dai, danh bai Bahamut va giai cuu cong chua ");
		        	System.exit(0) ;
		        }
	    	System.out.print("Ban muon di chuyen theo huong nao? ");
	    	System.out.println();
	        if (Map.isNorthDirection() == true) {
	            System.out.println("ve phia Bac (w)\n");
	        }
	        if (Map.isSouthDirection() == true) {
	            System.out.println("ve phia Nam (s)\n");
	        }
	        if (Map.isEastDirection() == true) {
	            System.out.println("ve phia Dong (d)\n");
	        }
	        if (Map.isWestDirection() == true) {
	            System.out.println("ve phia Tay (a)\n");
	        }
	       
	        
	        
	        String selection = WorldOfHustGame.USERINPUT.nextLine();
	        int tempPosX = player.getPosX() + 1;
	    	int tempPosY = player.getPosY() + 1;
	        if (selection.equals("w") && Map.isNorthDirection()) {
	        	player.setCurrX(player.getPosX() - 1);
	            System.out.print("Vi tri hien tai cua ban la: " + "[" + tempPosX + "]" + "[" + tempPosY + "]" + "\n");
	        } else if (selection.equals("s") && Map.isSouthDirection()) {
	            player.setCurrX(player.getPosX() + 1);
	            System.out.print("Vi tri hien tai cua ban la: " + "[" + tempPosX + "]" + "[" + tempPosY + "]" + "\n");
	        } else if (selection.equals("d") && Map.isEastDirection()) {
	            player.setCurrY(player.getPosY() + 1);
	            System.out.print("Vi tri hien tai cua ban la: " + "[" + tempPosX + "]" + "[" + tempPosY + "]" + "\n");
	        } else if (selection.equals("d") && Map.isWestDirection()) {
	            player.setCurrY(player.getPosY() - 1);
	            System.out.print("Vi tri hien tai cua ban la: " + "[" + tempPosX + "]" + "[" + tempPosY + "]" + "\n");
	        }
	        IO.replaceGrid(player);
	        IO.printGrid(player);
	        IO.resetGrid(player);
	    }

	    public static void battleIntro(Player player, Tile tile) throws IOException {
	     	int tempPosX = player.getPosX() + 1;
	    	int tempPosY = player.getPosY() + 1;
	        System.out.println("Ban vao khu vuc [" + tempPosX + "][" + tempPosY + "]");
	        System.out.println(tile.getDescription() + "\n\n");
	        System.out.println("So luong quai vat: " + tile.getNumOfMonsters());
	        	{	System.out.println("Quai vat " + tile.getMonster().getName()
	                + " bat dau tran chien voi ban.\n");
	            	System.out.println("Ban buoc vao tran chien!");}
	    }

	    public static void battle(Player player, Monster monster) {
	    	int check = player.getLevel();
	        while (player.isAlive() && monster.isAlive()) {
	            System.out.println("\nMonster HP: " + monster.getHitPoints()
	                    + "    " + "Player HP/MP: " + player.getHitPoints() + "/" + player.getMana());
	            System.out.println("----------------------------------");
	            System.out.print("\nAttack (a)   Item (i)   Defend (d)  Skill(s)");
	            String action = WorldOfHustGame.USERINPUT.nextLine();
	            if (action.equals("a")) {
	                monster.defend(player);
	                if (monster.isAlive()) {
	                    player.defend(monster);

	                }
	            } 
	            
	            
	            else if (action.equals("d")) {
	            	player.doubleDefense(player.getDefense());
	            	player.defend(monster);
	            	player.resetDefense(player.getDefense());
	  
	            }
	            
	            
	            else if (action.equals("s")) {
	            	System.out.println("Hay lua chon ky nang:");
	            	System.out.println(player.getNormalSkill() + "(1), tieu ton " + player.getSNcost() + " Mana");
	            	System.out.println(player.getUltimateSkill() + "(2), tieu ton " + player.getSUcost() + " Mana");
	            	int select = WorldOfHustGame.USERINPUT.nextInt();
	            	switch (select) {
	            	case 1: if (player.getSNcost() <= player.getMana()) {
	            				monster.defendnS(player);
	            				if (monster.isAlive()) {
	            					player.defend(monster);
	            				};}
	            				
	            	
	            			else {
	            				System.out.println("Khong du mana");
	            			
	            			}
	            	
	            	case 2:
	            			if (player.getSUcost() <= player.getMana()) {
	            				monster.defenduS(player);
	            				if (monster.isAlive()) {
            					player.defend(monster);
            				};}
	            			else {
	            				System.out.println("Khong du mana");

            				
            			}
	            	} ;} 
	            
	            else if (action.equals("i")) { 
	            	System.out.println("Hay lua chon item:");
	            	System.out.println("Potion" + "(1)");
	            	System.out.println("Clarity" + "(2)");
	            	int select = WorldOfHustGame.USERINPUT.nextInt();
	            	
	            if (select == 1) {
	            		 if (java.util.Collections.frequency(player.getInventory(), "potion") > 0) {
	            			 	player.heal();
	            			 	System.out.println("Nguoi choi da hoi phuc 20 HP");
	            			 	System.out.println("Con lai " + java.util.Collections.frequency(player.getInventory(), "potion") + " binh Potion");
	            				player.defend(monster);
	            		         }
	            		else {
	            				System.out.println("Het Potion :(");
	            			    }        
	            	}
	            else if (select == 2){
	            	    if (java.util.Collections.frequency(player.getInventory(), "clarity") > 0) {
	            	    	player.resmana();
	            	    	System.out.println("Nguoi choi da hoi phuc 50 Mana");
	            	    	System.out.println("Con lai " + java.util.Collections.frequency(player.getInventory(), "clarity") + " binh Clarity");
	            	    	player.defend(monster);
	            	    	}
	            	    else {
	            	    	System.out.println("Het Clarity :(");
	            	    	};} 
	            }
	        } 
	       if (!player.isAlive()) {
	            System.out.println("Cuoc doi ban troi qua truoc mat...  GAME OVER");
	        } else if (!monster.isAlive()) {
	        	int ExpInc = player.getExp() + monster.getExp();
	        	player.setExp(ExpInc);
	            System.out.println("Quai thu da bi tieu diet!");
	            System.out.println("--------------------------------\n");
	        	System.out.println("Nguoi choi da tang them " + monster.getExp() + " exp");
	        	System.out.println("Hien tai nguoi choi co " + player.getExp() + " exp");
	            System.out.println("--------------------------------\n");
	            player.LevelCheck();
	            if(player.getLevel()>check) {System.out.println("Chuc mung ban da tang Level");
	            								player.LevelUp();}
	            System.out.println("Nguoi choi dang o level " + player.getLevel());
	            System.out.println("\n\n\n\n");
	        }

	    }
	    
	    
	    
	    public static void playerHitPointsMessage(int damage, Monster monster) {
	        System.out.println("Quai vat " + monster.getName() + " da gay ra "
	                + damage + " sat thuong.");
	    }
	    

	    public static void monsterHitPointsMessage(int damage, Monster monster) {
	        System.out.println("Ban gay ra cho " + monster.getName()
	                 + " " + damage + " sat thuong");
	    }

	    public static void battleSkip(Player player, Tile tile) {
	    	int tempPosX = player.getPosX() + 1;
	    	int tempPosY = player.getPosY() + 1;
	    	
	    	 System.out.println("Ban vao khu vuc [" + tempPosX + "]["
		                + tempPosY + "]");
		        System.out.println(tile.getDescription() + "\n\n");
		     	System.out.println("Khong co gi o day het!");
	    	
	    }
	    
	    public static void save(Player player) {
	    try (FileOutputStream save = new FileOutputStream("D:\\Player.txt");
	              ObjectOutputStream serial = new ObjectOutputStream(save); ) {
	            serial.writeObject(player);
	        } catch (IOException i) {
	            i.printStackTrace();
	        };}
	    
	    public static void savePosX(Player player) {
		    try (FileOutputStream save = new FileOutputStream("D:\\PlayerPosX.txt");
		              ObjectOutputStream serial = new ObjectOutputStream(save); ) {
		            serial.writeObject(player.getPosX());
		        } catch (IOException i) {
		            i.printStackTrace();
		        };}
	    
	    public static void savePosY(Player player) {
		    try (FileOutputStream save = new FileOutputStream("D:\\PlayerPosY.txt");
		              ObjectOutputStream serial = new ObjectOutputStream(save); ) {
		            serial.writeObject(player.getPosY());
		        } catch (IOException i) {
		            i.printStackTrace();
		        };}
	    
	    public static Player load () {
	    Player player = new Player("Warrior", "Cong khoe, thu khoe " + "ky nang can bang.", 500, 20 ,30, 15, 10, "Braver", 70, 60, 15, "Omnislash", 250, 230, 50, 100, 1);
	    player.setCurrX(0);
	    player.setCurrY(0);
	    try ( FileInputStream load = new FileInputStream("D:\\Player.txt");
	  			ObjectInputStream serial = new ObjectInputStream(load); ) {
	  			player = (Player) serial.readObject();
	  		} catch (IOException i) {
	  			i.printStackTrace();
	  		} catch (ClassNotFoundException e) {
	  			e.printStackTrace();
	  		}
	    
	    try ( FileInputStream load = new FileInputStream("D:\\PlayerPosX.txt");
	  			ObjectInputStream serial = new ObjectInputStream(load); ) {
	    		int i = (int) serial.readObject();
	    		player.setCurrX(i);
	  		} catch (IOException i) {
	  			i.printStackTrace();
	  		} catch (ClassNotFoundException e) {
	  			e.printStackTrace();
	  		}
	    
	    try ( FileInputStream load = new FileInputStream("D:\\PlayerPosY.txt");
	  			ObjectInputStream serial = new ObjectInputStream(load); ) {
	    		int i = (int) serial.readObject();
	    		player.setCurrY(i);
	  		} catch (IOException i) {
	  			i.printStackTrace();
	  		} catch (ClassNotFoundException e) {
	  			e.printStackTrace();
	  		}
	    
	    
	    
	    return player;
	    }
}
