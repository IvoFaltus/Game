import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class Forest extends Location {

    boolean var = false;

    @Override
    public String execute(Player p) {
        createMap();
        roomGameplay(p);


        return "";
    }

    @Override
    public boolean luck(int probability) {
        return super.luck(probability);
    }

    public void roomGameplay(Player p) {
        while (!locationPassed()) {
    if(luck(50)){
        ItemFound(p);
    }
    fight(p);
    ItemFound(p);
    fight(p);
            var = true;
        }
    }


    @Override
    public void fight(Player p) {


    }

    @Override
    public boolean locationPassed() {
        return false;
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
    //region constructors
    public Forest(State state) {
    }
    public Forest() {
    }
    public Forest(String upcomingLocationName, Enum<State> state) {
        super(state);
    }
    //endregion

}
