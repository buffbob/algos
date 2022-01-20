package algos.basic.dynamic;

public class App {

    public static void main(String[] args) {
        int[] numbers = {5, 2, 3, 1};
        int sum = 9;
        SubsetSum ss = new SubsetSum(numbers, sum);
        ss.solveProblem();
        ss.hasSolution();
        ss.showSums();
    }
}
