package algos.arrays;

public class NumberObjects {

    private String name;

    public NumberObjects(String name) {
        this.name = name;
    }

    public NumberObjects() {
    }

    public static void one(String s) {
        byte b = 11;
        System.out.println(Byte.valueOf((byte)11));
        System.out.println(Byte.valueOf(b));
        System.out.println(Byte.valueOf((byte)128));
        System.out.println(Byte.valueOf((byte)130));
        System.out.println("-----------------------------------");
        System.out.println(Byte.valueOf("15", 10)); // 15
//        System.out.println(Byte.valueOf("15", 2));  // 1111  nope - error!!
        System.out.println(Byte.valueOf("11", 2));  // 3 as int
        System.out.println(Byte.valueOf("11", 10));  // 11 as int
        System.out.println("----------------------------");
        System.out.println(Byte.valueOf("125", 10));  // 11 as int
        System.out.println("----------------------");
        System.out.println(Byte.valueOf((byte)130));
        System.out.println("******");
        System.out.println(Byte.valueOf(s));
    }



    public static void main(String[] args) {
        try {
            one(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("bn -128 and 127 please");
        } finally {
            System.out.println("yews");
        }
    }
}
