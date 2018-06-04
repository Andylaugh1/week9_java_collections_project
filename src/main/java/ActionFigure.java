import Interface.IDonate;
import enums.ActionFigureType;

public class ActionFigure extends Item implements IDonate {

    private String name;
    private ActionFigureType actionFigureType;
    private String move;
    private boolean forDonation;

    public ActionFigure(String name, ActionFigureType actionFigureType, int purchaseYear, String move, double buyPrice, double shippingPrice) {
        super(purchaseYear,buyPrice, shippingPrice);
        this.name = name;
        this.actionFigureType = actionFigureType;
        this.move = move;
        this.forDonation = false;
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
//
    public void markForDonation(){
        if (getPurchaseYear() < 2000) {
            forDonation = true;
        }

    }

    public boolean getDonationStatus() {
        return forDonation;
    }
}
