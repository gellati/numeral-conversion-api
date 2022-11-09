package org.conversionapplication.numeral;

import org.conversionapplication.interfaces.NumeralInterface;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Class to convert string representing decimal numbers into other numeral systems
 *
 */


public class Decimal implements NumeralInterface {

    static final String DECIMAL = "DECIMAL";


    /**
     * Method to convert decimal integer strings into roman numbers.
     * Implementation source: https://stackoverflow.com/questions/12967896/converting-integers-to-roman-numerals-java
     *
     * @param number       the decimal number to be converted
     * @return             the roman conversion
     */

    private final String convertToRomanString(int number) {

    LinkedHashMap<String, Integer> romanNumerals = new LinkedHashMap<>();
    romanNumerals.put("M", 1000);
    romanNumerals.put("CM", 900);
    romanNumerals.put("D", 500);
    romanNumerals.put("CD", 400);
    romanNumerals.put("C", 100);
    romanNumerals.put("XC", 90);
    romanNumerals.put("L", 50);
    romanNumerals.put("XL", 40);
    romanNumerals.put("X", 10);
    romanNumerals.put("IX", 9);
    romanNumerals.put("V", 5);
    romanNumerals.put("IV", 4);
    romanNumerals.put("I", 1);
    StringBuilder res = new StringBuilder();
    for(Map.Entry<String, Integer> entry : romanNumerals.entrySet()){
        int matches = number/entry.getValue();
        res.append(repeat(entry.getKey(), matches));
        number = number % entry.getValue();
    }
    return res.toString();
    }
    public static String repeat(String s, int n) {
        if(s == null) {
            return null;
        }
        final StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }

    private final String convertToRomanString(String number) {
        return convertToRomanString(Integer.parseInt(number));
    }

    /**
     * Takes a number and converts it to the given target number system. Must be a positive integer.
     *
     * @param target      target numeral system into which convert
     * @param number      the number to be converted
     * @return            the result of the conversion
     */

    public String convert(String target, String number){
        if(!org.apache.commons.lang3.StringUtils.isNumeric(number)){
            throw new IllegalArgumentException("Not a positive integer:" + number);
        }
        if(Integer.parseInt(number) > 1000){
            throw new IllegalArgumentException("Number out of range:" + number);
        }

        target = target.toLowerCase();

        if (target.equals("roman")) {
            return convertToRomanString(number);
        } else {
            return null;
        }
    }

    /**
     * Identifer for the conversion class
     * @return   identifier for the decimal converter
     */

    public String getId(){
        return DECIMAL;
    }

}