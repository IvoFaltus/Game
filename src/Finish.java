import javax.swing.*;

public class Finish extends Location {
    public Finish() {
    }

    @Override
    public String execute(Player p) {
        String[] options = {"yes", "No"};
        System.out.println("You have successfully finished the game!");
        System.out.println("do you wanna play again?");
        int choice= JOptionPane.showOptionDialog(null,"Do you wanna play again?","Replay",JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,null,options,options[0]);

        if(choice==0){
            Location l = new Location();
            l.setLocationName("Town");
            p.setCurrentLocation(l);
        }
        return null;
    }

    public Finish(Enum<State> state) {
        super(state);
    }

    public Finish(String locationName, Enum<State> state) {
        super(locationName, state);
    }

    private boolean end = false;

    public boolean isEnd() {
        return end;
    }
}
