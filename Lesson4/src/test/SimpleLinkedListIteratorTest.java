import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.geekbrains.datastructure.lesson4.linkedlist.SimpleLinkedListImpl;


public class SimpleLinkedListIteratorTest {
    SimpleLinkedListImpl<Integer> linkedList;
    SimpleLinkedListImpl.SimpleLinkedListIterator itr;


    @Before
    public void initTests() {
        linkedList = new SimpleLinkedListImpl<>();
        for (int i = 0; i < 5; i++) {
            linkedList.insert(i);

        }

        itr = (SimpleLinkedListImpl.SimpleLinkedListIterator) linkedList.iterator();
    }


    @Test
    public void testIterator() {
        int i = 4;
        for (Integer o : linkedList
             ) {
            Assert.assertSame(o, i);
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

        Assert.assertSame(linkedList.getSize(), 4);

        itr.reset();
        while (itr.hasNext()) {
            if ((Integer) itr.getCurrentValue() == 4) {
                itr.remove();
            }
            itr.next();
        }

        Assert.assertSame(linkedList.getSize(), 3);

        itr.reset();
        while (itr.hasNext()) {
            if ((Integer) itr.getCurrentValue() == 0) {
                itr.remove();
            }
            itr.next();
        }

        Assert.assertSame(linkedList.getSize(), 2);

        itr.reset();
        while (itr.hasNext()) {
            if ((Integer) itr.getCurrentValue() == 1 || (Integer) itr.getCurrentValue() == 2 ) {
                itr.remove();
            }
            itr.next();
        }

        Assert.assertSame(linkedList.getSize(), 1);

        itr.reset();
        while (itr.hasNext()) {
            if ((Integer) itr.getCurrentValue() == 1 ) {
                itr.remove();
            }
            itr.next();
        }


        for (Integer o: linkedList
             ) {
            System.out.println(o);
        }

        Assert.assertSame(linkedList.getSize(), 0);

    }

    @Test
    public void testRemoveAll() {

        while (itr.hasNext()) {
            itr.remove();
            itr.reset();
        }

        itr.reset();
        itr.remove();

        Assert.assertSame(linkedList.getSize(), 0);

    }

}
