package algos.list;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class MyListTest {

    @Test
    void testAdd() {
        MyList m = new MyList();
        MyList.Node n0 = new MyList.Node(333);
        MyList.Node n1 = new MyList.Node(3);
        MyList.Node n2 = new MyList.Node(4);
        MyList.Node n3 = new MyList.Node(1);
        MyList.Node n4 = new MyList.Node(2);
        m.add(n0);
        m.add(n1);
        m.add(n2);
        m.add(n3);
        m.add(n4);
        assertEquals(n2.next.value, n3.value);
        assertEquals(n2.next.next, n4);
        int index = 0;
        Iterator<Integer> i = m.iterator();
        while(i.hasNext()){
            index++;
            System.out.println(i.next());
        }
        assertEquals(index, 5);

    }

}