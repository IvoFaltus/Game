public class River extends Location implements Exit{
    @Override
    public boolean locationPassed() {
        return false;
    }
}
