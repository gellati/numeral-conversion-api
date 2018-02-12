package org.conversionapplication.conversionservice;

import com.google.common.collect.ImmutableList;
import org.conversionapplication.interfaces.NumeralInterface;
import org.conversionapplication.numeral.Decimal;
import org.conversionapplication.numeral.Roman;

import java.util.NoSuchElementException;

public class NumeralCollection {


    /**
     * Adopting defensive programming by creating an ImmutableList of all numerals to
     * have a constant collection
     * https://github.com/google/guava/wiki/ImmutableCollectionsExplained
     */

    public static final ImmutableList<NumeralInterface> ALL_NUMERALS = ImmutableList.of(
            new Roman(),
            new Decimal()
    );

    public NumeralCollection() {
    }

    /**
     * Iterate over all elements in the ALL_NUMERALS list to find the matching one
     * @param id   string representing the desired numeral system
     * @return     the numeral class corresponding to the id
     */

    public NumeralInterface getNumeral(String id){
        return ALL_NUMERALS.stream()
                .filter(c -> c.getId().equalsIgnoreCase(id))
                .findAny()
                .orElseThrow(() -> notFoundException(id));
    }

    private static NoSuchElementException notFoundException(String id) {
        return new NoSuchElementException("Not found numeral " + id);
    }

}
