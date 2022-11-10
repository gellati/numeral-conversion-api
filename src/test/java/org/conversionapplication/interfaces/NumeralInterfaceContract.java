package org.conversionapplication.interfaces;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public interface NumeralInterfaceContract {

    NumeralInterface create();
    Random random = new Random();

    @Test
    default void postcondition() {

        assertThrows(
            IllegalArgumentException.class,
            new Executable() {

                @Override
                public void execute() throws Throwable {
                    create().convert("elephant", "x");
                }
            }
        );
    }
}
