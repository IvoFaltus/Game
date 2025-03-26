import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class LocationTest {
    Location location;

    Location upcoming;
    Location previous;

    @BeforeEach
    void init() {



        testLocation = new Location() {
            @Override
            public boolean locationPassed() {
                return true;
            }
        };

        upcomingLocation = new Location(Location.State.UPCOMING);
        testLocation.setSurroundingLocations(new ArrayList<>());
        testLocation.getSurroundingLocations().add(upcomingLocation);
        location = new Location();
        player = new Player();
        upcoming = new Location(Location.State.UPCOMING);
        previous = new Location(Location.State.PREVIOUS);
        location.setSurroundingLocations(new ArrayList<>());
        location.getSurroundingLocations().add(previous);
        location.getSurroundingLocations().add(upcoming);
    }



    @Test
    void testGettersAndSetters() {
        location.setLocationName("Field");
        Assertions.assertEquals("Field", location.getLocationName());
        Assertions.assertNotNull(location.getItems());
        Assertions.assertNotNull(location.getSurroundingLocations());
    }

    Player player;
    Location testLocation;
    Location upcomingLocation;



    @Test
    void testSetAndGetItems() {
        Location location = new Location();
        Item item1 = new Item("hammer");
        Item item2 = new Item("wood log");
        Item item3 = new Item("pistol");

        ArrayList<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);

        location.setItems(new ArrayList<>(items));
        Assertions.assertEquals(2, location.getItems().size());
        Assertions.assertEquals(item1, location.getItems().get(0));
        Assertions.assertEquals(item2, location.getItems().get(1));
    }
    @Test
    void testSetAndGetState() {
        Location location = new Location();
        location.setState(Location.State.UPCOMING);

        Assertions.assertEquals(Location.State.UPCOMING, location.getState());

        location.setState(Location.State.PREVIOUS);
        Assertions.assertEquals(Location.State.PREVIOUS, location.getState());
    }
}
