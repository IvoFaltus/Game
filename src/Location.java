import java.util.ArrayList;
import java.util.Random;

public class Location implements Command {


    @Override
    public void fight() {

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
    public String execute() {
        return null;
    }

    @Override
    public boolean exit() {
        return false;
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


public void exit(Player player){

    if(this.locationPassed()){

        for(int i=0;i<surroundingLocations.size();i++){
            if(surroundingLocations.get(i).getState().equals(State.UPCOMING)){
                player.setCurrentLocation(surroundingLocations.get(i));
            }
        }

    }else{
        System.out.println("You cannot leave this location yet");
    }
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
