package algos;

import algos.RecursiveStringAlgos;
import algos.StringAlgos;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecursiveStringAlgosTest {

    @Test
    void testInt2StringRecur() {
        int t1 = 123;
        int t2 = 19;
        int t3 = 922299;
        int t4 = -43;
        int t5 = 0;

        assertTrue(RecursiveStringAlgos.int2String(t1).equals("123"), "error at " + t1);
        assertTrue(RecursiveStringAlgos.int2String(t2).equals("19"), "error at " + t2);
        assertTrue(RecursiveStringAlgos.int2String(t3).equals("922299"), "error at " + t3);
        assertTrue(RecursiveStringAlgos.int2String(t4).equals("-43"), "error at " + t4);
        assertTrue(RecursiveStringAlgos.int2String(t5).equals("0"), "error at " + t5);

    }

    @Test
    void recurString2Int() {
        String t1 = "128";
        String t2 = "000128";
        String t3 = "99999";
        String t4 = "-337";
        String t5 = "13k";
        assertEquals(RecursiveStringAlgos.string2Int(t1), 128);
        assertTrue(RecursiveStringAlgos.string2Int(t2) == 128);
        assertTrue(RecursiveStringAlgos.string2Int(t3) == 99999);
        assertEquals(StringAlgos.string2Int(t4), -337);
        assertThrows(NumberFormatException.class, () -> StringAlgos.string2Int(t5));

    }

    @Test
    void convertBase() {
        // test1
        int t1 = 10, t2 = 2;
        String s1 = "15";
        String res = "1111";
        assertEquals(RecursiveStringAlgos.convertBase(s1,t1,t2), res);
        // test 2
        int b1 = 5, b2 = 10;
        String input = "1234";
        String output = "194";
        assertEquals(RecursiveStringAlgos.convertBase(input, b1, b2), output);

        // test3
        int a1 = 3, a2 = 2;
        String s_in = "111";
        String s_out = "1101";
        assertEquals(RecursiveStringAlgos.convertBase(s_in, a1, a2), s_out);
        // test4-- do negatives work?
        int c1 = 3, c2 = 2;
        String si = "-111";
        String so = "-1101";
        assertEquals(RecursiveStringAlgos.convertBase(si, c1, c2), so);
    }
}