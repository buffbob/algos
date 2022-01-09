public class RecursiveStringAlgos {
    /**
     * encode a number as a String
     * @param n an int to encode. number must be > 0 or you get the empty string.
     * @return the encoded int as a String (ex "123")
     */
    public static String int2String(int n) {
        boolean isNeg = n < 0;
        if(n == 0) return "0";
        String res = isNeg ? recurInt2String(-n) : recurInt2String(n);
        return isNeg ? "-" + res : res;
    }

    /**
     * helper recursive method for int2String method above
     * @param number
     * @return an encoding string for the int number
     */
    private static String recurInt2String(int number) {
        return number == 0 ?  "" : recurInt2String(number/10) + (char)(number%10 + '0');
    }


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

    public static int recurString2Int(String s) {

        return 0;
    }

    public static void main(String[] args) {
    }
}
