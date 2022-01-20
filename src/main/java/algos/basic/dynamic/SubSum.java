package algos.basic.dynamic;

public class SubSum {
    /*
    table[i][j] =>
    1 - if j = 0 then true;
    2 - if i = 0 then false;
    3 - table[i-1][j] if table[i-1][j] is true
    4 - table[i-1] [j - A[i-1]]  else
     */

    private boolean [][] table; // dynamic programming table
    private int [] numbers;
    private int number;

    public SubSum(int [] S, int sum) {
        this.number = sum;
        this.numbers = S;
        this.table = new boolean[numbers.length + 1][number + 1];
        // initialize
        for (int i = 0; i < numbers.length + 1; i++) {
            table[i][0] = true;
        }
    }

    public void solve() {
        for(int rIdx = 1; rIdx < numbers.length + 1; rIdx++) {
            for (int cIdx = 0; cIdx < number + 1; cIdx++) {
                if(cIdx < numbers[rIdx -1]){
                    table[rIdx][cIdx] = table[rIdx -1][cIdx];
                } else {
                    if(table[rIdx -1][cIdx] == true){
                        table[rIdx][cIdx] = table[rIdx -1][cIdx];
                    } else {
                        table[rIdx][cIdx] = table[rIdx -1][cIdx - numbers[rIdx - 1]];
                    }
                }
            }
        }
        System.out.println("Solution: " + table[numbers.length][number]);
    }
    public void showSolution(){
        int cIdx = number;
        int rIdx = numbers.length;
        while(cIdx > 0 || rIdx > 0) {
            if (table[rIdx][cIdx] == table[rIdx - 1][cIdx]) {

            } else {
                System.out.println("We take: " + numbers[rIdx -1]);
                cIdx = cIdx - numbers[rIdx - 1];
            }
        }
    }


}
