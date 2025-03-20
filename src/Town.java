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
    public boolean ItemFound(Player p, int number) {
        boolean temp = false;
        String item = "wood log";
        int choice2 = 0;
        String[] options2 = { "Put it to inventory", "Leave it"};
        System.out.println();
        System.out.println("You found " + item + " on the ground");
        System.out.println("Do you want to pick it up and sacrifice your speed capability or leave it there and still use Fist to fight");





        choice2 = JOptionPane.showOptionDialog(null,"You found " + item + " on the ground. Do you want to pick it up and sacrifice your speed capability or leave it there and still use Fist to fight","equipped item- "+p.getEquipedItem().getKind(),JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,null,options2,options2);



        p.setDamage();






        if (choice2==0) {
            p.addToInventory(new Item("wood log"),0);
 temp = true;
        } else {
        }

return temp;
    }

    public void roomGameplay(Player p) {
        String[] ok = {"Ok"};
        int inform = JOptionPane.showOptionDialog(null, "You find yourself in a town, beat a monsters and get to move on to another location", "Lore of the location", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,ok,ok);
        setUpcomingLocationName("Forest");
        setPreviousLocationName("None");
        while (!locationPassed()) {
            fight(p);
            ItemFound(p,0);
            fight(p);
            var = true;
        }
        System.out.println("locations you can go to ");
        exit(p,this);
    }


    @Override
    public void fight(Player p) {




        p.setDamage();
        Threat t = new Threat("monster", 20, 5);
        String[] options = {"Attack", "Open inventory"};

        String choice = "";

        while (t.getHealth() > 0) {
            System.out.println();
            System.out.println("Your health " + p.getHealth());
            System.out.println("Enemy's health " + t.getHealth());

            choice = (String) JOptionPane.showInputDialog(null, "choose your move", "equipped item- "+p.getEquipedItem().getKind(), JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (choice.equals("Attack")) {
                t.setHealth(t.getHealth() - p.getDamage());
                System.out.println("You gave him -" + p.getDamage());
                if (t.getHealth() > 0) {
                    p.setHealth(p.getHealth() - t.getDamage());
                    System.out.println("He gave you -" + t.getDamage());
                }else if(t.getHealth()<0){
                    System.out.println("enemy has been killed");
                }
            } else if (choice.equals("Open inventory")) {
               p.openInventory(p);
            }


        }
        t.setHealth(20);


    }

    boolean var = false;

    @Override
    public String execute(Player p) {

        createMap();
        roomGameplay(p);

        System.out.println("youre now in "+p.getCurrentLocation().getLocationName());
        return "";
    }


    @Override
    public void exitToPreviousLocation(Player player) {
        super.exitToPreviousLocation(player);
    }

    @Override
    public void exit(Player p, Location l) {
        super.exit(p, this);
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
            this.surroundingLocations.add(new Location("There is no previous location",State.PREVIOUS));
            this.surroundingLocations.add(new Location("Forest", State.UPCOMING));


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
