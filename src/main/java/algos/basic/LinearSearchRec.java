package algos.basic;

public class LinearSearchRec {

    // returns the index of the hit in the array
    // returns -1 if no hit
    public int find(int [] ints, int item, int idx) {
        if (idx >= ints.length) return -1;
        if(item == ints[idx]) {
            System.out.println("success");
            return idx;
        }
        return find(ints, item, idx + 1);
    }

    public static void main(String[] args) {
        LinearSearchRec l = new LinearSearchRec();
        int [] is = {1,3,5, 35};
        System.out.println(l.find(is,35,0));

    }
}
