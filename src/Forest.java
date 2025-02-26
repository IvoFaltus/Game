import java.io.BufferedReader;
import java.io.FileReader;

public class Forest extends Location implements Exit{
    @Override
    public void exitToPreviousLocation(Player player) {
        super.exitToPreviousLocation(player);
    }

    public Forest(State state) {
    }

    @Override
    public void exit(Player player) {
        super.exit(player);
    }

    @Override
    public boolean locationPassed() {
        return false;
    }

    public Forest(String upcomingLocationName, Enum<State> state) {
        super(state);
    }

    public Forest() {
    }


    public void info() {
        System.out.println("Current Location: " + currentLocationName + '\n' + "Previous Location: " + previousLocationName + '\n' + "Upcoming Location: " + upcomingLocationName);
        System.out.println();
    }

    @Override
    public void createMap() {








            try {
                BufferedReader br = new BufferedReader(new FileReader("World.txt"));
                String line = "";
                for(int i =0;i<2;i++) {
                    line = br.readLine();
                }





                this.currentLocationName = line.substring(0, line.indexOf(","));
                this.previousLocationName = line.substring(line.indexOf(",") + 1, line.indexOf(";"));
                this.upcomingLocationName = line.substring(line.indexOf(";") + 1, line.length());
                this.surroundingLocations.add(new Town(State.PREVIOUS));
                this.surroundingLocations.add(new FIeld(upcomingLocationName, State.UPCOMING));


            } catch (Exception e) {
                e.printStackTrace();
            }



    }
}
