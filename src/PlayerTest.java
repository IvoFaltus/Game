import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PlayerTest {
    @Test
    void testSetAndGetName() {
        Player player = new Player();
        player.setName("jozef");

     assertEquals("jozef", player.getName());

        player.setName("eugen");
       assertEquals("jozef", player.getName());//error
    }

    @Test
    public void testPlayerSettersAndGetters() {
        Player player = new Player();
        player.setName("Hero");
        player.setHealth(100);

        assertEquals("Hero", player.getName());
        assertEquals(100, player.getHealth());

    }

    @Test
    public void testSetCurrentLocation() {
        Player player = new Player();
        Location loc = new Location();
        player.setCurrentLocation(loc);
        assertEquals(loc, player.getCurrentLocation());
    }
}
