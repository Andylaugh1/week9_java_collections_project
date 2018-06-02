

public class Item {
    private String purchaseDate;
    private double buyPrice;
    private double shippingPrice;
    private double currentMarketValue;
    private boolean isForResale;

    public Item(String purchaseDate, double buyPrice, double shippingPrice){
        this.purchaseDate = purchaseDate;
        this.buyPrice = buyPrice;
        this.shippingPrice = shippingPrice;
        this.currentMarketValue = currentMarketValue;
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
}
