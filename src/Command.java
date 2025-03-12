public interface Command {

      String execute(Player p);
    boolean exit();
    void moveOnToOtherLoc();
    boolean locationPassed();
    boolean luck(int probability);
    void fight(Player p);
}
