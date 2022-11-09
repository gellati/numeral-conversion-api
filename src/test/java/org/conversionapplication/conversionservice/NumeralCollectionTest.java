package org.conversionapplication.conversionservice;

import org.conversionapplication.interfaces.NumeralInterface;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Numeral collection test")
public class NumeralCollectionTest {
    @Test
    public void testGetRomanNumeral1() {
        NumeralCollection nc = new NumeralCollection();
        NumeralInterface ni = nc.getNumeral("roman");
        assertEquals("ROMAN", ni.getId(), "roman numeral ok");
    }
    @Test
    public void testGetDecimalNumeral() {
        NumeralCollection nc = new NumeralCollection();
        NumeralInterface ni = nc.getNumeral("decimal");
        assertEquals("DECIMAL", ni.getId(), "decimal numeral ok");
    }


    // assertEquals("II", ni.convert("roman", "II"), "conversion ok");
}
