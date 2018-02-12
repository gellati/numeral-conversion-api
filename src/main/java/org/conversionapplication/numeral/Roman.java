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
    public final String ROMAN = "ROMAN";

    public Roman() {
        container = new HashMap<Character, Integer>();
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

    private int convertToDecimalInt(String number) {

        if (number.isEmpty() || number == null ) return 0;

        if (number.startsWith("M")) return 1000 + convertToDecimalInt(new StringBuilder(number).delete(0,1).toString()); // .Remove(0, 1));
        if (number.startsWith("CM")) return 900 + convertToDecimalInt(new StringBuilder(number).delete(0,2).toString()); // (number.Remove(0, 2));
        if (number.startsWith("D")) return 500 + convertToDecimalInt(new StringBuilder(number).delete(0,1).toString()); // (number.Remove(0, 1));
        if (number.startsWith("CD")) return 400 + convertToDecimalInt(new StringBuilder(number).delete(0,2).toString()); // (number.Remove(0, 2));
        if (number.startsWith("C")) return 100 + convertToDecimalInt(new StringBuilder(number).delete(0,1).toString()); // (number.Remove(0, 1));
        if (number.startsWith("XC")) return 90 + convertToDecimalInt(new StringBuilder(number).delete(0,2).toString()); // (number.Remove(0, 2));
        if (number.startsWith("L")) return 50 + convertToDecimalInt(new StringBuilder(number).delete(0,1).toString()); // (number.Remove(0, 1));
        if (number.startsWith("XL")) return 40 + convertToDecimalInt(new StringBuilder(number).delete(0,2).toString()); // (number.Remove(0, 2));
        if (number.startsWith("X")) return 10 + convertToDecimalInt(new StringBuilder(number).delete(0,1).toString()); // (number.Remove(0, 1));
        if (number.startsWith("IX")) return 9 + convertToDecimalInt(new StringBuilder(number).delete(0,2).toString()); // (number.Remove(0, 2));
        if (number.startsWith("V")) return 5 + convertToDecimalInt(new StringBuilder(number).delete(0,1).toString()); // (number.Remove(0, 1));
        if (number.startsWith("IV")) return 4 + convertToDecimalInt(new StringBuilder(number).delete(0,2).toString()); // (number.Remove(0, 2));
        if (number.startsWith("I")) return 1 + convertToDecimalInt(new StringBuilder(number).delete(0,1).toString()); // (number.Remove(0, 1));
        throw new IllegalArgumentException("something bad happened");

/*
        int intNum=0;
        int prev = 0;
        for(int i = roman.length()-1; i>=0 ; i--)
        {
            int temp = container.get(roman.charAt(i));
            if(temp < prev)
                intNum-=temp;
            else
                intNum+=temp;
            prev = temp;
        }
        return intNum;
        */
/*
        int prevNum = 0;
        int currNum = 0;
        int sum = 0;
        char[] romanChars = roman.toCharArray();
        for (int i = romanChars.length - 1; i >= 0; i--) {
            currNum = container.get(romanChars[i]);
            if (currNum == prevNum || currNum > prevNum) {
                sum += currNum;
            } else if (currNum < prevNum) {
                sum -= currNum;
            }
            prevNum = currNum;
        }
        return sum;
*/
    }

    private String convertToDecimalString(String roman){
        return Integer.toString(convertToDecimalInt(roman));
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
        System.out.println(target + ":" + number);
        switch(target){
            case "decimal": result = convertToDecimalString(number); break;
            default: result = null;
        }
        return result;
    }

    /**
     * Identifer for the conversion class
     * @return   identifier for the roman converter
     */

    public String getId(){
        return ROMAN;
    }

}