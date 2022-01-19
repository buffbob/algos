package algos.list;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListNode<T> {
    /**
     * Represents a node in a linked list. ListNode can be part of a list
     * however the List before this node cannot be accessed as only the field
     * next is declared.
     */

    T value;
    ListNode<T> next;

    /**
     * Constructing a new ListNode adds it as the head of another ListNode
     * @param value
     * @param last
     */
    public ListNode(T value, ListNode<T> last) {
        this.value = value;
        this.next = last;
    }

    /**
     * Add a new Node at the end of the list associated with a ListNode.
     * @param node The ListNode to add a new node to.
     * @param value The value of the new Node added
     * @return The ListNode appended with the new ListNode.
     */
    public static ListNode<Integer> addAtEnd(ListNode<Integer> node, Integer value) {
        ListNode<Integer> dummy = new ListNode<>(0, node);
        ListNode<Integer> iter = dummy;
        while(iter.next != null) {
            iter = iter.next;
        }
        iter.next = new ListNode<>(value, null);
        return dummy.next;
    }

    /**
     * Search a list for a key.
     * @param startNode A ListNode where the search starts.
     * @param key The value being searched for.
     * @param <T> The type of the value.
     * @return The node where key was found. Or null.
     */
    public static <T> ListNode<T> searchList(ListNode<T> startNode, T key) {
        while(startNode != null && startNode.value != key) {
            startNode = startNode.next;
        }
        return startNode;
    }


    /**
     * Add a node to a list.
     * @param addAfter The node whose next is being changed.
     * @param nodeToAdd The node being appended.
     * @param <T> The type of value in the ListNode.
     */
    public static <T> void addAfter(ListNode<T> addAfter, ListNode<T> nodeToAdd) {
        nodeToAdd.next = addAfter.next;
        addAfter.next = nodeToAdd;
    }

    /**
     * Find the length of the list associated with a ListNode
     * @param node The node whose length is in question.
     * @return The length of the list starting at @param node
     */
    public static int length(ListNode node) {
        int i = 0;
        while ( node != null){
            i++;
            node = node.next;
        }
        return i;
    }

    /**
     * Delete the node after this node.
     * @param deleteAfter The node whose next is deleted.
     * @param <T>
     */
    public static <T> void deleteAfter(ListNode<T> deleteAfter) {
        deleteAfter.next = deleteAfter.next.next;
    }

    /**
     * Merge two Lists that are sorted in descending order
     * @param one A node that represents a potential list
     * @param two A node that represents a potential list
     * @return The head node of a List merged from one and two. Descending order
     * is maintained.
     */
    public static ListNode<Integer> merge(ListNode<Integer> one, ListNode<Integer> two) {
        ListNode<Integer> dummy = new ListNode<>(0, null);
        ListNode<Integer> current = dummy;
        while(one != null && two != null) {
            if(one.value >= two.value){
                current.next = one;
                one = one.next;
            } else {
                current.next = two;
                two = two.next;
            }
            current = current.next;
        }
        current.next = one != null ? one : two;
        return dummy.next;
    }

    /**
     *
     * @param node A ListNode
     * @return A Node that has same nodes but 'pointers' have been reversed
     */
    public static ListNode<Integer> reverse(ListNode<Integer> node) {
        // the diagram at @https://medium.com/outco/reversing-a-linked-list-easy-as-1-2-3-560fbffe2088
        // helped sooo much!!
        ListNode prev = null;
        ListNode current = node;
        ListNode next = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev; // the new head
    }

    /**
     * Swap Nodes in a list.
     * @param n the head of the list
     * @param idx1 One of the nodes to swap.
     * @param idx2 Tho other node to swap.
     * @return The head ListNode for a list with 'nodes swapped'
     */
    public static ListNode<Integer> swap(ListNode n, int idx1, int idx2) {

        ListNode head = n;
        if(idx1 == idx2) return n;
        ListNode prev1 = null, current1 = head;
        int i = 1;
        while(current1 != null && i++ != idx1) {
            prev1 = current1;
            current1 = current1.next;
        }
        if(current1 == null) {
            System.out.println("?? Your index was to high. Try ->  " + --i );
        }
        ListNode prev2 = null, current2 = head;
        int ii = 1;
        while(current2 != null && ii++ != idx2) {
            prev2 = current2;
            current2 = current2.next;
        }
        if(current2 == null) {
            System.out.println("?? Your index was to high. Try ->  " + --ii );
        }
        // if x is not the head
        if(prev1 != null) {
            prev1.next = current2;
        }else{
            head = current2;
        }
        // if y is not the head
        // not neccessary if order checked earlier in // tod0 // but it hasnt
        if(prev2 != null) {
            prev2.next = current1;
        }else{
            head = current1;
        }
        // swap next pointers
        // see for good diagram******* https://medium.com/outco/reversing-a-linked-list-easy-as-1-2-3-560fbffe2088
        ListNode temp = current1.next;
        current1.next = current2.next;
        current2.next = temp;
        return head;
    }

    /**
     * Brute force to find if a list is cyclic. Check if object is in hash table.
     * If it is not then put it in the hashtable.
     * If it is then it is cyclic
     * iterate through the array performing said checks.
     * @param n
     * @return a ListNode that represents the node that starts the cycle
     */
    public static ListNode isListCyclic(ListNode n) {
        Hashtable<Integer, ListNode> ht = new Hashtable();
        int idx = 1;
        ListNode temp = n;
        ht.put(idx, temp);
        while(n != null) {
            temp = temp.next;
            if (ht.contains(temp)){
                System.out.println("idx of start of cycle: " + idx);
                break;
            }
            ht.put(++idx, temp);
        }
        return temp;
    }

    /**
     * Prints each nodes value on a new line.
     * @param node The head of a list.
     * @return the number of nodes in the list.
     */
    public static int iterateThrough(ListNode<Integer> node) {
        ListNode<Integer> t = node;
        int i = 0;
        while (t != null) {
            i++;
            System.out.println(i + "/" + t.value);
            t = t.next;
        }
        return i;
    }


    public static int sizeList(LinkedList l, int size) {
        int temp = size;
        if (l == null) return 0;
        else if (l.peek()!= null){
            l.pop();
            return sizeList(l, temp + 1);
        }
        else return temp;
    }

    public static ListNode<Integer> addIntegers(ListNode<Integer> one, ListNode<Integer> two){
        ListNode<Integer> dummyHead = new ListNode<>(0, null);
        ListNode<Integer> iter = dummyHead;
        int carry = 0;
        while(one != null || two != null || carry != 0 ) {
            int temp = carry + (one == null ? 0 : one.value) + (two == null ? 0 : two.value);
            one = one == null ? null : one.next;
            two = two == null ? null : two.next;
            // this is cool how it adds to the linked list just changing next not adding a new one at the front
            iter.next = new ListNode<>(temp % 10, null);
            carry = temp / 10;
            iter = iter.next;
        }
        return dummyHead.next;
    }
}
