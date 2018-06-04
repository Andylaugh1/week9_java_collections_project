import enums.WrestlerType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WrestlingFigureTest {

    WrestlingFigure wrestlingFigure;

    @Before
    public void before() {
        wrestlingFigure = new WrestlingFigure("Stone Cold", WrestlerType.ENTERTAINER, "Stunner", 10.00, 3.00 );
    }

    @Test
    public void test() {
        assertEquals("Stone Cold", wrestlingFigure.getName());
    }
}
