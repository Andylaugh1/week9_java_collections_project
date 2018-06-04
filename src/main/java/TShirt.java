import enums.TShirtType;

public class TShirt extends Item {

    private String brand;
    private String colour;
    private TShirtType tshirtType;

    public TShirt(String brand, String colour, TShirtType tshirtType, double buyPrice, double shippingPrice) {
        super( buyPrice, shippingPrice);
        this.brand = brand;
        this.colour = colour;
        this.tshirtType = tshirtType;
    }

    public String getbrand() {
        return brand;
    }

    public String getColour() {
        return colour;
    }

    public TShirtType getTshirtType() {
        return tshirtType;
    }
}
