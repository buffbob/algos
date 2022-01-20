package algos;

import algos.strings.MoreStringAlgos;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringAlgosTest {

    @Test
    void testIsPalindrome1() {
        String s1 = "UFOTOFU";
        String s2 = "ufotof";
        String s3 = "ufotofu";
        assertTrue(MoreStringAlgos.isPalindromic(s1) , "ERROR!!!");
        assertTrue(MoreStringAlgos.isPalindromic(s3) , "ERROR!!!");
        assertTrue(!MoreStringAlgos.isPalindromic(s2) , "ERROR!!!");
    }

    @Test
    void testIsPalindrome2() {
        String s1 = "Racecar";
        String s2 = "RacECAR";
        String s3 = "ABba";
        String s4 = "ABbaz";
        assertTrue(MoreStringAlgos.isPalindromic(s1), "Error!");
        assertTrue(MoreStringAlgos.isPalindromic(s2), "Error!");
        assertTrue(MoreStringAlgos.isPalindromic(s3), "Error!");
        assertTrue(!MoreStringAlgos.isPalindromic(s4), "Error!");
    }
    @Test
    void testString2Int() {
        String msg = "ERROR!";
        String t1 = "128";
        String t2 = "000128";
        String t3 = "99999";
        String t4 = "-337";
        String t5 = "13k";
        assertEquals(MoreStringAlgos.string2Int(t1), 128, msg);
        assertTrue(MoreStringAlgos.string2Int(t2) == 128, msg);
        assertTrue(MoreStringAlgos.string2Int(t3) == 99999, msg);
        assertEquals(MoreStringAlgos.string2Int(t4), -337, msg);
        assertThrows(NumberFormatException.class, () -> MoreStringAlgos.string2Int(t5));
            }

    @Test
    void testInt2String() {
        int t1 = 123;
        int t2 = 19;
        int t3 = 922299;
        int t4 = -43;
        int t5 = 0;

        assertTrue(MoreStringAlgos.Int2String(t1).equals("123"), "error at " + t1);
        assertTrue(MoreStringAlgos.Int2String(t2).equals("19"), "error at " + t2);
        assertTrue(MoreStringAlgos.Int2String(t3).equals("922299"), "error at " + t3);
        assertTrue(MoreStringAlgos.Int2String(t4).equals("-43"), "error at " + t4);

    }

    @Test
    void testConvertToBase10() {
        String t1 = "111";
        int b1 = 2;
        String t2 = "123";
        int b2 = 5;
        String t3 = "321";
        int b3 = 7;
        String t4 = "1234";
        int b4 = 10;
        assertEquals(MoreStringAlgos.convertToBase10(t1, b1), 7);
        assertEquals(MoreStringAlgos.convertToBase10(t2, b2), 38);
        assertEquals(MoreStringAlgos.convertToBase10(t3, b3), 162);
        assertEquals(MoreStringAlgos.convertToBase10(t4, b4), Integer.parseInt(t4));
    }

    @Test
    void testConvertFromBase10() {
        int num1 = 101;
        int base1 = 5;
        int num2 = 9;
        int base2 = 2;
        int num3 = 99;
        int base3 = 8;
        assertEquals(MoreStringAlgos.convertFromBase10(num1, base1), "401");
        assertEquals(MoreStringAlgos.convertFromBase10(num2, base2), "1001");
        assertEquals(MoreStringAlgos.convertFromBase10(num3, base3), "143");
    }
    @Test
    void testConvertFromBase1ToBase2() {
        // test1
        int t1 = 10, t2 = 2;
        String s1 = "15";
        String res = "1111";
        assertEquals(MoreStringAlgos.convertFromBase1ToBase2(s1,t1,t2), res);
        // test 2
        int b1 = 5, b2 = 10;
        String input = "1234";
        String output = "194";
        assertEquals(MoreStringAlgos.convertFromBase1ToBase2(input, b1, b2), output);
        // test3
        int a1 = 3, a2 = 2;
        String s_in = "111";
        String s_out = "1101";
        assertEquals(MoreStringAlgos.convertFromBase1ToBase2(s_in, a1, a2), s_out);
        // test4-- do negatives work?
        int c1 = 3, c2 = 2;
        String si = "-111";
        String so = "-1101";
        assertEquals(MoreStringAlgos.convertFromBase1ToBase2(si, c1, c2), so);
    }

    @Test
    void testReverseStringOfWords() {
        char [] s = "fred is a doll of a dude".toCharArray();
        char [] test = "dude a of doll a is fred".toCharArray();
        char [] s1 = "atta boy".toCharArray();
        char [] test1 = "boy atta".toCharArray();
        MoreStringAlgos.reverseStringOfWords(s);
        MoreStringAlgos.reverseStringOfWords(s1);
        assertArrayEquals(s, test);
        assertArrayEquals(s1, test1);
    }
    @Test
    void testReverse() {
        char [] s1 = "tom".toCharArray();
        char [] t1 = "mot".toCharArray();
        char [] s2 = "tom the turd".toCharArray();
        char [] t2 = "drut eht mot".toCharArray();
        MoreStringAlgos.reverse(s1,0, 2);
        MoreStringAlgos.reverse(s2,0, t2.length - 1);
        assertArrayEquals(s1, t1);
        assertArrayEquals(s2, t2);
        System.out.println("-----"); // testing partial word reverse
        char [] s3 = "0123456789".toCharArray();
        System.out.println(s3);
        MoreStringAlgos.reverse(s3, 0, 5);
        System.out.println(s3);
        assertArrayEquals(s3, "5432106789".toCharArray());
    }

    @Test
    void testPhoneMnemonics() {
        String t = "79";
        String t0 = "78";
        String t1 = "533";
        String t2 = "5337";
        // test correct size
        List<String> res = MoreStringAlgos.phoneMnemonics(t2);
        assertEquals(27, MoreStringAlgos.phoneMnemonics(t1).size());
        assertEquals(12, MoreStringAlgos.phoneMnemonics(t0).size());
        assertEquals(16, MoreStringAlgos.phoneMnemonics(t).size());
        assertTrue(res.contains("JEEP"));
        assertFalse(res.contains("JEEZ"));

//        for (String s: res) {
//            System.out.println(s);
//        }
    }

    @Test
    void testIsWellFormed() {
        String s1 = "{{()[]}}"; // true
        assertTrue(MoreStringAlgos.isWellFormed(s1));
        String s2 = "{{()[{]}}"; // false
        assertFalse(MoreStringAlgos.isWellFormed(s2));

    }
}