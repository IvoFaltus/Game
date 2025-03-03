import java.io.BufferedReader;
import java.io.FileReader;

public class FIeld extends Location implements Exit{
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
        return false;
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
            this.surroundingLocations.add(new Forest(State.PREVIOUS));
            this.surroundingLocations.add(new River(upcomingLocationName, State.UPCOMING));


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
