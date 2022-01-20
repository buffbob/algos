package algos.basic;

public class Recursion2 {

    /*
    basic factorial with natural head recursion
     */
    public static int fact1(int n){
        if (n == 1) return 1;
        return fact1(n-1) * n;
    }

    /*
    factorial with accumulator and tail recursion
     */
    public static int fact2(int n, int result){
        if (n==1)return result;
        return fact2(n-1, n*result);
    }

    public static void main(String[] args) {

        int num = 3;
        System.out.printf("%d! = %d%n", num, fact1(num));
        num = 10;
        System.out.printf("%d! = %d%n", num, fact1(num));
        num = 15;
        System.out.printf("%d! = %d%n", num, fact1(num));
// StackOverFlow Error
        System.out.println("-----------------------");
        num = 3;
        System.out.printf("%d! = %d%n", num, fact2(num, 1));
//        num = 388883;
//        System.out.printf("%d! = %d%n", num, fact2(num, 1));



    }
}
