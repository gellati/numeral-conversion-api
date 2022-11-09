package org.conversionapplication.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.conversionapplication.conversionservice.NumeralCollection;
import org.conversionapplication.interfaces.NumeralInterface;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Conversion test")
public class ConversionTest {
    @Test
    public void testClassCreation1() {
        Conversion conversion = new Conversion();
        conversion.setSourceNumber("2");
        assertEquals("2", conversion.getSourceNumber(), "Source number ok");
    }

    @Test
    public void testClassCreation2() {
        Conversion conversion = new Conversion("decimal", "2", "roman");
        assertEquals("2", conversion.getSourceNumber(), "Source number ok");
        assertEquals("decimal", conversion.getSourceNumeralSystem(), "Source numeral system ok");
        assertEquals("roman", conversion.getTargetNumeralSystem(), "Target numeral system ok");
    }

    @Test
    public void testSetNumber1() {
        Conversion conversion = new Conversion("decimal", "2", "roman");
        NumeralCollection numeralCollection = new NumeralCollection();
        NumeralInterface numeralInterface = numeralCollection.getNumeral("decimal");
        conversion.setTargetNumber(numeralInterface.convert("roman", "2"));
        assertEquals("II", conversion.getTargetNumber(), "set number ok");
    }

}
