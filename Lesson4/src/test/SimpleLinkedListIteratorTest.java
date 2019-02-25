import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.geekbrains.datastructure.lesson4.linkedlist.SimpleLinkedListImpl;


public class SimpleLinkedListIteratorTest {
    SimpleLinkedListImpl<Integer> linkedList;
    SimpleLinkedListImpl.SimpleLinkedListIterator itr;
    private final int MAX_SIZE = 5999999;

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
        for (Integer o : linkedList
             ) {
            Assert.assertEquals((int) o, i);
            i--;
        }

    }

    @Test
    public void testRemove1() {

        while (itr.hasNext()) {
            if ((Integer) itr.getCurrentValue() == 3) {
                itr.remove();
            }
            itr.next();
        }

        Assert.assertEquals(linkedList.getSize(), MAX_SIZE - 1);

        itr.reset();
        while (itr.hasNext()) {
            if ((Integer) itr.getCurrentValue() == 4) {
                itr.remove();
            }
            itr.next();
        }

        Assert.assertEquals(linkedList.getSize(), MAX_SIZE - 2);

        itr.reset();
        while (itr.hasNext()) {
            if ((Integer) itr.getCurrentValue() == 0) {
                itr.remove();
            }
            itr.next();
        }

        Assert.assertEquals(linkedList.getSize(), MAX_SIZE - 3);

        itr.reset();
        while (itr.hasNext()) {
            if ((Integer) itr.getCurrentValue() == 1 || (Integer) itr.getCurrentValue() == 2 ) {
                itr.remove();
            }
            itr.next();
        }

        Assert.assertEquals(linkedList.getSize(), MAX_SIZE - 4);

        itr.reset();
        while (itr.hasNext()) {
            if ((Integer) itr.getCurrentValue() == 1 ) {
                itr.remove();
            }
            itr.next();
        }

        Assert.assertEquals(linkedList.getSize(), MAX_SIZE - 5);

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
