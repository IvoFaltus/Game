import java.io.BufferedReader;
import java.io.FileReader;

public class Town extends Location {
    boolean var = false;

    @Override
    public String execute() {
        createMap();
        roomGameplay();


        return "";
    }


    public void roomGameplay(){
    while(!locationPassed()){
    /*
    gameplay
     */
        var = true;
    }



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
            this.surroundingLocations.add(new Forest(upcomingLocationName,State.UPCOMING));



        }catch (Exception e){
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
