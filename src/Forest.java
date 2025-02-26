import java.util.ArrayList;

public class Forest extends Location implements Exit{


    @Override
    public boolean locationPassed() {
        return false;
    }

    public Forest(Enum<State> state) {
        super(state);
    }

    public Forest() {
    }
}
