package org.conversionapplication.interfaces;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

interface NumeralInterfaceContract {

    NumeralInterface create();
    Random random = new Random();

    @Test
    default void postcondition() {

        // Integer number = random.nextInt(10) + 1;

        assertTrue(StringUtils.isNotBlank(create().convert("roman", "1")));
    }
}
