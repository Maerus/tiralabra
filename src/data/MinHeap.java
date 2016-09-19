
package data;

import data.graph.Vertex;


public class MinHeap<E>{
    
    private int length;
    private Object[] array;
    
    public MinHeap(int heapLength) {
        length = 0;
        array = new Object[heapLength];
    }
    
    /**
     * Returns the index of the parent node
     * 
     * Because index is an integer, the division gets floored automatically.
     * 
     * @param index of a node in the heap
     * @return the index of the parent node
     */
    public int parent(int index){
        return index / 2;
    }
    
    /**
     * Returns the index of the left child node
     * 
     * @param index of a node in the heap
     * @return the index of the left child node
     */
    public int left(int index){
        return 2 * index;
    }
    
    /**
     * Returns the index of the right child node
     * 
     * @param index of a node in the heap
     * @return the index of the right child node
     */
    public int right(int index){
        return 2 * index + 1;
    }
    
    
    
    
    
    
    
    // everything below this comment is not finished nor final
    
    
    
    
    
    
    
    /**
     * The helper algorithm to correct the heap
     * I need to figure out an implementation with comparing the nodes before this gets finished
     * 
     * @param index
     */
    private void heapify(int index){
        int left = left(index);
        int right = right(index);
        int smallest;
        if(right <= length){
            /*
            smallest = array[left].key < array[right].key ? left : right;
            if(array[index].key > array[smallest].key){
                swap(index, smallest);
                heapify(smallest);
            }
            */
        }
        /*
        else if (left == length && array[index].key > array[left].key){
            swap(index, left);
        }
        */
    }
    
    
    public void insert(Vertex v, double weight){
        
    }
    
    public void decreasePriority(Vertex v, double weight){
        
    }
    
    public Vertex deleteMin(){
        return null;
    }
    
    
}
