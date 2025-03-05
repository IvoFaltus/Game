public interface Command {

      String execute();
    boolean exit();
    void moveOnToOtherLoc();
    boolean locationPassed();
}
