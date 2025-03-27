public interface Command {

      String execute(Player p);
    void exit(Player p,Location l);

    boolean locationPassed();
    boolean luck(int probability);
    void fight(Player p);
}
