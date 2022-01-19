package algos.tree;

import algos.list.ListNode;

import java.util.LinkedList;
import java.util.List;

class Node {
    int value;
    Node left;
    Node right;

    Node(int v) {
        this.value = v;
        right = null;
        left = null;
    }
}

public class BinaryTree {
    Node root;

    /**
     *  We'll follow these rules starting from the root node:
     *     if the new node's value is lower than the current node's, we go to the left child
     *     if the new node's value is greater than the current node's, we go to the right child
     *     when the current node is null, we've reached a leaf node and we can insert the new
     *     node in that position
     * @param n The Node to insert.
     */
    public void insert(Node n) {
        if(root == null){
            root = n;
            return;
        }
        while(root != null) {
            if (n.value < root.value) {
                if(root.left == null) {
                    root.left = n;
                    return;
                }
                root = root.left;
            } else if (n.value >= root.value) {
                if(root.right == null){
                    root.right = n;
                    return;
                }
                root = root.right;
            }
        }
    }

    /**
     * Recursive version of insert from above.
     * @param value
     */
    public void add(int value) {
        add(root, value);
    }

    private Node add(Node current, int value) {
        if(current == null) return new Node(value);
        if(value < current.value)
            return add(current.left, value);
        else return add(current.right, value);
    }

    public void preorderTraversal(Node current) {
        if(current == null) return;
        System.out.println(current.value);
        preorderTraversal(current.left);
        preorderTraversal(current.right);
    }

//    depthlevel traversal
    public void printLevelsOfTree(Node node) {
        if(node == null) return;
        for (int i = 0; i < height(node); i++) {

        }
    }
// todo: make private
    public static int height(Node n) {
        int h = 0;
        if (n == null) return 0;
        int lheight = height(n.left);
        int rheight = height(n.right);
        return lheight > rheight ? lheight + 1: rheight + 1;

    }


// todo: make private
    public void printLevel(int level, Node node) {
        if (level == 0) return;
        if (level == 1) System.out.println(node.value);
        else if (level > 1) {
            printLevel(level - 1, node.left);
            printLevel(level - 1, node.right);
        };
    }
}
