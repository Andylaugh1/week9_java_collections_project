import enums.DrinkType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DrinkTest {

    Drink drink;

    @Before
    public void before() {
        drink = new Drink("Smirnoff", "Red Label", "30/05/2017", 20.00, 2.00, DrinkType.VODKA);
    }

    @Test
    public void canGetMake() {
        assertEquals("Smirnoff", drink.getBrand());
    }

    @Test
    public void canGetModel() {
        assertEquals("Red Label", drink.getModel());
    }

    @Test
    public void canGetPurchaseDate() {
        assertEquals("30/05/2017", drink.getPurchaseDate());
    }

    @Test
    public void canGetBuyPrice() {
        assertEquals(20.00, drink.getBuyPrice(), 0.01);
    }

    @Test
    public void canGetShippingPrice() {
        assertEquals(2.00, drink.getShippingPrice(), 0.01);
    }

    @Test
    public void canGetCurrentMarketValue() {
        assertEquals(00.00, drink.getCurrentMarketValue(), 0.01);
    }

    @Test
    public void canGetDrinkType() {
        assertEquals(DrinkType.VODKA, drink.getDrinkType());
    }

    @Test
    public void canSetNewMarketValue() {
        drink.setNewMarketValue(21.00);
        assertEquals(21.00, drink.getCurrentMarketValue(), 0.01);
    }

    @Test
    public void canGetIsForResaleOrNotFalse() {
        assertEquals(false, drink.getResaleStatus());
    }

    @Test
    public void canSetResaleStatusToTrue() {
        drink.changeForSaleStatus();
        assertEquals(true, drink.getResaleStatus());
    }

    @Test
    public void canSetResaleStatusBackToFalse() {
        drink.changeForSaleStatus();
        drink.changeForSaleStatus();
        assertEquals(false, drink.getResaleStatus());
    }
}
