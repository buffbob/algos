package play;

public class One {

    public static void one() {
        boolean b = true || true && false;
        boolean bb = (true || true) && false;
        // if || has precedence then return false
        // if && has precedence then return true // this is correct!
        System.out.println(b);
        System.out.println(bb);
    }

    public static void main(String[] args) {
        one();
    }
}
