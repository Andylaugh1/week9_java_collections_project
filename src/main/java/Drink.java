import Interface.ISell;
import enums.DrinkType;
import sun.util.calendar.CalendarDate;

import java.util.Date;
import java.util.GregorianCalendar;

public class Drink extends Item {

    private String brand;
    private String model;
    private DrinkType drinkType;

    public Drink(String brand, String model, double buyPrice, double shippingPrice, DrinkType drinkType) {
        super(buyPrice, shippingPrice);
        this.brand = brand;
        this.model = model;
        this.drinkType = drinkType;
        
    }

    public DrinkType getDrinkType() {
        return drinkType;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

}
