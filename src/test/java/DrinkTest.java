import enums.DrinkType;
import org.junit.Before;
import org.junit.Test;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class DrinkTest {

    Drink drink;
    Date purchaseDate;

    @Before
    public void before() {

        purchaseDate = new Date();
        drink = new Drink("Smirnoff", "Red Label",2012,20.00,2.00, DrinkType.VODKA);
    }

    @Test
    public void canGetMake() {
        assertEquals("Smirnoff", drink.getBrand());
    }

    @Test
    public void canGetModel() {
        assertEquals("Red Label", drink.getModel());
    }

//    @Test
//    public void canSetPurchaseDate() {
//        drink.setPurchaseDate(purchaseDate);
//        System.out.println(purchaseDate);
//        assertEquals(purchaseDate, drink.getPurchaseDate());
//    }

    @Test
    public void canGetPurchaseDate(){
        assertEquals(2012, drink.getPurchaseYear());
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
        drink.changeForSaleStatusToTrue();
        assertEquals(true, drink.getResaleStatus());
    }

    @Test
    public void canSetResaleStatusBackToFalse() {
        drink.changeForSaleStatusToTrue();
        drink.changeForSaleStatusBackToFalse();
        assertEquals(false, drink.getResaleStatus());
    }

    @Test
    public void cannotSetToReSellableIfSetAsFavourite() {
        drink.changeFavouriteStatus();
        drink.changeForSaleStatusToTrue();
        assertEquals(true, drink.getFavouriteStatus());
        assertEquals(false, drink.getResaleStatus());
    }

    @Test
    public void canGetFavouriteStatusFalse() {
        assertEquals(false, drink.getFavouriteStatus());
    }

    @Test
    public void canChangeFavouriteStatus() {
        drink.changeFavouriteStatus();
        assertEquals(true, drink.getFavouriteStatus());
    }

    @Test
    public void canChangeFavouriteStatusBackToFalse() {
        drink.changeFavouriteStatus();
        drink.changeFavouriteStatus();
        assertEquals(false, drink.getFavouriteStatus());
    }
}
