public class FIeld extends Location implements Exit{
    @Override
    public boolean locationPassed() {
        return false;
    }

    public FIeld() {
    }

    public FIeld(Enum<State> state) {
        super(state);
    }
}
