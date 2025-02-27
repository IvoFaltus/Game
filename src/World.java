public class World {


    public void startProgram(){}



    public void worldCreation(){
        System.out.println("vvvvv Player's path vvvvv");
        System.out.println();
Town t = new Town();
Forest fr = new Forest();
FIeld f = new FIeld();
River r = new River();
        r.createMap();
        fr.createMap();
      t.createMap();
        f.createMap();
        t.info();
        fr.info();
        f.info();
      r.info();



        Location l = new Location();
        l.fileReading();

    }








}
