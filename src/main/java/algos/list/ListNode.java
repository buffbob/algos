package algos.list;

import java.util.Iterator;

public class ListNode<T> {
    /**
     * Represents a node in a linked list. ListNode can be part of a list
     * however the List before this node cannot be accessed as only the field
     * next is declared.
     */

    T value;
    ListNode<T> next;

    public ListNode(T value, ListNode<T> next) {
        this.value = value;
        this.next = next;
    }

    public static <T> ListNode<T> searchList(ListNode<T> startNode, T key) {
        while(startNode != null && startNode.value != key) {
            startNode = startNode.next;
        }
        return startNode;
    }
    public static <T> void addAfter(ListNode<T> addAfter, ListNode<T> nodeToAdd) {
        nodeToAdd.next = addAfter.next;
        addAfter.next = nodeToAdd;
    }

    public static <T> void deleteAfter(ListNode<T> deleteAfter) {
        deleteAfter.next = deleteAfter.next.next;
    }
}
