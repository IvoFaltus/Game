public class World {

    public void worldCreation(){
Town t = new Town();
Forest fr = new Forest();
FIeld f = new FIeld();
River r = new River();

      t.createMap();
      fr.createMap();
      f.createMap();
      r.createMap();
        Location l = new Location();
        l.fileReading();

    }
}
