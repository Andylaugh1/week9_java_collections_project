import enums.DrinkType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CollectionTest {

    Collection collection;
    Item item, item1;

    @Before
    public void before() {
        collection = new Collection("Alcoholic Drinks");
        item = new Drink("Smirnoff", "Red Label", "30/05/2017", 20.00, 2.00, DrinkType.VODKA);
        item1 = new Drink("Gordon's", "Gordon's", "31/05/2017", 17.00, 1.50, DrinkType.GIN);
    }

    @Test
    public void canGetName() {
        assertEquals("Alcoholic Drinks", collection.getName());
    }

    @Test
    public void canCountItems() {
        assertEquals(0, collection.countItems());
    }

    @Test
    public void canAddAnItemToCollection() {
        collection.addItem(item);
        assertEquals(1, collection.countItems());
    }

    @Test
    public void canRemoveItemFromCollection() {
        collection.addItem(item);
        collection.removeItem(item);
        assertEquals(0, collection.countItems());
    }

    @Test
    public void canGetTotalPricePaidForItems() {
        collection.addItem(item1);
        collection.addItem(item);
        assertEquals(37.00, collection.calculateTotalItemPricePaid(), 0.01);
    }

    @Test
    public void canGetTotalPricePaidForShipping() {
        collection.addItem(item1);
        collection.addItem(item);
        assertEquals(3.50, collection.calculateTotalShippingPricePaid(), 0.01);
    }


}
