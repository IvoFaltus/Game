import javax.swing.*;
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

    public void openInventory(Player p){
        String[] options3 = {p.getInventory().get(0).getKind(), p.getInventory().get(1).getKind(), p.getInventory().get(2).getKind(), p.getInventory().get(3).getKind(),
                p.getInventory().get(4).getKind(), p.getInventory().get(5).getKind(), p.getInventory().get(6).getKind()};
        String KindOfItem = (String) JOptionPane.showInputDialog(null, "choose item you wanna equip", "Inventory",
                JOptionPane.QUESTION_MESSAGE, null, options3, options3[0]);

        switch (KindOfItem) {
            case "Empty Slot":
                System.out.println("you haven't picked up anything");
                break;
            case "wood log":
                p.equipItem("wood log");
                break;
            case "hammer":
                p.equipItem("hammer");
                break;
            case "pistol":
                p.equipItem("pistol");
                break;
            case "rifle":
                p.equipItem("rifle");
                break;
            case null:
                System.out.println("You haven't equipped anything");
                break;
            default:

                break;
        }

    }

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
