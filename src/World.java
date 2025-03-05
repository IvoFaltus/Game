public class World implements Command{
    @Override
    public boolean locationPassed() {
        return false;
    }

    public void startProgram(){}

    @Override
    public void moveOnToOtherLoc() {

    }

    @Override
    public String execute() {


        QuitGame quitGame = new QuitGame();
        System.out.println("vvvvv Player's path vvvvv");
        System.out.println();
        Town t = new Town();
        Forest fr = new Forest();
        FIeld f = new FIeld();
        River r = new River();
        t.execute();
        fr.execute();
        f.execute();
        r.execute();



        Location l = new Location();
        l.fileReading();


        if(quitGame.exit()){
            System.exit(0);
        }





        return null;
    }

    @Override
    public boolean exit() {





        return false;
    }










}
