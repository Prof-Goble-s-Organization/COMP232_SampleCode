package tree;

/**
 * Interface to be implemented by PriorityQueue. The order of the items in the 
 * priority queue is determined by the Key's implementation of the Comparator 
 * interface. The key that comes later in the ordering is implemented by the 
 * compareTo method appears at head of the priority. 
 * 
 * For example, if Integers or Doubles are used as the key, then the larger keys 
 * will be at the head of the queue. But note that for the same reason, if 
 * Strings are used as the key, words that come later in the dictionary order 
 * will be at the head of the queue
 * 
 * @author William Goble
 * @author Dickinson College
 * @version Feb 29, 2024
 */
public interface COMP232PriorityQueue<K extends Comparable<K>, V>{
    /**
     * Add the provided key, value pair to the priority queue
     * 
     * @param key
     *          The key to be added
     * @param value
     *          The associated value
     */
    public void add(K key, V value);

    /**
     * Remove the key, value pair with the highest priority
     * 
     * @return
     *      The value associated with the highest priority key, or null if 
     *      the priority queue is empty.
     */
    public V remove();

    /**
     * Return a reference to the value at the head of the priority queue without 
     * removing it from the queue.
     * 
     * @return
     *      A reference to the element at the head of the priority queue or 
     *      null if the priority queue is empty.
     */
    public V peek();

    /**
     * Return the number of elemetns in the priority queue
     * 
     * @return
     *      The size of the priority queue
     */
    public int size();

}
