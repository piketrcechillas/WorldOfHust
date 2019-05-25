package worldOfHust;

public class Item {

    private final String name;
    private final String type;
    private final String description;
    private int numOfPotions;
    private int numOfClarity;
    private static Item potion;
    private static Item clarity;


    public Item(String name, String type, String description) {
        this.name = name;
        this.type = type;
        this.description = description;
    }

    public static void use(Player player, Item item) {
        if (item.type.equals("Potion")) {
            player.heal();
        if (item.type.equals("Clarity")) {
        	player.resmana();
        }
        }
    }

    public static void addPotion(int numOfPotions, Player player) {
        for (int i = 0; i < numOfPotions; i++) {
            player.getInventory().add("potion");
        }
    }
    
    public static void addClarity(int numOfClarity, Player player) {
        for (int i = 0; i < numOfClarity; i++) {
            player.getInventory().add("clarity");
        }
    }

    private static Item potion() {
        return new Item("Potion", "Potion", "mot lo nho chua chat long than ky. Hoi 20 HP");
    }
    
    private static Item clarity() {
        return new Item("Clarity", "Clarity", "Hoi lai 50 Mana");
    }
    
    public Item getPotion() {
    	return potion();
    }
    
    public String getDescription() {
    	return description;
    }
    

}