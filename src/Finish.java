import javax.swing.*;

public class Finish extends Location {
    public Finish() {
    }

    /**
     * informs player that he successfully finished the game and asks whether does he want to play again,
     * in case he does want to replay, all locations are set as not-passed
     * @param p Plauer
     * @return null
     */

    @Override
    public String execute(Player p) {
        String[] options = {"yes", "No"};

        int choice= JOptionPane.showOptionDialog(null,"You have successfully finished the game! Do you wanna play again?","Replay",JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,null,options,options[0]);

        if(choice==0){


            Location l = new Location();
            l.setLocationName("Town");

            p.setCurrentLocation(l);
        }else {
            System.exit(32);
        }
        return null;
    }
//region setget cons
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
    //endregion
}
