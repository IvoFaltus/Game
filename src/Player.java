import java.util.ArrayList;
import java.util.Random;

public class Player {

    private String name;
    private int health;
    private ArrayList<Item> inventory = new ArrayList<>();

    private Location currentLocation;
    private Item equipedItem = new Item("Hand");
private int damage;
    Random rd = new Random();



    public void addToInventory(Item i, int index){

        inventory.add(index, i);
    }


    public void equipItem(String choice){
        for(int i =0;i<inventory.size();i++){
            if(choice.equals(inventory.get(i).getKind())){

                this.equipedItem = inventory.get(i);
            }

        }
    }

    //region setget

    public int getDamage() {
        return damage;
    }

    public void setDamage() {
        switch (equipedItem.getKind()){
            case "none":
                this.damage = rd.nextInt(10,20);
                break;
            case "wood log":
                this.damage = rd.nextInt(20,30);
                break;
            case"hammer":
                this.damage = rd.nextInt(20,40);
                break;
            case "pistol":
                this.damage = rd.nextInt(40,50);
            case "rifle":
                this.damage = rd.nextInt(50,70);
            default:
                this.damage = rd.nextInt(10,20);
                break;
        }
    }

    public Item getEquipedItem() {
        return equipedItem;
    }

    public void setEquipedItem(Item equipedItem) {
        this.equipedItem = new Item("Hand");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Player() {
        this(0);
    }

    public Player(int health) {
       this.health = health;

    }
//endregion
}
