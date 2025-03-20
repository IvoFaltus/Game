public class World implements Command {
    @Override
    public boolean locationPassed() {
        return false;
    }

    @Override
    public void exit(Player p, Location l) {

    }

    public void startProgram() {
    }

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
        try {
            p.setCurrentLocation(new Location("Town", Location.State.CURRENT));
            Finish fi = new Finish();

            System.out.println("player stars here" + p.getCurrentLocation().getLocationName());
            Town t = new Town();
            FIeld f = new FIeld();
            River r = new River();
            Forest fr = new Forest();
            p.addToInventory(new Item("Empty slot"), 0);
            p.addToInventory(new Item("Empty slot"), 0);
            p.addToInventory(new Item("Empty slot"), 0);
            p.addToInventory(new Item("Empty slot"), 0);
            p.addToInventory(new Item("Empty slot"), 0);
            p.addToInventory(new Item("Empty slot"), 0);
            p.addToInventory(new Item("Empty slot"), 0);


            while (!fi.isEnd()) {
                switch (p.getCurrentLocation().getLocationName()) {
                    case "Town":
                        t.execute(p);
                        break;
                    case "Forest":
                        System.out.println("executing forest");
                        fr.execute(p);
                        break;
                    case "Field":
                        System.out.println("executing field");
                        f.execute(p);
                        break;
                    case "River":
                        r.execute(p);
                        break;
                    case "Finish":
                        fi.execute(p);
                        break;


                }
            }



        } catch (Exception e) {
            System.out.println("Error occurred, let's start over");
            execute(p);
        }
        return null;
    }


}










