import org.w3c.dom.ls.LSOutput;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringAlgos {
    /**
     * Returns whether the parameter s is a palindrome
     * @param s a String, the potential palindrome
     * @return boolean
     */
    public static boolean isPalindromic(String s) {
        s = s.toLowerCase();
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }

    /**
     * Convert a string to an integer
     * @param s a String to decode
     * @return the decoded string as type- int
     */
    public static int string2Int(String s) {

        boolean isNeg = s.startsWith("-");
        s = isNeg ? s.substring(1): s;
        int result = 0;
        for (double power = 0, idx = s.length() - 1; idx >= 0 ; power++, idx--) {
            int charIntValue = s.charAt((int)idx) - 48;
            if ((charIntValue < 0 ) | (charIntValue > 9)) throw new NumberFormatException("please only input digits!!!");
            result += charIntValue * (int)Math.pow(10.0, power);
        }

        return isNeg ? -result: result;
    }

    /**
     * Convert an int to a String encoded the int
     * @param number the number to encode
     * @return a String representing the encoded parameter int
     */
    public static String Int2String(int number) {
        boolean isNeg = number < 0;
        number = isNeg ? -number: number;
        StringBuilder result = new StringBuilder();
        // init
        int remainder;
        char temp;
        while(number > 0) {
            remainder = number % 10;
            number = number / 10;
            temp = (char) (remainder + 48);
            result.append(temp);
        }
        if(isNeg) result.append("-");
        return result.reverse().toString();
    }

    /**
     * Covert a number encoded as a String from base1 to base2.
     * First convert string to decimal int. Then build up encoded value as a String. As in Int2String method
     * int this class. A=10, B=11... F=15
     * @param original encoded integer as a String. All char values must be uppercase.
     * @param base1 the starting base of the encoded integer. 2 <=base1 <= 15.
     * @param base2 the finishing base of the encoded integer. 2 <=base1 <= 15.
     * @return a new String representing the original number in the new base
     */
    public static String convertFromBase1ToBase2(String original, int base1, int base2) {
        StringBuilder result = new StringBuilder();
        boolean isNeg = original.startsWith("-");
        int originalInBase10 = convertToBase10(original, base1);

        return result.toString();
    }

    /**
     * converts an integer encoded as a String(ex. "135") to decimal integer
     * @param num the encoding String
     * @param base the base the encoded number is in
     * @return a integer in base10
     */
    public static int convertToBase10(String num, int base) {
        int originalAsInteger = 0;
        boolean isNeg = num.startsWith("-");
        for(int i = isNeg ? 1:0; i < num.length(); i++){
            char charIdx = num.charAt(i);
            int temp = Character.isDigit(charIdx) ? charIdx - '0': charIdx - 'A' + 10; // first test: is it A-F or just a digit
            if(!(temp < base)) throw new NumberFormatException("the char is too big for the base: " + (int)temp + " < " + base + " is False" );
            originalAsInteger *= base;
            originalAsInteger += temp;
        }
        return originalAsInteger;
    }

    public static String convertFromBase10(int num, int baseEnd) {
        int remainder = num%baseEnd;
        return null;
    }
    public static void main(String[] args) {
    }

}

