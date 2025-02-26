public class River extends Location implements Exit{
    @Override
    public boolean locationPassed() {
        return false;
    }

    public River() {
    }

    public River(Enum<State> state) {
        super(state);
    }
}
