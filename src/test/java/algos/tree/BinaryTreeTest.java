package algos.tree;

import algos.list.ListNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {
    public static Node n1, n2, n3, n4, n5, n6, n7, n8, n9;

    @BeforeEach
    void init() {
        n1 = new Node(8); // root
        n2 = new Node(6);
        n3 = new Node(1);
        n4 = new Node(5);
        n5 = new Node(7);
        n6 = new Node(9);
        n7 = new Node(4);
        n8 = new Node(2);
        n9 = new Node(3);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;
        n6.right = n8;
        n4.left = n7;
        n7.left = n9;
    }
    @Test
    void testMakeTree() {
//        use random int as key and same as String value
        Map<Integer, String> map = new TreeMap<>();
        int numNodes = 10;
        int maxInt = 1000;
        for (int i = 0; i < numNodes; i++) {
            int randInt = (int) (Math.random() * maxInt + 1);
            map.put(randInt, Integer.toString(randInt));
        }
        System.out.println("size=" + map.size());
        assertEquals(map.size(), 10);
        map.forEach((k,v) -> {
            System.out.println(k + ":" + v);
        });
    }

    @Test
    void testConstructor() {
        BinaryTree bt = new BinaryTree();
        bt.root = new Node(5);
        assertEquals(bt.root.right, null);
        assertEquals(bt.root.left, null);
        assertNotEquals(bt.root, null);
        assertEquals(5, bt.root.value);
    }

    @Test
    void testInsert() {
        BinaryTree bt = new BinaryTree();
        bt.root = new Node(5);
        Node n = new Node(10);
        bt.insert(n);
        assertEquals(bt.root.left, null);
        assertNotEquals(bt.root.right, null);
        assertEquals(bt.root.right.value, 10);
        Node nn = new Node(1);
        bt.insert(nn);
        assertNotEquals(bt.root.left, null);
        assertEquals(bt.root.left.value, 1);
    }

    @Test
    public void testPreorder() {
        System.out.println("preorder");
        BinaryTree bt = new BinaryTree();
        bt.root = n1;
        bt.preorderTraversal(n1);
    }

    @Test
    void testPrintLevel() {
        BinaryTree bt = new BinaryTree();
        bt.root = n1;
        bt.printLevel(2, bt.root);
    }
    }