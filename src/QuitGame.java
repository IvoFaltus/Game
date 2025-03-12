public class QuitGame implements Command{
    @Override
    public String execute(Player p) {
        return "Game is over";
    }

    @Override
    public boolean exit() {
        return true;
    }

    @Override
    public void moveOnToOtherLoc() {

    }

    @Override
    public boolean locationPassed() {
        return false;
    }

    @Override
    public void fight(Player p) {

    }

    @Override
    public boolean luck(int probability) {
        return false;
    }
}
