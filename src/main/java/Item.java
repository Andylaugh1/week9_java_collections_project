
import Interface.ISell;

import java.util.Date;


public class Item implements ISell {
    private double buyPrice;
    private double shippingPrice;
    private double currentMarketValue;
    private Date purchaseDate;
    private boolean isForResale;
    private boolean isFavourite;

    public Item(double buyPrice, double shippingPrice){
        this.buyPrice = buyPrice;
        this.shippingPrice = shippingPrice;
        this.purchaseDate = new Date();
        this.isForResale = false;
        this.isFavourite = false;
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

    public double calculateProfitIfSold() {
        double potentialProfit = 0;
        if (isForResale == true) {
            potentialProfit = currentMarketValue - (buyPrice + shippingPrice);
        }
        return potentialProfit;
    }

    public boolean getFavouriteStatus(){
        return this.isFavourite;
    }

    public void changeFavouriteStatus() {
        this.isFavourite ^= true;
    }

    public boolean getResaleStatus() {
        return this.isForResale;
    }

    public void changeForSaleStatusToTrue() {
        if ((getFavouriteStatus() == false) && getResaleStatus() == false) {
            this.isForResale = true;
        }

    }

    public void changeForSaleStatusBackToFalse() {
        if (getResaleStatus() == true);
        this.isForResale = false;
    }

}
