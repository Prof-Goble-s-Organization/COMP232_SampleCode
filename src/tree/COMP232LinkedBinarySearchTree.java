package tree;

/**
 * Linked implementation of a binary search tree. The binary search tree inherits 
 * the methods from the binary tree. The add and remove methodsa must be overriden 
 * so that they maintain the BST Property. The contains, get, and set methods 
 * are overriden to improve their performance by taking advantage of the BST 
 * Property. The inherited size and traversal methods work well as they are.
 * 
 * @author William Goble
 * @author Dickinson College
 * @version Feb 29, 2024
 */
public class COMP232LinkedBinarySearchTree<K extends Comparable<K>, V> extends COMP232LinkedBinaryTree<K, V>{
    /*
     * Note: We inherit the size and root fields, and add the BTNode class from 
     * the LinkedBinaryTree class because they were declared as protected in 
     * that class.
     */

    /**
     * Construct an empty binary search tree
     */
    public COMP232LinkedBinarySearchTree() {
        super();
    }

    /**
     * Construct a binary search tree with a single node at the root.
     * 
     * @param key
     *      The key for the root
     * @param value
     *      The value for the root
     */
    public COMP232LinkedBinarySearchTree(K key, V value) {
        super(key, value);
    }

    /**
	 * Construct a binary search tree using the provided keys and values. The
	 * key,value pairs are inserted into the tree in level order. If the
	 * resulting tree does not satisfy the BST Property, then an
	 * IllegalArgumentException is thrown.
	 * 
	 * @param keys
	 *            the keys.
	 * @param values
	 *            the values.
	 * @throws IllegalArgumentException
	 *             if the keys and values do not have the same length, the keys
	 *             or the values are empty, or the keys are not specified in an
	 *             order that results in a valid binary search tree.
	 */
    public COMP232LinkedBinarySearchTree(K[] keys, V[] values) {
        super(keys, values);

        if(!checkBSTProperty()) {
            throw new IllegalArgumentException("Key, Value pairs did not satisfy BST property.");
        }
    }

    /**
	 * Determine whether the binary tree satisfies the binary search tree
	 * property (BSTP). That is, all values in the left subtree are strictly less
	 * than the root value. And all values in the right subtree are greater
	 * than or equal to the root value. And this property holds recursively
	 * for every other node in the tree.
	 * 
	 * @return true if the tree satisfies the binary search tree property,
	 *         and false otherwise.
	 */
    public boolean checkBSTProperty() {
        return checkBSTPropertyHelp(root, null, null);
    }

    /**
	 * Determine whether the binary tree with the given root node satisfies
	 * the binary search tree property (BSTP) AND all keys in the tree are
	 * strictly less than the 'high' parameter AND all keys in the tree are
	 * greater than or equal to the 'low' parameter. If 'high' is null,
	 * there is no maximum on the keys; if 'low' is null, there is no
	 * minimum on the keys. Note that our definition of the binary search
	 * tree property insists that left children are strictly smaller, while
	 * right children can be equal or strictly greater.
	 * 
	 * This implementation is adapted from OpenDSA textbook materials
	 * (https://opendsa-server.cs.vt.edu/). Specifically, this is from
	 * section 15 of the Binary tree chapter, in e.g.
	 * https://opendsa-server.cs.vt.edu/OpenDSA/Books/CS2/html/
	 * 
	 * Note that the OpenDSA implementation assumes that any equal keys are
	 * in the left subtree, whereas our implementation assumes they are in
	 * the right subtree. This leads to certain differences in the
	 * algorithm, but the principles are the same.
	 * 
	 * @param subTreeRoot The root of the subtree to be checked
	 * @param low         The inclusive minimum for all keys in the tree
	 * @param high        The exclusive maximum for all keys in the tree
	 * @return true if BSTP holds and all keys are at least 'low' and all
	 *         keys are less than 'high'
	 * 
	 */
    public boolean checkBSTPropertyHelp(BTNode<K, V> subTreeRoot, K low, K high) {
        if (subTreeRoot == null) {
            return true;
        }
        K key = subTreeRoot.key;
        if (high != null && key.compareTo(high) >= 0) {
            return false;
        }
        if (low != null && key.compareTo(low) < 0) {
            return false;
        }

        return checkBSTPropertyHelp(subTreeRoot.left, low, key) && checkBSTPropertyHelp(subTreeRoot.right, key, high);
    }
}
