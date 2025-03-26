import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ForestTest {
    @Test
    void testCreateMapPopulatesSurroundings() {
        Forest forest = new Forest();
        forest.createMap();


        assertEquals(2, forest.getSurroundingLocations().size());
        assertEquals(3, forest.getSurroundingLocations().size());//error



    }
}
