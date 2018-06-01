import sun.util.calendar.BaseCalendar;

import java.util.Date;

public class Item {
    private String make;
    private String model;
    private String purchaseDate;
    private double buyPrice;
    private double shippingPrice;
    private double currentMarketValue;

    public Item(String make, String model, String purchaseDate, double buyPrice, double shippingPrice, double currentMarketValue){
        this.make = make;
        this.model = model;
        this.purchaseDate = purchaseDate;
        this.buyPrice = buyPrice;
        this.shippingPrice = shippingPrice;
        this.currentMarketValue = currentMarketValue;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
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
}
