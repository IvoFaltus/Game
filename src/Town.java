public class Town extends Location implements Exit{
    @Override
    public boolean locationPassed() {
        return false;
    }
}
