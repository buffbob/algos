package algos.arrays;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class ArrayAlgos {
    /**
     * increment a infinitely large number by 1
     * @param a integer encoded by an arraylist 199 ==> {1,9,9}
     * @return param a incremented by 1 and encoded in the original arraylist
     */
    public static List<Integer> increment(List<Integer> a) {
        int size = a.size() - 1;
        a.set(size, a.get(size) + 1);
        for (int i = size; i > 0 && a.get(i) == 10; --i) {
            a.set(i, 0);
            a.set(i - 1, a.get(i - 1) + 1);
        }
        if (a.get(0) == 10) {
            // how to deal with carry which occurs at numbers like a = [999]
            //set first to 1 and add 0 at the end --> like 1000
            a.set(0, 1);
            a.add(0);
        }
        return a;
    }

    /**
     *
     * @param num arbitrarily long int encoded by an array
     * @return new encoding array for an int with leading zeros removed
     */
    private static List<Integer> removeLeadingZeros(List<Integer> num) {
        int idx = 0;
        while(num.get(idx).equals(Integer.valueOf(0))) {
            idx++;
        }
        int newSize = num.size() - idx; // the number of digits or size of the array
        List<Integer> newNum = new ArrayList<>(newSize);
        for ( ; (idx < num.size()); idx++) {
            newNum.add(num.get(idx));
        }
        return newNum;
    }

    /**
     *
     * @param number the number to be multiplied as an encoded array
     * @param singleDigit the number to be multiplied as an encoded array of size 1
     * @return the number array modified to the product
     */
    private static List<Integer> multiplyBySingleDigit(List<Integer> number, List<Integer> singleDigit){
        assert (singleDigit.size() == 1);
        int idx = number.size() - 1;
        int carry = 0; // the carry for each column
        int temp = 0;
        for ( ; idx >= 0 ; idx--) {
            System.out.println("idx = " + idx);
            temp = singleDigit.get(0) * number.get(idx) + carry;
            number.set(idx, temp%10);
            carry = temp/10;
        }
        if (temp > 9) {
            number.add(0, carry);
        }
        return number;
    }


    /**
     * sum two arbitrarily large integers that are encoded as arrays.
     * This is an in-place array substitution using the larger of the two arrays.
     * @param one - an integer as an encoded array
     * @param two - an integer as an encoded array
     * @return the sum of the two encoded integers as an encoding array.
     */
    public static List<Integer> sumAny2Ints(List<Integer> one, List<Integer> two) {
        // add 0s to smaller size array
        boolean oneBiggerOrEqual = (one.size() >= two.size()) ? true : false;
        int smallerSize = oneBiggerOrEqual ? two.size(): one.size();
        int biggerSize = oneBiggerOrEqual ? one.size(): two.size();
        int newSize = oneBiggerOrEqual ? one.size() + 1: two.size() + 1;
        int temp = biggerSize - smallerSize;
        while (temp-- > 0){
            if (oneBiggerOrEqual) {
                two.add(0, 0);
            } else {
                one.add(0, 0);
            }
        }
        // find the larger array
        List<Integer> theList = oneBiggerOrEqual ? one: two;
        // add the two ints as arrays
        int idx = biggerSize - 1 ; // last idx of the now same size arrays
        int carry = 0;
        int temp2 = 0;
        for (; idx >= 0; idx--) {
            temp2 = one.get(idx) + two.get(idx) + carry;
            carry = temp2 > 9 ? 1:0;
            theList.set(idx,temp2%10);
        }
        // add 1 at idx 0 if a carry on the last digit
        if (carry == 1) theList.add(0, 1);
        return theList;
    }

    // test for new inplace implementation
    private static void testAddAny2Ints() {
        boolean passed = false;
        try {
            List<Integer> a = new ArrayList<>(Arrays.asList(2,4,3));
            List<Integer> b = new ArrayList<>(Arrays.asList(8,9,9,9));
            List<Integer> res = sumAny2Ints(a, b); // [9,2,4,2]
            assert (res.equals(Arrays.asList(9,2,4,2)));
            List<Integer> res2 = sumAny2Ints(a, new ArrayList<>(Arrays.asList(0,0))); // [2,4,3]
            System.out.println(res2);
            assert (removeLeadingZeros(res2).equals(Arrays.asList(2,4,3)));
            System.out.println(removeLeadingZeros(res2));
            passed = true;
        } finally {
            String res = passed ? "PASSED!": "FAILED!";
            System.out.println("TEST testAdd2 --    " + res);
        }

    }
    /**
     * remove duplicates from a sorted arraylist.
     * @param ints- a List of ints.
     * @return the list with duplicates and freed array space removed in place..
     */
    public static List<Integer> removeDuplicates(List<Integer> ints) {
        int writeIdx = 1;
        // is the index through the ints array
        for (int i = 1; i < ints.size(); i++) {
            // compare
            if (!ints.get(writeIdx - 1).equals(ints.get(i))) {
                ints.set(writeIdx++, ints.get(i));
            }
        }
        // write Index is last place needed so return sublist
        return ints.subList(0, writeIdx);
    }

    private static void testRemoveDups() {
        List<Integer> t = new ArrayList<>(Arrays.asList(0, 3, 5, 5, 7));
        System.out.println(t);
        System.out.println(removeDuplicates(t));
    }

    /**
     * find primes from 0 to parameter n.
     * @param n up to and including n.
     * @return a Boolean array with each index containing whether the idx is a prime or not
     * example: for n = 5, return [false, false, true, false, true]
     * idx of 0 and 1 are false by definition and by default
     */
    public static List<Boolean> primesToN(int n){
        // init
        List<Boolean> result = new ArrayList<>(Collections.nCopies(n + 1, true));
        result.set(0, false);
        result.set(1, false);
        for (int i = 2; i <= n ; i++) {
            if(result.get(i)) {
                // make all multiples false
                int nextInt = 2;
                while((i*nextInt) < n) {
                    result.set(i * nextInt++, false);
                }
            }
        }
        return result;
    }

    private static void testPrimesToN() {
        int n = 5;
        boolean passed = false;
        try {
            assert (primesToN(n).equals(new ArrayList<>(Arrays.asList(false, false, true, true, false, true))));
            System.out.println(primesToN(n)); // [2,3,5]
            passed = true;
        } finally {
            String result = passed ? "PASSED" : "FAILED";
            System.out.println("TESTING primesToN-----\t" + result);
        }
    }
    public static void main(String[] args) {
        testRemoveDups();
        testAddAny2Ints();
        testPrimesToN();
        List<Integer> a = new ArrayList<>(Arrays.asList(2,4,3));
        List<Integer> b = new ArrayList<>(Arrays.asList(8,9,9,9));
        List<Integer> c = new ArrayList<>(Arrays.asList(9,9,9));
        List<Integer> d = Arrays.asList(2);
        List<Integer> e = Arrays.asList(9);
//        List<Integer> r1 = sumAnyInts(a, b);
//        List<Integer> r2 = removeLeadingZeros(c);
//        System.out.println(r1); // [1,2,4,2]
//        System.out.println(r2); // [9,9,9]
//        System.out.println("-------------------");
////        List<Integer> r3 = multiplyOneRow(a, d);
//        List<Integer> r4 = multiplyBySingleDigit(b, e);
////        List<Integer> r5 = multiplyOneRow(b, d);
////        System.out.println(r3); // [4,8,6]
//        System.out.println(r4); // [80991]
////        System.out.println(r5); // [1998]
////        System.out.println("*********");
////        test1();
//        List<String> strings = new ArrayList<String>(Collections.nCopies(5, "shit"));
//        System.out.println(strings);
//        // create new array first
//        String [] newArray = new String[strings.size()];
//        test2(strings.toArray(newArray));

    }
    // adding to an arraylist
    public static void test1(){
        List<Integer> ints = Arrays.asList(2,3);
        List<Integer> ints2 = new ArrayList<>(Arrays.asList(2,3));
        System.out.println(ints2);
//        ints.add(0,3);
        ints2.add(0,3);
        System.out.println(ints2);
        Vector<Integer> v = new Vector<>();
        v.addAll(Arrays.asList(1,3, 3));
        System.out.println(v);
        System.out.println(v.get(1));
    }

    // test array signature requirements
//    public static void test2(String [] arr) { // ok too!
    public static void test2(String arr []) {
        for (String s: arr
             ) {
            System.out.println(s);
        }
    }
}
