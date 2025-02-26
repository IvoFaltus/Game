import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Location {
protected String locationName;
    protected ArrayList<Item> items = new ArrayList<>();
protected ArrayList<Location> surroundingLocations = new ArrayList<>();
protected Enum<State> state;
protected String currentLocationName;
protected String previousLocationName;
protected String upcomingLocationName;



public void fileReading(){
    try {
        BufferedReader br = new BufferedReader(new FileReader("World.txt"));
        currentLocationName = br.readLine().substring(0,br.readLine().indexOf(","));
        previousLocationName = br.readLine().substring(br.readLine().indexOf(","),br.readLine().indexOf(";"));
        System.out.println(currentLocationName);
        System.out.println(previousLocationName);

    }catch (Exception e){
        System.out.println("error reading World.txt");
    }
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
    surroundingLocations.add(new Location("None", State.PREVIOUS));
    surroundingLocations.add(new Forest(State.UPCOMING));

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
