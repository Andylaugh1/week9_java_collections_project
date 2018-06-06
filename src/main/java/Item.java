
import Interface.ISell;

import java.util.Date;


public class Item implements ISell {
    private double buyPrice;
    private double shippingPrice;
    private double currentMarketValue;
    private int purchaseYear;
    private boolean isForResale;
    private boolean isFavourite;

    public Item(int purchaseYear, double buyPrice, double shippingPrice){
        this.buyPrice = buyPrice;
        this.shippingPrice = shippingPrice;
        this.purchaseYear = purchaseYear;
        this.isForResale = false;
        this.isFavourite = false;
    }


    public int getPurchaseYear() {
        return purchaseYear;
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

    public double calculatePercentageProfitIfSold() {
        double potentialPercentProfit = 0;
        if (isForResale == true) {
            potentialPercentProfit = (calculateProfitIfSold() / (buyPrice + shippingPrice)) * 100;
        }
        return potentialPercentProfit;
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
