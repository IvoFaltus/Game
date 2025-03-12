import javax.swing.*;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class Town extends Location {
    int number;
    String[] options = {"Attack"};

    @Override
    public boolean luck(int probability) {
        return super.luck(probability);
    }


    @Override
    public void ItemFound(Player p) {
        String item = "wood log";
        String choice2 = "";
        String[] options2 = {"Pick it up and equip", "Put it to inventory", "Leave it"};
        System.out.println();
        System.out.println("You found " + item + " on the ground");
        System.out.println("Do you want to pick it up and sacrifice your speed capability or leave it there and still use Fist to fight");
        choice2 = (String) JOptionPane.showInputDialog(null, "choose your movee", "Menu", JOptionPane.QUESTION_MESSAGE, null, options2, options2[0]);
        if (choice2.equals("Put it to inventory")) {
            System.out.println("Item added to inventory");
            p.addToInventory(new Item("wood log"),1);
        } else if (choice2.equals("Pick it up and equip")) {
            p.addToInventory(new Item("wood log"),1);
            p.setEquipedItem(new Item("wood log"));
        } else {
        }


    }

    public void roomGameplay(Player p) {
        while (!locationPassed()) {
            fight(p);
            ItemFound(p);
            fight(p);
            var = true;
        }
        System.out.println("locations you can go to ");

    }


    @Override
    public void fight(Player p) {

        String[] options3 = {p.getInventory().get(0).getKind(), p.getInventory().get(1).getKind(), p.getInventory().get(2).getKind(), p.getInventory().get(3).getKind(),
                p.getInventory().get(4).getKind(), p.getInventory().get(5).getKind(), p.getInventory().get(6).getKind()};


        p.setDamage();
        Threat t = new Threat("monster", 20, 5);
        String[] options = {"Attack", "Open inventory"};

        String choice = "";

        while (t.getHealth() > 0) {
            System.out.println();
            System.out.println("Your health " + p.getHealth());
            System.out.println("Enemy's health " + t.getHealth());

            choice = (String) JOptionPane.showInputDialog(null, "choose your move", "Menu", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (choice.equals("Attack")) {
                t.setHealth(t.getHealth() - p.getDamage());
                System.out.println("You gave him -" + p.getDamage());
                if (t.getHealth() > 0) {
                    p.setHealth(p.getHealth() - t.getDamage());
                    System.out.println("He gave you -" + t.getDamage());
                }
            } else if (choice.equals("Open inventory")) {
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
                    default:

                        break;
                }

            }


        }
        t.setHealth(20);


    }

    boolean var = false;

    @Override
    public String execute(Player p) {

        createMap();
        roomGameplay(p);


        return "";
    }


    @Override
    public void exitToPreviousLocation(Player player) {
        super.exitToPreviousLocation(player);
    }

    @Override
    public void exit(Player player) {
        super.exit(player);
    }

    @Override
    public boolean locationPassed() {

        return var;
    }

    public void info() {
        System.out.println("Current Location: " + currentLocationName + '\n' + "Previous Location: " + previousLocationName + '\n' + "Upcoming Location: " + upcomingLocationName);
        System.out.println();
    }

    @Override
    public void createMap() {
        try {

            BufferedReader br = new BufferedReader(new FileReader("World.txt"));
            String line = br.readLine();
            this.currentLocationName = line.substring(0, line.indexOf(","));
            this.previousLocationName = line.substring(line.indexOf(",") + 1, line.indexOf(";"));
            this.upcomingLocationName = line.substring(line.indexOf(";") + 1, line.length());
            this.surroundingLocations.add(new Location(State.PREVIOUS));
            this.surroundingLocations.add(new Forest(upcomingLocationName, State.UPCOMING));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //region constructors
    public Town(Enum<State> state) {
        super(state);
    }

    public Town() {
    }

    public Town(String locationName, Enum<State> state) {
        super(locationName, state);
    }
    //endregion


}
