public interface Command {

      String execute();
    boolean exit();
    void moveOnToOtherLoc();
    boolean locationPassed();
    boolean luck(int probability);
    void fight();
}
