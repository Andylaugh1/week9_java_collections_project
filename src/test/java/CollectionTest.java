import enums.DrinkType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CollectionTest {

    Collection collection;
    Item item;

    @Before
    public void before() {
        collection = new Collection("Alcoholic Drinks");
        item = new Drink("Smirnoff", "Red Label", "30/05/2017", 20.00, 2.00, DrinkType.VODKA);
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


}
