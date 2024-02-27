package tree;

import java.util.*;

/**
 * Linked List implementation of a binary tree
 * 
 * @author William Goble
 * @author Dickinson College
 * @version Feb 27, 2024
 */
public class COMP232LinkedBinaryTree<K, V> implements COMP232BinaryTree<K, V> {
    protected BTNode<K, V> root;
    protected int size;


    // Construct a new empty LinkedBinaryTree
    public COMP232LinkedBinaryTree() {
        root = null;
        size = 0;
    }

    /**
     * Construct a new  LinkedBinaryTree with the specified <key, value> pair 
     * stored at the root.
     * 
     * @param key
     *      the key
     * @param value
     *      the value
     * @throws IllegalArgumentException
     *      if the key is null
     */
    public COMP232LinkedBinaryTree(K key, V value) {
        root = getNewNode(key, value);
        size = 1;
    }

    /**
     * Build a complete binary tree from the provided keys and values. The nodes 
     * of the tree filled in from the arrays in level order. So the first 
     * elements become the root, the second the left child of the root, and 
     * the third the right child of the root, etc. 
     * @param keys
     * @param values
     */
    public COMP232LinkedBinaryTree(K[] keys, V[] values) {
        if (keys.length != values.length) {
            throw new IllegalArgumentException("Length of keys and values must be the same.");
        }
        if (keys.length == 0) {
            throw new IllegalArgumentException("keys and values must not be empty");
        }

        /*
         * Construct the tree in level order by using a queue. The root is 
         * created from the first element of the arrays and is placed in the 
         * queue. Then while there are at least two elements left in the arrays, 
         * the node at the head of the queue is removed and the next two 
         * elements are assigned as its left and right children. Those children 
         * are placed into the queue, left first. If there is a single element 
         * left at the end, it is assigned as the left child of the node at the 
         * head of the queue.
         */
        
         // Create the root
         Queue<BTNode<K, V>> nodeQueue = new LinkedList<BTNode<K, V>>();
         root = getNewNode(keys[0], values[0]);
         size++;
         nodeQueue.add(root);

         // As long as there are 2 elements left
         while (size < keys.length - 1) {
            BTNode<K, V> subRoot = nodeQueue.remove();

            // Assign the next element as the left child
            BTNode<K, V> leftChild = getNewNode(keys[size], values[size]);
            leftChild.parent = subRoot;
            subRoot.left = leftChild;
            nodeQueue.add(leftChild);
            size++;

            // Assign the next element as the right child
            BTNode<K, V> rightChild = getNewNode(keys[size], values[size]);
            rightChild.parent = subRoot;
            subRoot.right = rightChild;
            nodeQueue.add(rightChild);
            size++;
         }

         // If there is one left, assign it as the left child
         if (size < keys.length) {
            BTNode<K, V> subRoot = nodeQueue.remove();
            BTNode<K, V> leftChild = getNewNode(keys[size], values[size]);
            leftChild.parent = subRoot;
            subRoot.left = leftChild;
            nodeQueue.add(leftChild);
            size++;

            subRoot.right = null;
         }
    }

