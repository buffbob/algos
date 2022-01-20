package algos.arrays;

public class BitPlay {

    public static void one(){
        int i = 1;
        int ii = 0;
        int iii = 15;
        System.out.println(Integer.toBinaryString(iii));
        System.out.println("i & iii = " + (iii & i)); // 1
        System.out.println("i | iii = " + (iii | i)); // 15
        System.out.println("i ^ iii = " + (iii ^ i)); // 14 // exclusive or
        System.out.println("i not " + (~i)); // give 2s complement of \b1110
        System.out.println(iii&=i); // 1
    }
    /*
    Shift operators are used to shift the bits of a number left or right,
    thereby multiplying or dividing the number by two, respectively.
    They can be used when we have to multiply or divide a number by two.
     */
    public static void two() {
        int a = 4;
        System.out.println(Integer.toBinaryString(a)); // 100(4)
        System.out.println(Integer.toBinaryString(a>>1)); // 10(2)
        System.out.println(Integer.toBinaryString(a>>2)); // 1(1)
        System.out.println(Integer.toBinaryString(a>>>2)); // 1(1)
        System.out.println(Integer.toBinaryString(a<<2)); // 10000(16)
        System.out.println(Integer.toBinaryString(a<<2)); // 10000(16)
    }

    public static int doubleInt(int i) {
        return i<<1;
    }
    public static int quadrupleInt(int i) {
        return i<<2;
    }

    public static int halveInt(int i) {
        return i>>1;
    }

    public static void main(String[] args) {
//        one();
//        System.out.println("________________");
//        two();
//        System.out.println("________________");
//        System.out.println(doubleInt(3));
//        System.out.println(quadrupleInt(3));
//        System.out.println(halveInt(-100));
//
//        System.out.println(8 >>> 2);
//        System.out.println(-8 >>> 2);

        three();
    }

    private static void three() {
        System.out.println(Integer.toBinaryString(22));
        System.out.println(Integer.toBinaryString(8));
        System.out.println(Integer.toBinaryString(4));
        double d = Double.valueOf(2);
        int ii = 4;
        Integer i = Integer.getInteger("very cool", ii);
        System.out.println(i + 2);
        byte b = (byte) 133;
        System.out.println("------------");
        System.out.println(Byte.toString(b));
        System.out.println(Integer.lowestOneBit(16));
        System.out.println(Integer.numberOfTrailingZeros(4));
        System.out.println(Integer.numberOfLeadingZeros(4));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE + 1);
        System.out.println(Integer.MAX_VALUE + 2);
        System.out.println(Integer.MAX_VALUE + 10);
        System.out.println(33f);
        System.out.println((byte)(Byte.MAX_VALUE + 1) == -128 ? "goood": "bad");
        System.out.println((byte)(Byte.MAX_VALUE + 1));
        byte z = (byte)(128);
        System.out.println(z == -128 ? "cool": "not cool");

        Integer I = 129;
        System.out.println(I.byteValue());
    }
}
