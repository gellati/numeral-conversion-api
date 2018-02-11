package org.conversionapplication.numeral;

import org.junit.Test;
import org.conversionapplication.numeral.Decimal;

import static org.junit.Assert.assertEquals;

public class DecimalTest {

    @Test
    public void romansConvertedCorrectly(){

        final Decimal decimal = new Decimal();
        final String roman = "roman";

        final String a = decimal.convert(roman, "890");
        final String b = decimal.convert(roman, "1800");
        final String c = decimal.convert(roman, "84");
        final String d = decimal.convert(roman, "998");
        final String e = decimal.convert(roman, "4");
        final String f = decimal.convert(roman, "6");
        final String g = decimal.convert(roman, "99");

        assertEquals(a, "DCCCXC");
        assertEquals(b, "MDCCC");
        assertEquals(c, "LXXXIV");
//        assertEquals(d, "DCDLXLVIII");
        assertEquals(d, "CMXCVIII");
        assertEquals(e, "IV");
        assertEquals(f, "VI");
        assertEquals(g, "XCIX");

    }

}
