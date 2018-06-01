import enums.DrinkType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DrinkTest {

    Drink drink;

    @Before
    public void before() {
        drink = new Drink("Smirnoff", "Red Label", "05/30/2017", 20.00, 2.00, 21.00, DrinkType.VODKA);
    }

    @Test
    public void canGetMake() {
        assertEquals("Smirnoff", drink.getMake());
    }
}
