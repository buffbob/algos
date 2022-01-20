package algos.strings;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoreStringAlgos {

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
        for (int idx = 0; idx < s.length() ; idx++) {
            int charIntValue = s.charAt(idx) - '0';
            if ((charIntValue < 0 ) | (charIntValue > 9)) throw new NumberFormatException("please only input digits!!!");
            result = (result * 10) + charIntValue;
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
        boolean isNeg = original.startsWith("-");
        String temp = isNeg ? original.substring(1) : original;
        String result = convertFromBase10(convertToBase10(temp, base1), base2);
        return isNeg ? "-" + result : result;
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

    /**
     * Convert an integer into the base- baseEnd.
     * It is assumed that the num is in base 10.
     * @param num -the number to convert
     * @param baseEnd -the base that the number is converted into
     * @return -the converted number.
     */
    public static String convertFromBase10(int num, int baseEnd) {
        boolean isNeg = num < 0;
        num = isNeg ? -num : num; //
        StringBuilder res = new StringBuilder();
        // init
        int remainder;
        char temp;
        while(num > 0) {
            remainder = num%baseEnd;
            num /= baseEnd;
            temp = (char)(remainder + 48);
            res.append(temp);
        }
        if(isNeg) res.append("-");
        return res.reverse().toString();
    }

    /**
     * Reverses the order of the words in text while maintaining the correct order for each
     * word. Modifies the char [] in place and returns void.
     * @param text text represented as a String.toCharArray()
     */
    public static void reverseStringOfWords(char [] text) {
        int n = text.length;
        reverse(text, 0, n-1);
        int start = 0, end = 0;
        // finding the individual words
        while (start < n) {
            while(start < end || start < n && text[start] == ' ' ){
                ++start;
            }
            while(end < start || end < n && text[end] != ' '){
                ++end;
            }
            reverse(text, start, end-1);
        }
    }

    /**
     * Reverses text, as represented by a char [], from pt1 to pt2. Performs the action
     * in place and returns void.
     * @param text The char [] representation of text.
     * @param startIdx The starting point. Inclusive.
     * @param endIdx The ending point. Inclusive.
     */
    public static void reverse(char [] text, int startIdx, int endIdx) {
        while(startIdx < endIdx){
            char temp = text[startIdx];
            text[startIdx++] = text[endIdx];
            text[endIdx--] = temp;
        }
    }

    /**
     * Finds all the mnemonic variations of a telephone number.
     * @param phoneNum Encoded as a String
     * @return A List<String> containing all the possible mnemonics
     */
    public static List<String> phoneMnemonics(String phoneNum){
        char [] partialMnemonic = new char[phoneNum.length()];
        List<String> mnemonics = new ArrayList<>();
        phoneMnemonicsHelper(phoneNum, 0, mnemonics, partialMnemonic);
        return mnemonics;
    }
   // helper for recursion
    private static void phoneMnemonicsHelper(String phoneNum, int numIdx, List<String> mnemonics, char[] partialMnemonic) {
        if(numIdx == phoneNum.length()) mnemonics.add(new String(partialMnemonic));
        else {
            // try all possible chars for this numIdx
            for (int i = 0; i < MAPPING[phoneNum.charAt(numIdx) - '0'].length(); i++) {
                char c = MAPPING[phoneNum.charAt(numIdx) - '0'].charAt(i);
                partialMnemonic[numIdx] = c;
                phoneMnemonicsHelper(phoneNum, numIdx + 1, mnemonics, partialMnemonic);
            }
        }
    }
    private static final String [] MAPPING = {
            "0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ" };

    /**
     * Determines whether a String has matching brackets, parenthesis, etc...
     * Uses a deque(stack) to store the left chars and deletes them when a matching right one
     * is encountered.
     * "([{}[]])" is well-formed
     * "({}]" is not well-formed
     * @param s The String to test.
     * @return true if is well-formed, false otherwise.
     */
    public static boolean isWellFormed(String s ) {
        Deque<Character> leftChars = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '['){
                leftChars.addFirst(c);
            }else{
                if(leftChars.isEmpty()) return false;
                if((c == ')' && leftChars.peekFirst() != '(')
                    || (c == ']' && leftChars.peekFirst() != '[')
                    || (c == '}' && leftChars.peekFirst() != '{')) {
                    return false;
                }
             leftChars.removeFirst();
            }
        }
        return leftChars.isEmpty();
    }

    public static void main(String[] args) {
//        System.out.println(convertFromBase10(9, 2));
        char [] words = "help".toCharArray();
        reverse(words,0, 3);
        System.out.println(words);
    }

}


