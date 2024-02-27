package tree;

/**
 * Interface to be implemeneted by Visitors that act on the <key, value> 
 * pairs stored in nodes in the binary tree
 * 
 * @author William Goble
 * @author Dickinson College
 * @version Feb 27, 2024
 */
public interface COMP232Visitor<K, V> {
    /**
     * The visit method will be invoked at each node in a tree. The order in 
     * which the nodes are visited is determinded by the method that is used
     * 
     * @param key
     *          The key stored at the node
     * @param value
     *          The vlaue stored at the node
     */
    public void visit(K key, V value);
}