    /**
     * Construct a new LinkedBinaryTree. The specified <key, value> pair will be 
     * stored at the root. The root of the LinkedBinaryTree left will be stored 
     * as the left child of the root of the new tree. The root of the 
     * LinkedBinaryTree right will be stored as the right child of the root of 
     * the new tree
     * 
     * @param leftSubTree
     *          the tree that should appear as the left child of the new tree
     * @param key
     *          the key for the root of the new tree
     * @param value
     *          the value for the root of the new tree
     * @param rightSubTree
     *          the tree that should appear as the right child of the new tree
     */
    public COMP232LinkedBinaryTree(COMP232LinkedBinaryTree<K, V> leftSubTree,
                K key, V value, COMP232LinkedBinaryTree<K, V> rightSubTree) {
        // Intentionally not implemented -- see homework assignment
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * {@inheritDoc}
     */
    public int size() {
        return size;
    }

    /**
     * {@inheritDoc}
     */
    public boolean contains(K key) {
        // Intentionally not implemented -- see homework assignment
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * {@inheritDoc}
     */
    public V get(K key) {
        BTNode<K, V> targetNode = getNodeFromSubTree(root, key);
        if(targetNode != null) {
            return targetNode.value;
        } else {
            return null;
        }
    }

    /**
     * Helper method to get the node containing the key from the subtree rooted 
     * at subTreeRoot.
     * 
     * @param subTreeRoot
     *      The subtree we are currently searching through
     * @param key
     *      The target key we want to find
     * @return
     *      The node we have been trying to get
     */
    private BTNode<K, V> getNodeFromSubTree(BTNode<K, V> subTreeRoot, K key) {
        if (subTreeRoot == null) { 
            return null;        // Can't get it from the empty tree
        } else if (subTreeRoot.key.equals(key)) {
            return subTreeRoot;        // the root contains the key
        } else {
            System.out.println(subTreeRoot.key);
            // try to get it from the left subtree
            BTNode<K, V> node = getNodeFromSubTree(subTreeRoot.left, key);
            if(node != null) {
                return node;
            }

            // we haven't found it in the left, now try the right
            // returns null if we don't find it
            node = getNodeFromSubTree(subTreeRoot.right, key);
            return node;
        }
    }

    /**
     * {@inheritDoc}
     */
    public void set(K key, V value) {
        BTNode<K, V> node = getNodeFromSubTree(root, key);
        if (node == null) {
            throw new NoSuchElementException("No node with key: " + key);
        } else {
            node.value = value;
        }
    }

    /**
     * Add a new node with the specified <key, value> pair to the tree. The new 
     * node is added at the first empty child location encountered in level order.
     * 
     * @param key
     *      the key
     * @param value
     *      the value
     */
    public void add(K key, V value) {
        // Intentionally not implemented -- set homework assignment
        throw new UnsupportedOperationException("Not yet implemented");

        /*
         * Hint: Use a queue to perform a level order traversal of the tree until 
         * a  node with a missing child is found. At each node (starting with 
         * the root), if it has no left child, add the new node as the left 
         * child and we are done. If the node has no right child, add the new 
         * node as the right child and we are done. If the node has both children, 
         * add them each to the queue and repeat with the node from the head 
         * of the queue.
         */
    }

    /**
     * Remove the node with the specified key from the tree. If the node 
     * concaining the key is a left, it is simply removed from the tree. If the 
     * node has one or more descendants, its rightmost leaf takes its place in 
     * the tree.
     * 
     * Note: Instead of removing the node, the <key, value> pair from the rightmost 
     * leaf are moved to the node and then that descendant leaf is removed.
     * 
     * @param key
     *          The key of the node to be removed
     * @return 
     *          The value of the removed node or null if no node is removed.
     */
    public V remove(K key) {
        /* 
         * First find the node to remove (ntr). If it doesn't exist we can return 
         * null and be done. If ntr does exist, find the rightmost left descendant 
         * (rmld) Swap the key and value from the rml into the ntr and unlink 
         * the rml from the tree
         */
        BTNode<K ,V> ntr = getNodeFromSubTree(root, key);
        if (ntr == null) {
            // node is not in the tree, we are done
            return null;
        } else if (size == 1) {
            // node is the root, and only node in the tree
            V rootValue = root.value;
            size = 0;
            root = null;
            return rootValue;
        } else {
            /*
             * Note: This does a little unnecessary work when the node being 
             * removed is a left. We could easily add another if else clause 
             * to reduce this work. For now, the choice was made to provide 
             * shorter code
             */

             /*
              * Find the right-most left descendeant (rmld) of the node to remove 
              * Find this by going right whenever possible and left when not possible 
              * to go right. 
              */
            BTNode<K, V> rmld = ntr;
            while (!rmld.isLeaf()) {
                if (rmld.right != null) {
                    rmld = rmld.right;
                } else {
                    rmld = rmld.left;
                }
            }

            // Save the value we want to return
            V replacedValue = ntr.value;

            // More the <key, value> from emld to the ntr
            ntr.key = rmld.key;
            ntr.value = rmld.value;

            // Unlink the rml from the tree
            if (rmld.parent.left == rmld) {
                rmld.parent.left = null;
            } else {
                rmld.parent.right = null;
            }

            size--;
            return replacedValue;
        }
    }

    /**
     * @{inheritDoc}
     */
    public void visitPreOrder(COMP232Visitor<K, V> visitor) {
        subTreeVisitPreOrder(root, visitor);
    }

    private void subTreeVisitPreOrder(BTNode<K, V> subtreeRoot, 
            COMP232Visitor<K, V> visitor) {
        if(subtreeRoot != null) {
            visitor.visit(subtreeRoot.key, subtreeRoot.value);
            subTreeVisitPreOrder(subtreeRoot.left, visitor);
            subTreeVisitPreOrder(subtreeRoot.right, visitor);
        }
    }

    /**
     * {@inheritDoc}
     */
    public void visitInOrder(COMP232Visitor<K, V> visitor) {
        // Intentionally not implemented -- see homework assignment
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @{inheritDoc}
     */
    public void visitPostOrder(COMP232Visitor<K, V> visitor) {
        subTreeVisitPostOrder(root, visitor);        
    }

    private void subTreeVisitPostOrder(BTNode<K, V> subtreeRoot, COMP232Visitor<K, V> visitor) {
        if(subtreeRoot != null) {
            subTreeVisitPostOrder(subtreeRoot.left, visitor);
            subTreeVisitPostOrder(subtreeRoot.right, visitor);
            visitor.visit(subtreeRoot.key, subtreeRoot.value);
        }
    }

    public void visitLevelOrder(COMP232Visitor<K, V> visitor) {
        /*
         * A queue is used to perform a levelorder traversal. The root of the 
         * tree is placed in the queue. While the queue is not empty, the node 
         * at the head of the queue is visited. After visiting the node, its 
         * children if any are placed into the queue, left then right, to be 
         * visited later.
         */

        Queue<BTNode<K, V>> nodeQueue = new LinkedList<BTNode<K, V>>();
        nodeQueue.add(root);

        while (nodeQueue.size() > 0) {
            // visit the node at the head of the queue
            BTNode<K, V> current = nodeQueue.remove();
            visitor.visit(current.key, current.value);

            // add the left child, if any, to the queue
            if (current.left != null) {
                nodeQueue.add(current.left);
            } 

            // add the right child, if any, to the queue
            if (current.right != null) {
                nodeQueue.add(current.right);
            }
        }
    }

    /**
     * Count the number of leaf nodes in this tree
     * 
     * @return
     */
    public int countLeafNodes() {
        // Internationally not implemented -- see homework assignment
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Get a new node for this tree. This is used instead of simply creating 
     * a new node within the above methods so that methods that are inherited 
     * by future classes can override this method to have the tree constructed 
     * with different types of nodes.
     * 
     * @param key
     *          The key for the new node
     * @param value
     *          The value for the new node
     * @return
     *          the new node
     */
    protected BTNode<K, V> getNewNode(K key, V value) {
        return new BTNode<K, V>(key, value);
    }

    static protected class BTNode<K ,V> {
        public K key;
        public V value;
        public BTNode<K, V> left;
        public BTNode<K, V> right;
        public BTNode<K, V> parent;

        public BTNode(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            parent = null;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }

        /*
         * Note: The parent pointer isn't strictly necessary for some of the 
         * basic binary tree uses and operations. However, as this class 
         * serves as the basis for later work on Heaps and AVL Trees where 
         * parent pointers are necessary it is included here from the start. 
         * This allows the Heap and AVL Trees to inherit much of the 
         * functionality (e.g. traversals) from earlier implementations.
         */
    }
}
