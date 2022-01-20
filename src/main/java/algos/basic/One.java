package algos.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class One {

    public String [] make_array(String sent) {

        String[] returned_Strings = sent.split(" ");
        return returned_Strings;

    }
    /*
    make a recursion program to print the contents of an array of strings
     */
    public static void recur1(String [] words){
        if (words.length == 0) return;

        // get word and make words one shorter
        String [] ws = Arrays.copyOfRange(words, 1, words.length);
        recur1(ws);
        System.out.println(words[0]);
    }

    /*
    recursion of a list
     */
    public static void recur2(List<Integer> ints) {
        if (ints.size() == 0) return;

        List a_shorter_list = ints.subList(1, ints.size());
        recur2(a_shorter_list);
        System.out.printf("int- %d%n", ints.get(0));
    }

    /*
    try factorial
     */
    public static int factorial(int number){
        if (number == 1) return 1;
        return factorial(number-1) * number;
    }

    /*
    try to add all numbers in an array
     */
    public static int addList(int [] ints){
        if (ints.length == 0) return 0;
        else return ints[0] + addList(Arrays.copyOfRange(ints, 1, ints.length));
    }
    /*
    try using idx to avoid call to arrays library
    idx must be initialized to 0
     */
    public static void rec_list_idx(int [] ints, int idx){
        if (idx == ints.length) return;
        System.out.println(ints[idx]);
        rec_list_idx(ints, idx + 1);
    }
    /*
    idx to add list,
    initial values -- result = 0 and idx = 0
     */
    public static int add_list_idx(int [] ints, int idx, int res){
        if (idx == ints.length) return res;
        return add_list_idx(ints, idx + 1, res + ints[idx]);
    }

    /*
    recursive sum
     */
  public static int rec_sum(int i) throws Rec_Sum_Ex{
      if(i < 0) throw new Rec_Sum_Ex();
      if(i == 0) return 0;
      if(i == 1) return 1;
      return i + rec_sum(i-1);
  }
/*
review generic
 */
    public static <T> Double gen1(Number n){
        return n.doubleValue() + 100.0;    }

    public static void main(String [] args) {
        int [] is = {1,3,5, 100, 1000};


        rec_list_idx(is, 0);
        System.out.println("total " + add_list_idx(is,0, 0));
//        a int that is left justified with common in 10 spaces
//        System.out.printf("total = $%-,10d dollars%n", addList(is));
//        System.out.println();
//        try {
//            System.out.printf("recursive sum is %d%n", rec_sum(10));
//            System.out.printf("recursive sum is %d%n", rec_sum(0));
//            System.out.printf("recursive sum is %d%n", rec_sum(-1));
//        } catch(One.Rec_Sum_Ex e){
//            System.out.println(e.getMessage());;
//        }
//        System.out.printf("answer = %d%n", factorial(1));
//        System.out.printf("answer = %d%n", factorial(2));
//        System.out.printf("answer = %d%n", factorial(3));
//        System.out.printf("answer = %d%n", factorial(4));
//        System.out.printf("answer = %d%n", factorial(5));
//
//
//
//        System.out.printf("answer= %.2f%n", gen1(5));
//        System.out.printf("answer= %f%n", gen1(5));
//        System.out.printf("answer= %f%n", gen1(5.0));

        One one = new One();
        String [] strings;
        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(5);
        ints.add(2);
        ints.add(200);


        String s = "I like toad and frog";
        strings = one.make_array(s);

        // recur1(strings);
        // recur2(ints);


//        for (String word:  strings) {
//            System.out.println(word);
//        }
    }
}
