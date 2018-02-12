package org.conversionapplication.numeral;

import org.conversionapplication.interfaces.NumeralInterface;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Class to convert string representing decimal numbers into other numeral systems
 *
 */


public class Decimal implements NumeralInterface {

    final String DECIMAL = "DECIMAL";


    /**
     * Method to convert decimal integer strings into roman numbers.
     * Implementation source: https://stackoverflow.com/questions/12967896/converting-integers-to-roman-numerals-java
     *
     * @param number       the decimal number to be converted
     * @return             the roman conversion
     */

    private final String convertToRomanString(int number) {

    LinkedHashMap<String, Integer> roman_numerals = new LinkedHashMap<String, Integer>();
    roman_numerals.put("M", 1000);
    roman_numerals.put("CM", 900);
    roman_numerals.put("D", 500);
    roman_numerals.put("CD", 400);
    roman_numerals.put("C", 100);
    roman_numerals.put("XC", 90);
    roman_numerals.put("L", 50);
    roman_numerals.put("XL", 40);
    roman_numerals.put("X", 10);
    roman_numerals.put("IX", 9);
    roman_numerals.put("V", 5);
    roman_numerals.put("IV", 4);
    roman_numerals.put("I", 1);
    String res = "";
    for(Map.Entry<String, Integer> entry : roman_numerals.entrySet()){
        int matches = number/entry.getValue();
        res += repeat(entry.getKey(), matches);
        number = number % entry.getValue();
    }
    return res;
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


/*
    private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();

    static {

        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

    }

    private final String convertToRomanString(int number) {
        int l =  map.floorKey(number);
        if ( number == l ) {
            return map.get(number);
        }
        return map.get(l) + convertToRomanString(number-l);
    }
*/
    private final String convertToRomanString(String number) {
        return convertToRomanString(Integer.parseInt(number));
    }


    /**
     * Takes a number and converts it to the given target number system
     *
     * @param target      target numeral system into which convert
     * @param number      the number to be converted
     * @return            the result of the conversion
     */

    public String convert(String target, String number){
        target = target.toLowerCase();
        String result;
        switch(target){
            case "roman": result = convertToRomanString(number); break;
            default: result = null;
        }
        return result;
    }

    /**
     * Identifer for the conversion class
     * @return   identifier for the decimal converter
     */

    public String getId(){
        return DECIMAL;
    }

}