public class RecSortedArrayImpl<E extends Object & Comparable<? super E>> extends SortedArrayImpl<E> {

    @Override
    public int indexOf(E value) {
        return recBinaryFind(value, 0, currentSize);
    }

    private int recBinaryFind(E value, int low, int high) {
        if (low > high) {
            return  INVALID_INDEX;
        }

        int mid = (low + high) / 2;
        if ( data[mid].equals(value) )
            return mid;

        if ( value.compareTo(data[mid]) < 0 ) {
            return recBinaryFind(value, low, mid - 1);
        }
        else {
            return recBinaryFind(value, mid + 1, high);
        }
    }
}
