import enums.ActionFigureType;

public class ActionFigure extends Item {

    private String name;
    private ActionFigureType actionFigureType;
    private String move;

    public ActionFigure(String name, ActionFigureType actionFigureType, String move, double buyPrice, double shippingPrice) {
        super(buyPrice, shippingPrice);
        this.name = name;
        this.actionFigureType = actionFigureType;
        this.move = move;
    }

    public String getName() {
        return this.name;
    }

    public ActionFigureType getActionFigureType() {
        return actionFigureType;
    }

    public String getMove() {
        return move;
    }
}
