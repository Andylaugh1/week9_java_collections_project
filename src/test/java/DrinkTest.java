import enums.DrinkType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DrinkTest {

    Drink drink;

    @Before
    public void before() {
        drink = new Drink("Smirnoff", "Red Label", "30/05/2017", 20.00, 2.00, 21.00, DrinkType.VODKA);
    }

    @Test
    public void canGetMake() {
        assertEquals("Smirnoff", drink.getMake());
    }
    
    @Test
    public void canGetModel() {
        assertEquals("Red Label", drink.getModel());
    }

    @Test
    public void canGetPurchaseDate() {
        assertEquals("30/05/2017", drink.getPurchaseDate());
    }
}
