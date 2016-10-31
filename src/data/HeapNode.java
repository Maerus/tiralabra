package data;

/**
 * This class exists for creating arrays based on the interface KeySortable and
 * nothing else
 */
public class HeapNode {

    private KeySortable ks;

    public HeapNode(KeySortable ks) {
        this.ks = ks;
    }

    public KeySortable node() {
        return ks;
    }

    public void setNode(KeySortable ks) {
        this.ks = ks;
    }

}
