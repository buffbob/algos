package algos.strings;

import org.w3c.dom.ls.LSOutput;

import java.util.Locale;

public class StringAlgos {
//TODO :: NEED TO KNOW IF PALINDROME CAN BE OF EVEN SIZE!!!!!!!!!!!!11
    public static boolean isPalindromic(String s) {
        s = s.toLowerCase();
        if(s.length() == 1) {
            System.out.println("all one letter words are palindromes, Dork!");
        }
        if (s.length()%2 == 1) { // ie- it is odd
            int middleIdx = s.length() / 2;
            int lastIdx = s.length() - 1;
            for (int i = 0; i < middleIdx; i++) {
                // compare the ends of the strings
                if (s.charAt(i) != s.charAt(lastIdx - i)) {
                    return false;
                }
            }
        } else return false;
        return true;
    }

    public static boolean isPalindromic2(String s) {
        s = s.toLowerCase();
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }

    private static void testIsPalindromic() {
        String s1 = "s";
        System.out.println("s is dumb " + isPalindromic(s1));
        String s2 = "ufotof";
        String s3 = "ufotofu";
        System.out.println(isPalindromic(s2));
        System.out.println(isPalindromic(s3));
        System.out.println("----------------------------");
        String s4 = "Racecar";
        System.out.println(isPalindromic(s4));
    }
    private static void testIsPalindromic2() {
        String s1 = "s";
        System.out.println("s is dumb " + isPalindromic2(s1));
        String s2 = "ufotof";
        String s3 = "ufotofu";
        System.out.println(isPalindromic2(s2));
        System.out.println(isPalindromic2(s3));
        System.out.println("----------------------------");
        String s4 = "Racecar";
        System.out.println(isPalindromic2(s4));
        String s5 = "ette";
        System.out.println(isPalindromic2(s5));
    }

    public static void play1() {
        String a = "123";
        char c = a.charAt(0);
        char c49 = 49;
        char c50 = 50;
        System.out.println(c);
        System.out.println((char)48);
        System.out.println(c49);
        System.out.println(c50);
        System.out.println("*********************");
        System.out.println((char)56);
        System.out.println((char)57);
        System.out.println((char)58);
    }

    public static void play2 ( ) {
        int i = '9' - 48; // 9
        int i10 = ':' - 48; // 10
        System.out.println(i);
        System.out.println(i10);
        String ex = "123";
        System.out.println("---------------");
        double result = 0.0;
        for (int j = ex.length() - 1, idx10 = 0; j >= 0; j--, idx10++) {
            char c = ex.charAt(j);
            double temp = (int)c - 48;
            temp = temp * Math.pow(10.0, (double)idx10);
            result += temp;
        }

        System.out.println("the number is - " + (int)result);
    }
    public static int string2Int(String s) {
        int result = 0;
        for (double power = 0, idx = s.length() - 1; idx >= 0 ; power++, idx--) {
            int charIntValue = s.charAt((int)idx) - 48;
            if ((charIntValue < 0 ) | (charIntValue > 9)) throw new NumberFormatException("please only input digits!!!");
            result += charIntValue * (int)Math.pow(10.0, power);
        }
        return result;
    }

    private static void testString2Int() {
        String test1 = "128";
        System.out.println(string2Int(test1));

        String test2 = "00128";
        System.out.println(string2Int(test2));

        String test3 = "999";
        System.out.println(string2Int(test3));

//        String test4 = "148k"; // uh oh!!! /// 1539 !!!
//        System.out.println(string2Int(test4));
    }

    public static String Int2String(int number) {
        StringBuilder result = new StringBuilder();
        // init
        int remainder = -1;
        char temp;
        while(number > 0) {
            number = number / 10;
            remainder = number % 10;
            temp = (char) (remainder + 49);
            result.append(temp);
        }
        return result.reverse().toString();
    }

    private static void testInt2String() {
        int i1 = 123;
        System.out.println(Int2String(i1));
        int i2 = 0012;
        System.out.println(Int2String(i2));
    }


    public static void main(String[] args) {
//        testIsPalindromic2();
//        play2();
//        testString2Int();
//        System.out.println((int) 'a');
//        System.out.println((int) 'A');


        testInt2String();
    }
}
