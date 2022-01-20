package algos.basic;

public class Rec3 {

    public void head(int n) {
        if (n<0) return;
        // call method recursively
        head(n-1);
        // operations
        System.out.println(n);
    }

    public void tail(int n) {
        System.out.println("calling with n = " + n);
        if(n < 0) return;
        System.out.println(n);
        tail(n-1);
    }

    public static void main(String[] args) {
        Rec3 r = new Rec3();
        r.head(3);
        System.out.println("---------");
        r.tail(3);
    }
}
