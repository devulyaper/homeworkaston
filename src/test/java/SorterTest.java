import org.example.myList.MyArrayList;
import org.example.sorter.MyListSorter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

 class SorterTest {
    @Test
     void testSorter(){
        MyArrayList<Integer> array = new MyArrayList<>();
        for (int i = 0; i < 100000; i++) {
            array.add((int) (Math.random() * 100000));
        }
        MyListSorter.sort(array);
        for (int i = 0; i < array.size() - 1; i++) {
            Assertions.assertTrue(array.get(i) <= array.get(i + 1));
        }
    }
}
