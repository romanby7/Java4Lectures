public class LinkedListHashTableImpl extends HashTableImpl {

    public LinkedListHashTableImpl(int maxSize) {
        super(maxSize);
        this.data = new Entry[maxSize * 2];
    }

    private class Entry {

        private Item key;
        private int value;
        private Entry next;

        public Entry(Item key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    protected Entry[] data;

    @Override
    public boolean put(Item item, Integer cost) {

        if (size == maxSize) {
            return false;
        }

        int index = hashFunc(item.hashCode());
        if (data[index] != null) {
            Entry e = data[index];
            while (e.next != null) {
                e = e.next;
            }

            e.next = new LinkedListHashTableImpl.Entry(item, cost);

        }
        else {
            data[index] = new LinkedListHashTableImpl.Entry(item, cost);
        }

        size++;

        return true;

    }

    @Override
    public Integer get(Item item) {
        int index = indexOf(item);
        if (index == INVALID_INDEX) {
            return INVALID_COST;
        } else {
            for (Entry e = data[index]; e != null; e = e.next ) {
                if (e.key.equals(item)) {
                    return e.value;
                }
            }
        }

        return INVALID_COST;

//        return index == INVALID_INDEX ? INVALID_COST : data[index].value;
    }

    @Override
    public boolean remove(Item item) {
        int index = indexOf(item);
        if (index != INVALID_INDEX) {
            return remove(index, item);

        } else {
            return false;
        }
    }


    private int indexOf(Item item) {
        int index = hashFunc(item.hashCode());

        if (data[index] != null) {
            for (Entry e = data[index]; e != null; e = e.next ) {
                if (e.key.equals(item)) {
                    return index;
                }
            }
        }

        return -1;
    }

    private boolean remove(int index, Item item ) {
        Entry current = data[index];
        Entry previous = null;

        while ( current != null ) {
            if ( current.key.equals(item) ) {
                break;
            }
            previous = current;
            current = current.next;
        }

        if (current == null) {
            return false;
        }

        if (current == data[index]) {
            data[index] = current.next;
        }
        else {
            previous.next = current.next;
        }

        return true;
    }

    @Override
    public void display() {
        System.out.println("-----------");
        for (int i = 0; i < data.length; i++) {
            for (Entry e = data[i]; e != null; e = e.next ) {
                System.out.print(String.format("%d = [%s]; ", i, e));
            }

            System.out.println();
        }
        System.out.println("-----------");
    }

}
