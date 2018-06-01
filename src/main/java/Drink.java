import enums.DrinkType;

public class Drink extends Item {

    private DrinkType drinkType;

    public Drink(String make, String model, String purchaseDate, double buyPrice, double shippingPrice, double currentMarketValue, DrinkType drinkType) {
        super(make, model, purchaseDate, buyPrice, shippingPrice, currentMarketValue);
        this.drinkType = drinkType;
    }
}
