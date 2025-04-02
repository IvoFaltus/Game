import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

public class Location implements Command {

    public String readItem(int line){
        String item ="";
        try{


            BufferedReader br = new BufferedReader(new FileReader("Items.txt"));

            for(int i=0;i<line;i++){
                item = br.readLine();
            }
        }catch (Exception e){
            System.out.println("problem linked with reading");
        }
        return item;
    }

    /**
     * is called when player finds item, gives choice whether to pick item up and store it inventory or let it be
     * @param p Player
     * @param number different items are linked to different numbers
     * @return true: when certain slot of inventory possesses an item, otherwise the slot is empty: false
     */
public boolean ItemFound(Player p, int number){

return false;
}
    /**
     * executes fight between player and enemy, player is able to open inventory, equip item etc.
     * @param p Player
     */
    @Override
    public void fight(Player p) {




    }
    /**
     * randomly generates numbers
     * @param probability chance[%] of returning true
     * @return true or false according to randomly generated number
     */
    @Override
    public boolean luck(int probability) {
        boolean temp = false;
        Random rd = new Random();

         if(rd.nextInt(0,100)<=probability){
             temp = true;
         }

         return temp;
    }
    /**
     * executes tasks and whole lore of the location when player is present
     * @param p Player
     * @return informs that location has been completed
     */
    @Override
    public String execute(Player p) {
        return null;
    }

    /**
     * After completing location Player can decide whether to go on to another location or replay the previous one, subsequently
     * location which player chooses is set as a player's current location
     * @param p Player
     * @param l Location
     */
    @Override
    public void exit(Player p, Location l) {

       String[] options = {surroundingLocations.get(0).getLocationName(),surroundingLocations.get(1).getLocationName()};


        int choice =0;
        choice = JOptionPane.showOptionDialog(null,"What location do you want to proceed to","equipped item: "+p.getEquipedItem().getKind(),JOptionPane.DEFAULT_OPTION,
               JOptionPane.QUESTION_MESSAGE,null,options,options[0]);

        switch (choice){
            case 0:
                if(!(surroundingLocations.get(0).getLocationName().equals("There is no previous location"))){
                    System.out.println("choice is "+l.surroundingLocations.get(0).getLocationName());

p.setCurrentLocation(l.surroundingLocations.get(0));
                    System.out.println("You entered location: "+l.surroundingLocations.get(0).getLocationName());



                }else{
                    System.out.println("There is no previous location, youre going to Forest!");
                    p.setCurrentLocation(l.surroundingLocations.get(1));
                }

                break;
            case 1:

                System.out.println(p.getCurrentLocation().getLocationName());
                p.setCurrentLocation(l.surroundingLocations.get(1));
                break;

        }






    }



    protected String locationName;
    protected ArrayList<Item> items = new ArrayList<>();
protected ArrayList<Location> surroundingLocations = new ArrayList<>();
protected Enum<State> state;
protected String currentLocationName;
protected String previousLocationName;
protected String upcomingLocationName;

    /**
     *informs whether location in completed
     * @return true: when location is completed, otherwise: false
     */
    @Override
    public boolean locationPassed() {
        return false;
    }






public enum State{
    PREVIOUS, UPCOMING, CURRENT
}

    /**
     * reads input from text file and sets this location's name along with surrounding one's
     */
    public void createMap(){


}

//region setget & cons

    public void setUpcomingLocationName(String upcomingLocationName) {
        this.upcomingLocationName = upcomingLocationName;
    }

    public void setPreviousLocationName(String previousLocationName) {
        this.previousLocationName = previousLocationName;
    }

    public void setCurrentLocationName(String currentLocationName) {
        this.currentLocationName = currentLocationName;
    }

    public String getCurrentLocationName() {
        return currentLocationName;
    }

    public String getPreviousLocationName() {
        return previousLocationName;
    }

    public String getUpcomingLocationName() {
        return upcomingLocationName;
    }

    public Location() {
}

    public Location(Enum<State> state) {
        this.state = state;
    }

    public Location(String locationName, Enum<State> state) {
        this.locationName = locationName;
        this.state = state;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public ArrayList<Location> getSurroundingLocations() {
        return surroundingLocations;
    }

    public void setSurroundingLocations(ArrayList<Location> surroundingLocations) {
        this.surroundingLocations = surroundingLocations;
    }

    public Enum<State> getState() {
        return state;
    }

    public void setState(Enum<State> state) {
        this.state = state;
    }

    //endregion

}
