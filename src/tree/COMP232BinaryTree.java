package tree;

/**
 * Interface to be implemented by binary tree implementations
 * 
 * @author William Goble
 * @author Dickinson College
 * @version Feb 27, 2024
 */
public interface COMP232BinaryTree<K, V> {
    public int size();
    public boolean contains(K key);
    public V get(K key);
    public void set(K key, V value);
    public void add(K key, V value);
    public V remove(K key);

    public void visitPreOrder(COMP232Visitor<K, V> visitor);
    public void visitInOrder(COMP232Visitor<K, V> visitor);
    public void visitPostOrder(COMP232Visitor<K, V> visitor);
    public void visitLevelOrder(COMP232Visitor<K, V> visitor);
}
