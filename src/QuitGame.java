public class QuitGame implements Command{
    @Override
    public String execute() {
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
}
