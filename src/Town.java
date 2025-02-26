public class Town extends Location implements Exit{
    @Override
    public boolean locationPassed() {
        return false;
    }

    @Override
    public void createMap() {
    }

    public Town(Enum<State> state) {
        super(state);
    }

    public Town() {
    }
}
