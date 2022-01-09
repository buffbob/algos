import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecursiveStringAlgosTest {

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
    void testInt2String() {
        int t1 = 123;
        int t2 = 19;
        int t3 = 922299;
        int t4 = -43;
        int t5 = 0;

        assertTrue(RecursiveStringAlgos.int2String(t1).equals("123"), "error at " + t1);
        assertTrue(RecursiveStringAlgos.int2String(t2).equals("19"), "error at " + t2);
        assertTrue(RecursiveStringAlgos.int2String(t3).equals("922299"), "error at " + t3);
        System.out.println(RecursiveStringAlgos.int2String(t4));
        assertTrue(RecursiveStringAlgos.int2String(t4).equals("-43"), "error at " + t4);
        assertTrue(RecursiveStringAlgos.int2String(t5).equals("0"), "error at " + t5);

    }
}