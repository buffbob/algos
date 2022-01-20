package algos.basic;

public class Factorial {

    public static int head(int n) {
        if (n == 1) return 1;
        int temp = head(n-1);
        int result = n * temp;
        return result;
    }


    public static int tail(int n, int result){
        if (n == 0) return result;
        return tail(n-1, n*result);

    }

    public static void main(String[] args) {
        int num = 15;
        System.out.println(num + "! = " + head(num));
    }
}
