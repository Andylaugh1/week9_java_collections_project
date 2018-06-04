import enums.WrestlerType;

public class WrestlingFigure extends Item {

    private String name;
    private WrestlerType wrestlerType;
    private String finishingMove;

    public WrestlingFigure(String name, WrestlerType wrestlerType, String finishingMove, double buyPrice, double shippingPrice) {
        super(buyPrice, shippingPrice);
        this.name = name;
        this.wrestlerType = wrestlerType;
        this.finishingMove = finishingMove;
    }

    public String getName() {
        return this.name;
    }

    public WrestlerType getWrestlerType() {
        return wrestlerType;
    }

    public String getFinishingMove() {
        return finishingMove;
    }
}