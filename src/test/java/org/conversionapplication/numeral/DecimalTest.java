package org.conversionapplication.numeral;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.conversionapplication.interfaces.NumeralInterface;
import org.conversionapplication.interfaces.NumeralInterfaceContract;

public class DecimalTest implements NumeralInterfaceContract {

    @Override
    public NumeralInterface create() {
        return new Decimal();
    }

    NumeralInterface decimal;

    @BeforeEach
    public void setup() {
        decimal = create();
    }

    @Test
    public void romansConvertedCorrectly(){

        final String roman = "roman";

        final String a = decimal.convert(roman, "890");
        final String b = decimal.convert(roman, "1");
        final String c = decimal.convert(roman, "84");
        final String d = decimal.convert(roman, "998");
        final String e = decimal.convert(roman, "4");
        final String f = decimal.convert(roman, "6");
        final String g = decimal.convert(roman, "99");

        assertEquals("DCCCXC", a);
        assertEquals("I", b);
        assertEquals("LXXXIV", c);
        assertEquals("CMXCVIII", d);
        assertEquals("IV", e);
        assertEquals("VI", f);
        assertEquals("XCIX", g);

    }

    @Test
    public void testNullTarget(){
        Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            public void execute() throws Throwable {
                decimal.convert("non", "I");
            }
        });
    }

    @Test
    public void testOutOfRangeException(){
        Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                final String roman = "roman";
                decimal.convert(roman, "4321");
            }
        });
    }

    @Test
    public void testNonNumericalException(){
        Assertions.assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                final String roman = "roman";
                decimal.convert(roman, "3s1");
            }
        });
    }
}
