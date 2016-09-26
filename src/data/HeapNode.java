
package data;

/**
 * This class exists to circumvent an error that happens when creating an array based on an interface (KeySortable)
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
