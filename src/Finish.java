public class Finish extends Location {
    public Finish() {
    }

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
}
