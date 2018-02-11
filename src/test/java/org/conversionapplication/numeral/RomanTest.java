package org.conversionapplication.numeral;

import org.junit.Test;
import org.conversionapplication.numeral.Roman;

import static org.junit.Assert.assertEquals;


//  https://dzone.com/articles/thursday-code-puzzler-roman

public class RomanTest {

    @Test
    public void decimalsConvertedCorrectly(){

        final Roman romanNumeral = new Roman();
        final String decimal = "decimal";

        final String a = romanNumeral.convert(decimal, "DCCCXC");
        final String b = romanNumeral.convert(decimal, "MDCCC");
        final String c = romanNumeral.convert(decimal, "LXXXIV");
//        final String d = romanNumeral.convert(decimal, "DCDLXLVIII");
        final String d = romanNumeral.convert(decimal, "CMXCVIII");
        final String e = romanNumeral.convert(decimal, "IV");
        final String f = romanNumeral.convert(decimal, "VI");
        final String g = romanNumeral.convert(decimal, "XCIX");

        assertEquals(a, "890");
        assertEquals(b, "1800");
        assertEquals(c, "84");
        assertEquals(d, "998");
        assertEquals(e, "4");
        assertEquals(f, "6");
        assertEquals(g, "99");

    }

}
