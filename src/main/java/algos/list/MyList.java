package algos.list;

import org.w3c.dom.Node;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class MyList implements Iterable {

    @Override
    public Iterator iterator() {
        return new Iterator() {
            @Override
            public boolean hasNext() {

                if (first == null) return false;
                if (index == null) return true;
                return index.next != null;
            }

            @Override
            public Object next() {
                if (hasNext()) {
                    MyList.Node temp;
                    if(index == null) {
                        index = first;
                    }else {
                        index = index.next;

                    }
                    return index;
                } else throw new NullPointerException("no more nodes!!!");

            }
        };
    }

    public static class Node {
        int value;
        Node next;
        Node(int v) {
            value = v;
            next=null;
        }
        @Override
        public String toString(){
            return "Node[" + this.value + "]";
        }

    }
    Node first;
    Node last;
    Node index;
    public MyList(){
        first = null;
        last = null;
        index = null;
    }

    /**
     * Add a Node at the end of this list. This list is not returned just altered in place.
     * @param n The node to add
     */
    public void add(Node n) {
        if(first == null) {
            first = n;
            last = n;
            return;
        }
        last.next = n;
        last = n;
    }

    public static void combineSortedLists(MyList l1, MyList l2) {

    }



    public void test1() {
        MyList m = new MyList();
        Node n0 = new Node(333);
        Node n1 = new Node(3);
        Node n2 = new Node(4);
        Node n3 = new Node(1);
        Node n4 = new Node(2);
        m.add(n0);
        m.add(n1);
        m.add(n2);
        m.add(n3);
        m.add(n4);
        Iterator i = m.iterator();
        int index = 0;
        while(i.hasNext()){
            index++;
            System.out.println(i.next());
        }


    }

    public static void main(String[] args) {
        MyList mlist = new MyList();
        mlist.test1();
    }
}
