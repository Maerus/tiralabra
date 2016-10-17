
package data;

public interface KeySortable {
    public void setKey(int d);
    public int getKey();
    public int getIndex();
    public void setIndex(int i);
    public void setInHeap(boolean inHeap);
    public boolean isInHeap();
}
