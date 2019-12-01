import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class CoinsTest {

    @Test
    public void findChange() {

        Coins coin = new Coins();
        String expected = "İade Tutarı: \n\t1x  0.5TL\n\t1x  5.0TL\n\t5x  10.0TL\n\t";
        String expected2 = "İade Tutarı: \n\t00.00 TL";
        assertEquals(expected,coin.findChange(55.50));
        assertEquals(expected2,coin.findChange(0));

    }
}