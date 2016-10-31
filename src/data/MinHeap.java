package data;

/**
 * This class is a minimum binary heap which replaces the priority queue used in
 * certain pathfinding algorithms
 */
public class MinHeap {

    private int length;
    private HeapNode[] array;

    /**
     * Constructs a new array to contain the vertices in the heap
     *
     * @param size The maximum size of the heap (the amount of vertices in the
     * graph)
     */
    public MinHeap(int size) {
        this.length = 0;
        array = new HeapNode[size + 1];
    }

    /**
     * Returns the index of the parent node.
     *
     * Because index is an integer, the division gets floored automatically.
     *
     * @param index of a node in the heap
     * @return the index of the parent node
     */
    public int parent(int index) {
        return (index / 2);
    }

    /**
     * Returns the index of the left child node.
     *
     * @param index of a node in the heap
     * @return the index of the left child node
     */
    public int left(int index) {
        return (2 * (index));
    }

    /**
     * Returns the index of the right child node.
     *
     * @param index of a node in the heap
     * @return the index of the right child node
     */
    public int right(int index) {
        return (2 * (index) + 1);
    }

    /**
     * The helper function to correct the heap.
     *
     * @param index the position in the heap
     */
    private void heapify(int index) {

        int smallest = index;

        if (right(index) < length) {
            smallest = getKey(left(index)) < getKey(right(index)) ? left(index) : right(index);
            if (getKey(index) > getKey(smallest)) {
                swap(index, smallest);
                heapify(smallest);
            }

        } else if (left(index) < length && getKey(index) > getKey(left(index))) {
            swap(index, left(index));
        }

    }

    private void swap(int i, int j) {
        HeapNode a = new HeapNode(array[i].node());
        array[i] = new HeapNode(array[j].node());
        array[j] = a;
        array[i].node().setIndex(i);
        array[j].node().setIndex(j);
    }

    private int getKey(int i) {
        return array[i].node().getKey();
    }

    /**
     * Inserts a new node in the heap as long as the heap array can fit it
     *
     * @param node new node to be inserted
     */
    public void insert(HeapNode node) {
        // see if the heap array can fit a new object
        if (length < array.length) {
            length++;
            int index = length;
            while (index > 1 && array[parent(index)].node().getKey() > node.node().getKey()) {
                array[index] = new HeapNode(array[parent(index)].node());
                array[index].node().setIndex(index);
                index = parent(index);
            }
            array[index] = node;
            array[index].node().setIndex(index);
            array[index].node().setInHeap(true);
        }
    }

    /**
     * Decreases the key of a node and rearranges the heap accordingly.
     *
     * @param index index of the node to change the key of
     * @param newKey new key value for the node
     */
    public void decreaseKey(int index, int newKey) {
        if (newKey < array[index].node().getKey()) {

            array[index].node().setKey(newKey);
            if (index == 1) {
                return;
            }
            while (array[parent(index)].node().getKey() > array[index].node().getKey()) {
                swap(index, parent(index));
                index = parent(index);
                if (index == 1) {
                    return;
                }
            }
        }
    }

    /**
     * Deletes and returns the root of the heap which contains the node with the
     * minimum key value and then rearranges the heap.
     *
     * @return the node with the minimum key value
     */
    public HeapNode deleteMin() {
        HeapNode min = null;
        if (length > 0) {
            min = array[1];
            min.node().setInHeap(false);
            array[1] = new HeapNode(array[length].node());
            length--;
            heapify(1);
        }
        return min;
    }

    public int getLength() {
        return length;
    }

    public HeapNode[] getArray() {
        return array;
    }

}
