package data;

/**
 * This interface generalizes the use of the MinHeap class. Since arrays of
 * interfaces cannot be made as is, the HeapNode object is used to contain a
 * single KeySortable in the array instead
 */
public interface KeySortable {

    public void setKey(int d);

    public int getKey();

    public int getIndex();

    public void setIndex(int i);

    public void setInHeap(boolean inHeap);

    public boolean isInHeap();
}
