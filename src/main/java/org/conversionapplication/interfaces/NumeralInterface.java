package org.conversionapplication.interfaces;

/**
 * Interface for numeral conversion classes.
 *
 * Only two methods needed, one for getting the id of the numeral class and the
 * other for doing the conversion
 *
 */

public interface NumeralInterface {
    String getId();
    String convert(String target, String number);
}
