import enums.ActionFigureType;
import enums.DrinkType;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class CollectionsManagerTest {

    CollectionsManager collectionsManager;
    Collection drinkCollection, actionFigureCollection;
    Drink drink1, drink2;
    ActionFigure actionFigure1, actionFigure2, actionFigure3, actionFigure4;

    @Before
    public void before() {


        drink1 = new Drink("Smirnoff", "Red Label", 2012, 20.00, 2.00, DrinkType.VODKA);
        drink2 = new Drink("Gordon's", "Gordon's", 2011,17.00, 1.50, DrinkType.GIN);
        actionFigure1 = new ActionFigure("Stone Cold", ActionFigureType.WRESTLER, 2003,"Stunner", 10.00, 3.00 );
        actionFigure2 = new ActionFigure("Wolverine", ActionFigureType.XMAN, 1997,"Regeneration", 12.00, 1.00 );
        actionFigure3 = new ActionFigure("Peter Venkman", ActionFigureType.GHOSTBUSTER, 1990,"Hilarity", 6.00, 0.00 );
        actionFigure4 = new ActionFigure("Cyclops", ActionFigureType.XMAN, 1994,"Laser Eyes", 10.00, 2.00 );

        drinkCollection = new Collection();

        actionFigureCollection = new Collection();

        collectionsManager = new CollectionsManager();


        drinkCollection.addItem(drink1);
        drinkCollection.addItem(drink2);
        actionFigureCollection.addItem(actionFigure1);
        actionFigureCollection.addItem(actionFigure2);
        actionFigureCollection.addItem(actionFigure3);
    }


    @Test
    public void canCountSellableItems(){
        assertEquals(0, collectionsManager.countSaleItems());
    }

    @Test
    public void canAddSellableItem(){
        collectionsManager.addSaleItem(drink2);
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
        drink1.setNewMarketValue(25.00);
        drink1.changeForSaleStatusToTrue();
        actionFigure2.setNewMarketValue(16.00);
        actionFigure2.changeForSaleStatusToTrue();
        collectionsManager.addSellableItemsFromCollection(drinkCollection);
        collectionsManager.addSellableItemsFromCollection(actionFigureCollection);
        assertEquals(2, collectionsManager.countSaleItems());
    }

    @Test
    public void canCalculateProfitIfSold(){
        drink1.setNewMarketValue(25.00);
        drink1.changeForSaleStatusToTrue();
        actionFigure2.setNewMarketValue(16.00);
        actionFigure2.changeForSaleStatusToTrue();
        collectionsManager.addSellableItemsFromCollection(drinkCollection);
        collectionsManager.addSellableItemsFromCollection(actionFigureCollection);
        assertEquals(6.00, collectionsManager.calculateProfitIfSold(), 0.01);
    }

    @Test
    public void canCalculateAveragePercentageProfitIfSold() {
        drink1.setNewMarketValue(25.00);
        drink1.changeForSaleStatusToTrue();
        actionFigure2.setNewMarketValue(16.00);
        actionFigure2.changeForSaleStatusToTrue();
        collectionsManager.addSellableItemsFromCollection(drinkCollection);
        collectionsManager.addSellableItemsFromCollection(actionFigureCollection);
        assertEquals(18.36, collectionsManager.calculateAveragePercentageProfitIfItemsSold(), 0.01);
    }

    @Test
    public void canSellAnItem() {
        drink1.setNewMarketValue(25.00);
        drink1.changeForSaleStatusToTrue();
        drink2.setNewMarketValue(19.00);
        drink2.changeForSaleStatusToTrue();
        collectionsManager.addSellableItemsFromCollection(drinkCollection);
        collectionsManager.sellItem(drink1, drinkCollection);
        collectionsManager.sellItem(drink2, drinkCollection);
        assertEquals(0, collectionsManager.countSaleItems());
        assertEquals(3.50, collectionsManager.getProfit(), 0.01);
        assertEquals(0, drinkCollection.countItems());
    }

    @Test
    public void cannotSellItemIfNotInArray() {
        drink1.setNewMarketValue(25.00);
        drink1.changeForSaleStatusToTrue();
        drink2.setNewMarketValue(19.00);
        drink2.changeForSaleStatusToTrue();
        collectionsManager.addSellableItemsFromCollection(drinkCollection);
        collectionsManager.sellItem(actionFigure2, drinkCollection);
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
        collectionsManager.donateItem(actionFigure3, actionFigureCollection, "The Children's Hospital");
        assertEquals(0, collectionsManager.countDonationItems());
        assertEquals(1, collectionsManager.getItemsDonated());
        assertEquals(2, actionFigureCollection.countItems());
    }

    @Test
    public void cannotDonateItemNotInList() {
        actionFigure3.markForDonation();
        collectionsManager.donateItem(actionFigure3, actionFigureCollection, "The Children's Hospital");
        assertEquals(0, collectionsManager.getItemsDonated());
        assertEquals(0, collectionsManager.countDonationItems());
        assertEquals(3, actionFigureCollection.countItems());
    }

    @Test
    public void canAddManyItemsToDonationList() {
        actionFigure3.markForDonation();
        actionFigure2.markForDonation();
        actionFigure1.markForDonation();
        ArrayList itemsForDonation = new ArrayList();
        itemsForDonation.add(actionFigure1);
        itemsForDonation.add(actionFigure2);
        itemsForDonation.add(actionFigure3);
        collectionsManager.addManyItemsToDonationList(itemsForDonation);
        assertEquals(3, collectionsManager.countDonationItems());
    }

    @Test
    public void canDonateManyItemsAtOnce() {
        actionFigure3.markForDonation();
        actionFigure2.markForDonation();
        actionFigure1.markForDonation();
        ArrayList itemsForDonation = new ArrayList();
        itemsForDonation.add(actionFigure1);
        itemsForDonation.add(actionFigure2);
        itemsForDonation.add(actionFigure3);
        collectionsManager.addManyItemsToDonationList(itemsForDonation);
        collectionsManager.donateManyItemsAtOnce(itemsForDonation, "The Children's Hospital");
        assertEquals(3, collectionsManager.getItemsDonated());
    }

    @Test
    public void cannotDonateManyItemsIfNotInList() {
        actionFigure3.markForDonation();
        actionFigure2.markForDonation();
        actionFigure1.markForDonation();
        ArrayList itemsForDonation = new ArrayList();
        itemsForDonation.add(actionFigure1);
        itemsForDonation.add(actionFigure2);
        itemsForDonation.add(actionFigure3);
        collectionsManager.addItemForDonation(actionFigure1);
        collectionsManager.addItemForDonation(actionFigure2);
        collectionsManager.donateManyItemsAtOnce(itemsForDonation, "The Children's Hospital");
        assertEquals(2, collectionsManager.getItemsDonated());

    }


    @Test
    public void canSortSellableItemsByPotentialProfit() {
        drink1.setNewMarketValue(25.00);
        drink1.changeForSaleStatusToTrue();
        drink2.setNewMarketValue(28.00);
        drink2.changeForSaleStatusToTrue();
        actionFigure2.setNewMarketValue(13.00);
        actionFigure2.changeForSaleStatusToTrue();
        collectionsManager.addSellableItemsFromCollection(drinkCollection);
        collectionsManager.addSellableItemsFromCollection(actionFigureCollection);
        collectionsManager.sortByProfit();
        System.out.println(collectionsManager.getForSaleItems());
        assertEquals(Arrays.asList(drink2, drink1, actionFigure2), collectionsManager.getForSaleItems());
    }

    @Test
    public void canSortSellableItemsByPurchaseYear() {
        drink1.setNewMarketValue(25.00);
        drink1.changeForSaleStatusToTrue();
        drink2.setNewMarketValue(28.00);
        drink2.changeForSaleStatusToTrue();
        actionFigure2.setNewMarketValue(13.00);
        actionFigure2.changeForSaleStatusToTrue();
        collectionsManager.addSellableItemsFromCollection(drinkCollection);
        collectionsManager.addSellableItemsFromCollection(actionFigureCollection);
        collectionsManager.sortByPurchaseYear();
        assertEquals(Arrays.asList(actionFigure2, drink2, drink1), collectionsManager.getForSaleItems());
    }

    @Test
    public void canSwapAnItem() {
        System.out.println(actionFigureCollection.getItems());
        collectionsManager.swapItem(actionFigureCollection, actionFigure2, actionFigure4);
        System.out.println(actionFigureCollection.getItems());
        assertEquals(Arrays.asList(actionFigure1, actionFigure3, actionFigure4), actionFigureCollection.getItems());

    }

}
