package algos.strings;

import javax.xml.stream.events.Characters;

public class RecursiveStringAlgos {
    /**
     * encode a number as a String
     * @param n an int to encode. number must be > 0 or you get the empty string.
     * @return the encoded int as a String (ex "123")
     */
    public static String int2String(int n) {
        boolean isNeg = n < 0;
        if(n == 0) return "0";
        String res = isNeg ? helper_Int2String(-n) : helper_Int2String(n);
        return isNeg ? "-" + res : res;
    }

    /**
     * helper recursive method for int2String method above
     * @param number
     * @return an encoding string for the int number
     */
    private static String helper_Int2String(int number) {
        return number == 0 ?  "" : helper_Int2String(number/10) + (char)(number%10 + '0');
    }

    /**
     * decode a String representation to integer (ex "123" -> 123)
     * @param s the String
     * @return an int representing the decoded String
     */
    public static int string2Int(String s) {
        boolean isNeg = s.startsWith("-");
        s = isNeg ? s.substring(1) : s;
        int result = helper_String2Int(s, 0, 0);
        return isNeg ? -result : result;
    }
    /**
     * the helper method for string2Int(). It keeps track of total and index into the string
     * @param s the string to decode
     * @param total a running total
     * @param idx the shifting index
     * @return the total without consideration for negativity.
     */
    private static int helper_String2Int(String s, int total, int idx) { // total = 0, idx = 0
        if (idx < s.length() && !Character.isDigit(s.charAt(idx))) throw new NumberFormatException("you can only use digits");
            total = idx == s.length()  ? total : helper_String2Int(s, (total * 10) + (s.charAt(idx) - '0'), ++idx);
        return total;
    }

    /**
     * recursive method for convert an integer from one base to another base. The number is encoded as a String
     * converted to decimal base. Then converted back to a string in the different base.
     * @param input The integer encoded as a String.
     * @param base1 The starting base of the integer.
     * @param base2 The ending base of the integer.
     * @return a String encoding the integer in base2 instead of base1.
     */
    public static String convertBase(String input, int base1, int base2) {
        boolean isNeg = input.startsWith("-");
        int numAsInt = 0;
        for(int i = isNeg ? 1 : 0; i < input.length(); i++) {
            numAsInt *= base1;
            char temp = input.charAt(i);
            numAsInt += Character.isDigit(temp) ?
                    temp - '0' :
                    temp - 'A' + 10; // for when base is larger than 10
        }
        String prefix = isNeg ? "-" : "";
        String rawOutput = numAsInt == 0 ? "0" : recursiveConvertBase(numAsInt, base2);
        return prefix + rawOutput;
    }
    /*
    private helper method for convertBase()
     */
    private static String recursiveConvertBase(int numAsInt, int base) {
        return numAsInt == 0 ? "" : recursiveConvertBase(numAsInt/base, base) +
                (char)(numAsInt % base >= 10 ? numAsInt % base + 'A' - 10 : numAsInt % base + '0');
    }

    public static void main(String[] args) {
        String s = "123";
        System.out.println((s.charAt(0) - '0'));
        System.out.println(string2Int(s));
    }
}
