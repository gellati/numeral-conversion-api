package org.conversionapplication.numeral;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import static org.junit.jupiter.api.Assertions.assertEquals;


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

        assertEquals("890", a);
        assertEquals("1800", b);
        assertEquals("84", c);
        assertEquals("998", d);
        assertEquals("4", e);
        assertEquals("6", f);
        assertEquals("99", g);

    }

    @Test
    public void testIllegalRomanCharacter(){
        Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                final Roman romanNumeral = new Roman();
                final String decimal = "decimal";
                romanNumeral.convert(decimal, "ACCCXC");
            }
        });
    }

    @Test
    public void testNonRomanNumber(){
        Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute () throws Throwable {
                final Roman romanNumeral = new Roman();
                final String decimal = "decimal";
                romanNumeral.convert(decimal, "IIII");
            }
        });
    }

    @Test
    public void testIllegalSubtract(){
        Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                final Roman romanNumeral = new Roman();
                final String decimal = "decimal";
                final String a = romanNumeral.convert(decimal, "IL");
                System.out.println(a);
            }
        });
    }
}
