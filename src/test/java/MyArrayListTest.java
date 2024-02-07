import org.example.myList.MyArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

 class MyArrayListTest {
    private MyArrayList<Integer> list =  new MyArrayList<>();

    @Test
     void testAddAndGet() {
        list.add(1);
        list.add(2);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
    }

    @Test
     void testAddByIndex() {
        list.add(1, 0);
        list.add(3, 1);
        list.add(2, 1);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
     void testRemoveByIndex() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(1);
        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));
    }

    @Test
     void testRemoveByValue() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(Integer.valueOf(2));
        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));
    }

    @Test
     void testRemoveAll() {
        list.add(1);
        list.add(2);
        list.removeAll();
        assertEquals(0, list.size());
    }

    @Test
     void testSize() {
        list.add(1);
        list.add(2);
        assertEquals(2, list.size());
    }
}
