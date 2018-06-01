import enums.DrinkType;

public class Drink extends Item {

    private DrinkType drinkType;

    public Drink(String make, String model, String purchaseDate, double buyPrice, double shippingPrice, DrinkType drinkType) {
        super(make, model, purchaseDate, buyPrice, shippingPrice);
        this.drinkType = drinkType;
    }

    public DrinkType getDrinkType() {
        return drinkType;
    }
}
