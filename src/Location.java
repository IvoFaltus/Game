import java.util.ArrayList;

public class Location implements Exit{
    @Override
    public boolean locationPassed() {
        return false;
    }

    protected String locationName;
    protected ArrayList<Item> items = new ArrayList<>();
protected ArrayList<Location> surroundingLocations = new ArrayList<>();
protected Enum<State> state;
protected String currentLocationName;
protected String previousLocationName;
protected String upcomingLocationName;

public void go(Player player){

    if(this.locationPassed()){

        for(int i=0;i<surroundingLocations.size();i++){
            if(surroundingLocations.get(i).getState().equals(State.UPCOMING)){
                player.setCurrentLocation(surroundingLocations.get(i));
            }
        }

    }
}

public void fileReading(){

}







public enum State{
    PREVIOUS, UPCOMING
}
//region constructors

    public Location() {
    }

    public Location(Enum<State> state) {
    this.state = state;
}

    public Location(String locationName, Enum<State> state) {
        this.locationName = locationName;
        this.state = state;
    }
//endregion




    public void createMap(){


}




//region setget

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
