public class World implements Command{
    @Override
    public boolean locationPassed() {
        return false;
    }

    public void startProgram(){}

    @Override
    public void fight(Player p) {

    }

    @Override
    public boolean luck(int probability) {
        return false;
    }

    @Override
    public void moveOnToOtherLoc() {

    }

    @Override
    public String execute(Player p) {
        Finish fi = new Finish();
        p.setCurrentLocation(new Location("Town", Location.State.CURRENT));
        Town t = new Town();FIeld f = new FIeld(); River r = new River();
Forest fr = new Forest();
        p.addToInventory(new Item("Empty slot"),0);
        p.addToInventory(new Item("Empty slot"),0);
        p.addToInventory(new Item("Empty slot"),0);
        p.addToInventory(new Item("Empty slot"),0);
        p.addToInventory(new Item("Empty slot"),0);
        p.addToInventory(new Item("Empty slot"),0);
        p.addToInventory(new Item("Empty slot"),0);



switch (p.getCurrentLocation().getLocationName()){
    case"Town":
        t.execute(p);
        break;
    case"Forest":
        fr.execute(p);
        break;
    case"Field":
        f.execute(p);


        break;
    case "River":
        r.execute(p);
        break;
    case"finish":
        fi.execute(p);
        break;


}



        QuitGame quitGame = new QuitGame();
        System.out.println("vvvvv Player's path vvvvv");
        System.out.println();




        t.execute(p);
        fr.execute(p);
        f.execute(p);
        r.execute(p);



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
