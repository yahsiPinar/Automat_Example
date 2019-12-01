import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class CoinsTest {

    @Test
    public void findChange() {

        Coins coin = new Coins();
        String expected = "1x  0.5TL\n\t1x  5.0TL\n\t5x  10.0TL\n\t";
        String expected2 = "00.00 TL";
        assertEquals(expected,coin.findChange(55.50));
        assertEquals(expected2,coin.findChange(0));

    }
}