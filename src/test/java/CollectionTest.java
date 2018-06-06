import enums.DrinkType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CollectionTest {

    Collection drinkCollection;
    Drink drink, drink1;

    @Before
    public void before() {
        drinkCollection = new Collection();
        drink = new Drink("Smirnoff", "Red Label",2012, 20.00, 2.00, DrinkType.VODKA);
        drink1 = new Drink("Gordon's", "Gordon's",2013, 17.00, 1.50, DrinkType.GIN);
    }


    @Test
    public void canCountItems() {
        assertEquals(0, drinkCollection.countItems());
    }

    @Test
    public void canAddAnItemToCollection() {
        drinkCollection.addItem(drink);
        assertEquals(1, drinkCollection.countItems());
    }

    @Test
    public void canRemoveItemFromCollection() {
        drinkCollection.addItem(drink);
        drinkCollection.removeItem(drink);
        assertEquals(0, drinkCollection.countItems());
    }

    @Test
    public void canGetTotalPricePaidForItems() {
        drinkCollection.addItem(drink1);
        drinkCollection.addItem(drink);
        assertEquals(37.00, drinkCollection.calculateTotalItemPricePaid(), 0.01);
    }

    @Test
    public void canGetTotalPricePaidForShipping() {
        drinkCollection.addItem(drink1);
        drinkCollection.addItem(drink);
        assertEquals(3.50, drinkCollection.calculateTotalShippingPricePaid(), 0.01);
    }

    @Test
    public void canGetTotalPriceShippingAndBuyingCombined() {
        drinkCollection.addItem(drink1);
        drinkCollection.addItem(drink);
        assertEquals(40.50, drinkCollection.calculateTotalPricePaid(), 0.01);
    }


}
