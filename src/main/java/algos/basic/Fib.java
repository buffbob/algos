package algos.basic;

public class Fib {

    public int head(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int res = head(n-1)  + head(n-2);
        return res;
    }

    public int tail(int n, int fib1, int fib2){
        if (n == 0) return fib1;
        if (n == 1) return fib2;
        return tail(n-1, fib2, fib2 + fib1);
    }

    public int iterative(int n) {
        int a = 0;
        int b = 1;
        while(a < n){
            int temp = b;
            b = a + b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        int num = 5;
        Fib f = new Fib();
//        int result = f.head(num);
        int result = f.tail(num, 0, 1);
        System.out.println("fib(" + num + ") = " + result);
        System.out.println("--------");
//        for (int i = 0; i < 15 ; i++) {
//            System.out.println(i + " : " + f.head(i));
//        }

        int r = f.iterative(num);
        System.out.println("IterativeFib of " + num + " = " + r);
    }
}
