import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class FIeld extends Location {
    boolean var = false;
    @Override
    public void fight(Player p) {




        p.setDamage();
        Threat t = new Threat("soldier", 50, 30);
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
                    if (p.getHealth()<=0) {
                        System.out.println("You lost");
                        System.exit(32);

                    }
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

    @Override
    public boolean ItemFound(Player p, int number) {
        String item = "";
        boolean temp = false;
        if(number==0) {
            item = "wood log";
        }else if(number==1){
            item = "pistol";
        }
        int choice2 = 0;
        String[] options2 = { "Put it to inventory", "Leave it"};
        System.out.println();
        System.out.println("You found " + item + " on the ground");
        System.out.println("Do you want to pick it up and sacrifice your speed capability or leave it there and still use Fist to fight");





        choice2 = JOptionPane.showOptionDialog(null,"You found " + item + " on the ground. Do you want to pick it up and sacrifice your speed capability or leave it there and still use Fist to fight","equipped item- "+p.getEquipedItem().getKind(),JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,null,options2,options2);



        p.setDamage();






        if (choice2==0) {


            for(int i =0;i<p.getInventory().size();i++){
                if(!(p.getInventory().get(i).getKind().equals("empty slot"))){
                    p.addToInventory(new Item(item),i);
                    break;
                }

            }




            temp = true;
        } else {
        }

        return temp;
    }

    @Override
    public String execute(Player p) {
        createMap();
        roomGameplay(p);


        return "";
    }


    public void roomGameplay(Player p){
        String[] ok = {"Ok"};
        int inform = JOptionPane.showOptionDialog(null, "You find yourself on a Filed, beat a even stronger monsters than previously an" +
                "d get to move on to another location", "Lore of the location", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,ok,ok);
        while(!locationPassed()){
    fight(p);
    if(luck(50)){
        ItemFound(p,0);
    }
            if(luck(90)){
                System.out.println("You had been lucky lucky, you health has been cured");
                p.setHealth(100);
            }
    fight(p);
            if(luck(90)){
                System.out.println("You had been lucky lucky, you health has been cured");
                p.setHealth(100);
            }
    fight(p);
            if(luck(90)){
                System.out.println("You had been lucky lucky, you health has been cured");
                p.setHealth(100);
            }
    ItemFound(p,1);

            var = true;
        }
        System.out.println("locations you can go to ");
        exit(p,this);
    }
    @Override
    public void exitToPreviousLocation(Player player) {
        super.exitToPreviousLocation(player);
    }




    @Override
    public boolean locationPassed() {
        return var;
    }


    @Override
    public void createMap() {







        try {
            BufferedReader br = new BufferedReader(new FileReader("World.txt"));
            String line = "";
            for(int i =0;i<3;i++) {
                line = br.readLine();
            }





            this.currentLocationName = line.substring(0, line.indexOf(","));
            this.previousLocationName = line.substring(line.indexOf(",") + 1, line.indexOf(";"));
            this.upcomingLocationName = line.substring(line.indexOf(";") + 1, line.length());
            this.surroundingLocations.add(new Location("Forest",State.PREVIOUS));
            this.surroundingLocations.add(new Location("River", State.UPCOMING));


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    //region constructors
    public FIeld() {

    }
    public FIeld(String upcomingLocationName, State upcoming) {
    }

    public FIeld(Enum<State> state) {
        super(state);
    }
    public void info() {
        System.out.println("Current Location: " + currentLocationName + '\n' + "Previous Location: " + previousLocationName + '\n' + "Upcoming Location: " + upcomingLocationName);
        System.out.println();
    }
    //endregion

}
