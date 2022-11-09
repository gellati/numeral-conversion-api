package org.conversionapplication.interfaces;

import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.hamcrest.MatcherAssert.assertThat;


import org.conversionapplication.numeral.Decimal;
import org.conversionapplication.numeral.Roman;
import org.junit.jupiter.api.Test;

// import org.junit.runner.RunWith;
import org.junit.jupiter.api.extension.ExtendWith;
// import org.junit.runners.Parameterized;
import org.junit.jupiter.params.ParameterizedTest;


import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Pattern;

/**
 * Test class for testing the numeralInterface interface
 */

// @RunWith(Parameterized.class)
// @ExtendWith(Parameterized.class)
public class NumeralInterfaceTest { // implements NumeralInterfaceContract{

    /*
    @Override
    public NumeralInterface create() {
        return new NumeralInterface();
    }

    public NumeralInterface numeralInterface;

//    private static final String NUMERAL_NAME_PATTERN = "^[A-Za-z]{1,63}$";
    private static final String NUMERAL_NAME_PATTERN = "^(DECIMAL|ROMAN)$";
    private static Pattern pNumeralName = Pattern.compile(NUMERAL_NAME_PATTERN);


    public NumeralInterfaceTest(NumeralInterface numeralInterface) {
        this.numeralInterface = numeralInterface;
    }

    @Test
    public final void testGetId(){
        assertTrue(pNumeralName.matcher(numeralInterface.getId()).find());
    }

    // @ParameterizedTest
    @Parameterized.Parameters
    public static Collection<Object[]> instancesToTest(){
        return Arrays.asList(
                new Object[]{new Decimal()},
                new Object[]{new Roman()}
        );
    }
*/

    /*
    @Test
    public final void testConvert(){

    }
*/

}
