public class World implements Command {
    //region obligatory overrides
    @Override
    public boolean locationPassed() {
        return false;
    }

    @Override
    public void exit(Player p, Location l) {

    }



    @Override
    public void fight(Player p) {

    }

    @Override
    public boolean luck(int probability) {
        return false;
    }
//endregion

    /**
     * executes the whole game, sets all inventory slots as an empty slots and executes location's gameplay according to player's current location attribute
     * @param p Player
     * @return null
     */
    @Override
    public String execute(Player p) {
        try {
            p.setCurrentLocation(new Location("Town", Location.State.CURRENT));
            Finish fi = new Finish();


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










