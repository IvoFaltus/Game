import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Location implements Command {

public boolean ItemFound(Player p, int number){

return false;
}
    @Override
    public void fight(Player p) {




    }

    @Override
    public boolean luck(int probability) {
        boolean temp = false;
        Random rd = new Random();

         if(rd.nextInt(0,100)<=probability){
             temp = true;
         }

         return temp;
    }

    @Override
    public String execute(Player p) {
        return null;
    }

    @Override
    public void exit(Player p, Location l) {

       String[] options = {surroundingLocations.get(0).getLocationName(),surroundingLocations.get(1).getLocationName()};


        int choice =0;
        choice = JOptionPane.showOptionDialog(null,"What location do you want to proceed to","equipped item: "+p.getEquipedItem().getKind(),JOptionPane.DEFAULT_OPTION,
               JOptionPane.QUESTION_MESSAGE,null,options,options[0]);

        switch (choice){
            case 0:
                if(this.locationPassed()&&!(surroundingLocations.get(0).getLocationName().equals("There is no previous location"))){


p.setCurrentLocation(l.surroundingLocations.get(0));
                    System.out.println("You entered location: "+l.surroundingLocations.get(0).getLocationName());



                }else{
                    System.out.println("There is no previous location, youre going to Forest!");
                    p.setCurrentLocation(l.surroundingLocations.get(1));
                }

                break;
            case 1:


                break;

        }






    }

    @Override
    public void moveOnToOtherLoc() {

    }

    protected String locationName;
    protected ArrayList<Item> items = new ArrayList<>();
protected ArrayList<Location> surroundingLocations = new ArrayList<>();
protected Enum<State> state;
protected String currentLocationName;
protected String previousLocationName;
protected String upcomingLocationName;
    @Override
    public boolean locationPassed() {
        return false;
    }



public void exitToPreviousLocation(Player player){
    if(!(previousLocationName.equals("None"))) {
        for (int i = 0; i < surroundingLocations.size(); i++) {
            if (surroundingLocations.get(i).getState().equals(State.PREVIOUS)) {
                player.setCurrentLocation(surroundingLocations.get(i));
            }
        }
    }
}

public void fileReading(){

}


public enum State{
    PREVIOUS, UPCOMING, CURRENT
}


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
