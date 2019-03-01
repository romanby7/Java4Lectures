import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.geekbrains.datastructure.lesson4.linkedlist.SimpleLinkedListImpl;


public class SimpleLinkedListIteratorTest {
    SimpleLinkedListImpl<Integer> linkedList;
    SimpleLinkedListImpl.SimpleLinkedListIterator itr;
    private final int MAX_SIZE = 10000;

    @Before
    public void initTests() {
        linkedList = new SimpleLinkedListImpl<>();
        for (int i = 0; i < MAX_SIZE; i++) {
            linkedList.insert(i);

        }

        itr = (SimpleLinkedListImpl.SimpleLinkedListIterator) linkedList.iterator();
    }

    @Test
    public void testIterator() {
        int i = MAX_SIZE - 1;

        for (Integer integer : linkedList) {
            Assert.assertEquals((int) integer, i);
            i--;
        }
    }

    @Test
    public void testRemove1() {

        int[] arr = {3, 4, 0, 2, 1, 1000};
        for (int i = 0; i < arr.length - 1; i++) {
            removeValue(arr[i]);
            Assert.assertEquals(linkedList.getSize(), MAX_SIZE - (i + 1));
        }
    }

    private void removeValue(int i) {
        itr.reset();
        while (itr.hasNext()) {
            if ((Integer) itr.getCurrentValue() == i) {
                itr.remove();
            }
            itr.next();
        }
    }

    @Test
    public void testRemoveAll() {

        while (itr.hasNext()) {
            itr.remove();
            itr.reset();
        }

        itr.reset();
        itr.remove();

        Assert.assertEquals(linkedList.getSize(), 0);

    }


}
