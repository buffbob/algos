import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringAlgosTest {

    @Test
    void TestIsPalindromic1() {
        String s1 = "UFOTOFU";
        String s2 = "ufotof";
        String s3 = "ufotofu";
        assertTrue(StringAlgos.isPalindromic(s1) , "ERROR!!!");
        assertTrue(StringAlgos.isPalindromic(s3) , "ERROR!!!");
        assertTrue(!StringAlgos.isPalindromic(s2) , "ERROR!!!");
    }

    @Test
    void TestIPalendromic2() {
        String s1 = "Racecar";
        String s2 = "RacECAR";
        String s3 = "ABba";
        String s4 = "ABbaz";
        assertTrue(StringAlgos.isPalindromic(s1), "Error!");
        assertTrue(StringAlgos.isPalindromic(s2), "Error!");
        assertTrue(StringAlgos.isPalindromic(s3), "Error!");
        assertTrue(!StringAlgos.isPalindromic(s4), "Error!");
    }
    @Test
    void string2Int() {
        String msg = "ERROR!";
        String t1 = "128";
        String t2 = "000128";
        String t3 = "99999";
        String t4 = "-337";
        String t5 = "13k";
        assertEquals(StringAlgos.string2Int(t1), 128, msg);
        assertTrue(StringAlgos.string2Int(t2) == 128, msg);
        assertTrue(StringAlgos.string2Int(t3) == 99999, msg);
//                todo: implement negative recognition
//                test toString().startsWith("-")
        assertEquals(StringAlgos.string2Int(t4), -337, msg);
        assertThrows(NumberFormatException.class, () -> StringAlgos.string2Int(t5));
            }

    @Test
    void int2String() {
        int t1 = 123;
        int t2 = 19;
        int t3 = 922299;
        int t4 = -43;

        assertTrue(StringAlgos.Int2String(t1).equals("123"), "error at " + t1);
        assertTrue(StringAlgos.Int2String(t2).equals("19"), "error at " + t2);
        assertTrue(StringAlgos.Int2String(t3).equals("922299"), "error at " + t3);
        assertTrue(StringAlgos.Int2String(t4).equals("-43"), "error at " + t4);
    }

    @Test
    void testConvertFromBase1ToBase2() {
        int t1 = 10, t2 = 2;
        String s1 = "15";
//        assertEquals(StringAlgos.conver// 7tFromBase1ToBase2(s1, 10, 2), "1111");
        assertTrue(true);
    }

    @Test
    void convertToBase10() {
        String t1 = "111";
        int b1 = 2;
        String t2 = "123";
        int b2 = 5;
        String t3 = "321";
        int b3 = 7;
        String t4 = "1234";
        int b4 = 10;

        System.out.println(StringAlgos.convertToBase10(t1, b1)); // 7
        assertEquals(StringAlgos.convertToBase10(t1, b1), 7);
        assertEquals(StringAlgos.convertToBase10(t2, b2), 38);
        assertEquals(StringAlgos.convertToBase10(t3, b3), 162);
        assertEquals(StringAlgos.convertToBase10(t4, b4), Integer.parseInt(t4));
    }
}