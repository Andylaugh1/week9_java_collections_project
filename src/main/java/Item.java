import Interface.ISell;
import sun.util.calendar.CalendarDate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Item implements ISell {
    private double buyPrice;
    private double shippingPrice;
    private double currentMarketValue;
    private Date purchaseDate;
    private boolean isForResale;

    public Item(double buyPrice, double shippingPrice){
        this.buyPrice = buyPrice;
        this.shippingPrice = shippingPrice;
        this.purchaseDate = new Date();
        this.isForResale = false;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public double getShippingPrice() {
        return shippingPrice;
    }

    public double getCurrentMarketValue() {
        return currentMarketValue;
    }

    public void setNewMarketValue(double newMarketValue) {
        this.currentMarketValue = newMarketValue;
    }

    public boolean getResaleStatus() {
        return this.isForResale;
    }

    public void changeForSaleStatus() {
        this.isForResale ^= true;
    }

    public double calculateProfitIfSold() {
        double potentialProfit = 0;
        if (isForResale == true) {
            potentialProfit = currentMarketValue - (buyPrice + shippingPrice);
        }
        return potentialProfit;
    }

}
