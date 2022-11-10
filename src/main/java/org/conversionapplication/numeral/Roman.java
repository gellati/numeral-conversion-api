package org.conversionapplication.numeral;

import org.conversionapplication.interfaces.NumeralInterface;

import java.util.HashMap;
import java.util.Map;

/**
 * Class to convert string representing roman numbers into other numeral systems
 *
 */


public class Roman implements NumeralInterface {
    Map<Character, Integer> container;
    public static final String ROMAN = "ROMAN";

    public Roman() {
        container = new HashMap<>();
        container.put('I', 1);
        container.put('V', 5);
        container.put('X', 10);
        container.put('L', 50);
        container.put('C', 100);
        container.put('D', 500);
        container.put('M', 1000);
    }

    /**
     * Method to convert roman numbers to decimal numbers.
     * Implementation adapted from here: https://stackoverflow.com/questions/9073150/converting-roman-numerals-to-decimal
     * @param roman the roman number to be converted
     * @return      the converted number
     */

    private int convertToDecimalInt(String number){
        int intNum=0;
        int prev = 0;
        for(int i = number.length()-1; i>=0 ; i--)
        {
            int temp = container.get(number.charAt(i));
            if(temp < prev)
                intNum-=temp;
            else
                intNum+=temp;
            prev = temp;
        }
        return intNum;
    }

    private String convertToDecimalString(String roman){
        return Integer.toString(convertToDecimalInt(roman));
    }

    /**
     * Takes a number and converts it to the given target number system
     * Validation regex from https://stackoverflow.com/questions/9073150/converting-roman-numerals-to-decimal
     *
     * @param target      target numeral system into which convert
     * @param number      the number to be converted
     * @return            the result of the conversion
     */

    public String convert(String target, String number){
        if (target == null) {
            throw new IllegalArgumentException("Missing target numeral system");
        }
        target = target.toLowerCase();
        if (number == null || number.isEmpty() || !number.matches("^(M{0,3})(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$")){
            throw new IllegalArgumentException("Non-Roman:" + number);
        }

        if (target.equals("decimal")) {
            return convertToDecimalString(number);
        } else {
            return null;
        }
    }

    /**
     * Identifer for the conversion class
     * @return   identifier for the roman converter
     */

    public String getId(){
        return ROMAN;
    }

}