import enums.TShirtType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TShirtTest {
    TShirt tshirt;

    @Before
    public void before() {
        tshirt = new TShirt("Decathlon", "Black", TShirtType.V_NECK, 2.99, 0.00);

    }

    @Test
    public void canGetBrand() {
        assertEquals("Decathlon", tshirt.getbrand());
    }

    @Test
    public void canGetColour() {
        assertEquals("Black", tshirt.getColour());
    }

    @Test
    public void canGetType() {
        assertEquals(TShirtType.V_NECK, tshirt.getTshirtType());
    }

    @Test
    public void canCalculatePotentialProfitItemIsSellable() {
        tshirt.changeForSaleStatusToTrue();
        tshirt.setNewMarketValue(3.50);
        assertEquals(0.51, tshirt.calculateProfitIfSold(), 0.01);
    }
}
