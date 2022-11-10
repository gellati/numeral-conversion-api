package org.conversionapplication.numeral;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.conversionapplication.interfaces.NumeralInterface;
import org.conversionapplication.interfaces.NumeralInterfaceContract;


//  https://dzone.com/articles/thursday-code-puzzler-roman

public class RomanTest implements NumeralInterfaceContract {

    @Override
    public NumeralInterface create() {
        return new Roman();
    }

    NumeralInterface roman;

    @BeforeEach
    public void setup() {
       roman = create();
    }

    @Test
    public void decimalsConvertedCorrectly(){

        final String decimal = "decimal";

        final String a = roman.convert(decimal, "DCCCXC");
        final String b = roman.convert(decimal, "MDCCC");
        final String c = roman.convert(decimal, "LXXXIV");
        final String d = roman.convert(decimal, "CMXCVIII");
        final String e = roman.convert(decimal, "IV");
        final String f = roman.convert(decimal, "VI");
        final String g = roman.convert(decimal, "XCIX");

        assertEquals("890", a);
        assertEquals("1800", b);
        assertEquals("84", c);
        assertEquals("998", d);
        assertEquals("4", e);
        assertEquals("6", f);
        assertEquals("99", g);

    }

    @Test
    public void testNullTarget(){
        Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            public void execute() throws Throwable {
                roman.convert("non", "1");
            }
        });
    }

    @Test
    public void testIllegalRomanCharacter(){
        Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                final String decimal = "decimal";
                roman.convert(decimal, "ACCCXC");
            }
        });
    }

    @Test
    public void testNonRomanNumber(){
        Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute () throws Throwable {
                final String decimal = "decimal";
                roman.convert(decimal, "IIII");
            }
        });
    }

    @Test
    public void testIllegalSubtract(){
        Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                final String decimal = "decimal";
                roman.convert(decimal, "IL");
            }
        });
    }
}
