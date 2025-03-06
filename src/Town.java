import javax.swing.*;
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

    Player p = new Player(100);

    public void roomGameplay() {
        while (!locationPassed()) {
   fight();

   fight();
            var = true;
        }


    }


    @Override
    public void fight() {
        p.setDamage();
        Threat t = new Threat("monster", 20, 5);
        String[] options = {"Attack"};
        String[] options2 = {"Pick it up and equip", "Put it to inventory", "Leave it"};
        String choice = "";
        String choice2 = "";
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
            } else {
                System.out.println("Enemy's been killed");
            }


        }
        t.setHealth(20);
        System.out.println();
        System.out.println("You found wood log on the ground");
        System.out.println("Do you want to pick it up and sacrifice your speed or leave it there and still use Fist to fight");
         choice2 = (String) JOptionPane.showInputDialog(null, "choose your movee", "Menu", JOptionPane.QUESTION_MESSAGE, null, options2, options2[0]);
if(choice2.equals("Put it to inventory")){
    p.addToInventory(new Item("wood log"));
}else if(choice2.equals("Pick it up and equip")){
    p.addToInventory(new Item("wood log"));
    p.setEquipedItem(new Item("wood log"));
}else{}



    }

    boolean var = false;

    @Override
    public String execute() {
        createMap();
        roomGameplay();


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
