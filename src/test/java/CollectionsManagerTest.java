import enums.ActionFigureType;
import enums.CollectionType;
import enums.DrinkType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CollectionsManagerTest {

    CollectionsManager collectionsManager;
    Collection collection, collection1;
    Item item, item1, item2, item3;

    @Before
    public void before() {


        item = new Drink("Smirnoff", "Red Label", 20.00, 2.00, DrinkType.VODKA);
        item1 = new Drink("Gordon's", "Gordon's", 17.00, 1.50, DrinkType.GIN);
        item2 = new ActionFigure("Stone Cold", ActionFigureType.WRESTLER, "Stunner", 10.00, 3.00 );
        item3 = new ActionFigure("Wolverine", ActionFigureType.XMAN, "Regeneration", 12.00, 1.00 );

        collection = new Collection();

        collection1 = new Collection();

        collectionsManager = new CollectionsManager();


        collection.addItem(item);
        collection.addItem(item1);
        collection1.addItem(item2);
        collection1.addItem(item3);
    }


    @Test
    public void canCountSellableItems(){
        assertEquals(0, collectionsManager.countSaleItems());
    }

    @Test
    public void canAddSellableItem(){
        collectionsManager.addSaleItem(item1);
        assertEquals(1, collectionsManager.countSaleItems());
    }

    @Test
    public void canAddItemsToSellableList(){
        item.setNewMarketValue(25.00);
        item.changeForSaleStatusToTrue();
        item3.setNewMarketValue(16.00);
        item3.changeForSaleStatusToTrue();
        collectionsManager.addSellableItemsFromCollection(collection);
        collectionsManager.addSellableItemsFromCollection(collection1);
        assertEquals(2, collectionsManager.countSaleItems());
    }

    @Test
    public void canCalculateProfitIfSold(){
        item.setNewMarketValue(25.00);
        item.changeForSaleStatusToTrue();
        item3.setNewMarketValue(16.00);
        item3.changeForSaleStatusToTrue();
        collectionsManager.addSellableItemsFromCollection(collection);
        collectionsManager.addSellableItemsFromCollection(collection1);
        assertEquals(6.00, collectionsManager.calculateProfitIfSold(), 0.01);

    }


}
