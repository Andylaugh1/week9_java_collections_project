import enums.ActionFigureType;
import enums.DrinkType;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CollectionsManagerTest {

    CollectionsManager collectionsManager;
    Collection drinkCollection, actionFigureCollection;
    Drink item, item1;
    ActionFigure item2, item3, actionFigure3;

    @Before
    public void before() {


        item = new Drink("Smirnoff", "Red Label", 2012, 20.00, 2.00, DrinkType.VODKA);
        item1 = new Drink("Gordon's", "Gordon's", 2011,17.00, 1.50, DrinkType.GIN);
        item2 = new ActionFigure("Stone Cold", ActionFigureType.WRESTLER, 2003,"Stunner", 10.00, 3.00 );
        item3 = new ActionFigure("Wolverine", ActionFigureType.XMAN, 1997,"Regeneration", 12.00, 1.00 );
        actionFigure3 = new ActionFigure("Peter Venkman", ActionFigureType.GHOSTBUSTER, 1990,"Hilarity", 6.00, 0.00 );

        drinkCollection = new Collection();

        actionFigureCollection = new Collection();

        collectionsManager = new CollectionsManager();


        drinkCollection.addItem(item);
        drinkCollection.addItem(item1);
        actionFigureCollection.addItem(item2);
        actionFigureCollection.addItem(item3);
        actionFigureCollection.addItem(actionFigure3);
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
    public void canGetProfit() {
        assertEquals(0.00, collectionsManager.getProfit(), 0.01);
    }

    @Test
    public void canGetDonatedItemsCount() {
        assertEquals(0, collectionsManager.getItemsDonated());
    }

    @Test
    public void canAddItemsToSellableList(){
        item.setNewMarketValue(25.00);
        item.changeForSaleStatusToTrue();
        item3.setNewMarketValue(16.00);
        item3.changeForSaleStatusToTrue();
        collectionsManager.addSellableItemsFromCollection(drinkCollection);
        collectionsManager.addSellableItemsFromCollection(actionFigureCollection);
        assertEquals(2, collectionsManager.countSaleItems());
    }

    @Test
    public void canCalculateProfitIfSold(){
        item.setNewMarketValue(25.00);
        item.changeForSaleStatusToTrue();
        item3.setNewMarketValue(16.00);
        item3.changeForSaleStatusToTrue();
        collectionsManager.addSellableItemsFromCollection(drinkCollection);
        collectionsManager.addSellableItemsFromCollection(actionFigureCollection);
        assertEquals(6.00, collectionsManager.calculateProfitIfSold(), 0.01);
    }

    @Test
    public void canCalculateTotalPercentageProfitIfSold() {
        item.setNewMarketValue(25.00);
        item.changeForSaleStatusToTrue();
        item3.setNewMarketValue(16.00);
        item3.changeForSaleStatusToTrue();
        collectionsManager.addSellableItemsFromCollection(drinkCollection);
        collectionsManager.addSellableItemsFromCollection(actionFigureCollection);
        assertEquals(18.36, collectionsManager.calculateTotalPercentageProfitIfItemsSold(), 0.01);
    }

    @Test
    public void canSellAnItem() {
        item.setNewMarketValue(25.00);
        item.changeForSaleStatusToTrue();
        item1.setNewMarketValue(19.00);
        item1.changeForSaleStatusToTrue();
        collectionsManager.addSellableItemsFromCollection(drinkCollection);
        collectionsManager.sellItem(item, drinkCollection);
        collectionsManager.sellItem(item1, drinkCollection);
        assertEquals(0, collectionsManager.countSaleItems());
        assertEquals(3.50, collectionsManager.getProfit(), 0.01);
        assertEquals(0, drinkCollection.countItems());
    }

    @Test
    public void cannotSellItemIfNotInArray() {
        item.setNewMarketValue(25.00);
        item.changeForSaleStatusToTrue();
        item1.setNewMarketValue(19.00);
        item1.changeForSaleStatusToTrue();
        collectionsManager.addSellableItemsFromCollection(drinkCollection);
        collectionsManager.sellItem(item3, drinkCollection);
        assertEquals(2, collectionsManager.countSaleItems());
    }

    @Test
    public void canCountDonationItems() {
        assertEquals(0, collectionsManager.countDonationItems());
    }

    @Test
    public void canAddAnItemForDonation() {
        actionFigure3.markForDonation();
        collectionsManager.addItemForDonation(actionFigure3);
        assertEquals(1, collectionsManager.countDonationItems());
    }

    @Test
    public void checkIfItemForDonationIsInListBeforeDonation() {
        actionFigure3.markForDonation();
        collectionsManager.addItemForDonation(actionFigure3);
        assertEquals(true, collectionsManager.findItemForDonation(actionFigure3));
    }

    @Test
    public void canDonateItem() {
        actionFigure3.markForDonation();
        collectionsManager.addItemForDonation(actionFigure3);
        collectionsManager.donateItem(actionFigure3, actionFigureCollection);
        assertEquals(0, collectionsManager.countDonationItems());
        assertEquals(1, collectionsManager.getItemsDonated());
        assertEquals(2, actionFigureCollection.countItems());
    }

    @Test
    public void cannotDonateItemNotInList() {
        actionFigure3.markForDonation();
        collectionsManager.donateItem(actionFigure3, actionFigureCollection);
        assertEquals(0, collectionsManager.getItemsDonated());
        assertEquals(0, collectionsManager.countDonationItems());
        assertEquals(3, actionFigureCollection.countItems());
    }

    @Test
    public void canSortSellableItemsByPotentialProfit() {
        item.setNewMarketValue(25.00);
        item.changeForSaleStatusToTrue();
        item1.setNewMarketValue(28.00);
        item1.changeForSaleStatusToTrue();
        item3.setNewMarketValue(13.00);
        item3.changeForSaleStatusToTrue();
        collectionsManager.addSellableItemsFromCollection(drinkCollection);
        collectionsManager.addSellableItemsFromCollection(actionFigureCollection);
        collectionsManager.sortByProfit();
        System.out.println(collectionsManager.getForSaleItems());
        assertEquals(item1, collectionsManager.getForSaleItems().get(0));
    }

    @Test
    public void canSortSellableItemsByPurchaseYear() {
        item.setNewMarketValue(25.00);
        item.changeForSaleStatusToTrue();
        item1.setNewMarketValue(28.00);
        item1.changeForSaleStatusToTrue();
        item3.setNewMarketValue(13.00);
        item3.changeForSaleStatusToTrue();
        collectionsManager.addSellableItemsFromCollection(drinkCollection);
        collectionsManager.addSellableItemsFromCollection(actionFigureCollection);
        collectionsManager.sortByPurchaseYear();
        assertEquals(item3, collectionsManager.getForSaleItems().get(0));
    }

}
