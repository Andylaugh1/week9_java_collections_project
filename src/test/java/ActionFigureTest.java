import enums.ActionFigureType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ActionFigureTest {

    ActionFigure actionFigure;

    @Before
    public void before() {
        actionFigure = new ActionFigure("Stone Cold", ActionFigureType.WRESTLER, 1999, "Stunner", 10.00, 3.00 );
    }

    @Test
    public void canGetName() {
        assertEquals("Stone Cold", actionFigure.getName());
    }

    @Test
    public void canGetType() {
        assertEquals(ActionFigureType.WRESTLER, actionFigure.getActionFigureType());
    }

    @Test
    public void canGetFinishingMove() {
        assertEquals("Stunner", actionFigure.getMove());
    }

    @Test
    public void canGetDonationStatus() {
        assertEquals(false, actionFigure.getDonationStatus());
    }

    @Test
    public void canChangeDonationStatus() {
        actionFigure.markForDonation();
        assertEquals(true, actionFigure.getDonationStatus());
    }

}
