import Interface.ISell;

public class Item implements ISell {
    private double buyPrice;
    private double shippingPrice;
    private double currentMarketValue;
    private String purchaseDate;
    private boolean isForResale;

    public Item(String purchaseDate, double buyPrice, double shippingPrice){
        this.buyPrice = buyPrice;
        this.shippingPrice = shippingPrice;
        this.purchaseDate = purchaseDate;
        this.isForResale = false;
    }


    public String getPurchaseDate() {
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
