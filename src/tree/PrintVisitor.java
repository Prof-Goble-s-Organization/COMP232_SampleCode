package tree;

/**
 * A visitor that prints out the <key, value> pair at each node that it visits
 * 
 * @author William Goble
 * @author Dickinson College
 * @version Feb 27, 2024
 */
public class PrintVisitor<K, V> implements COMP232Visitor<K, V> {
    public void visit(K key, V value) {
        System.out.println("(" + key + ", " + value + ")");
    }

    public static void main(String[] args) {
        String[] keys = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        String[] values = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        COMP232LinkedBinaryTree<String, String> tree = new COMP232LinkedBinaryTree<String, String>(keys, values);

        System.out.println("Preorder:");
        tree.visitPreOrder(new PrintVisitor<String, String>());

        System.out.println();
        System.out.println("Level Order:");
        tree.visitLevelOrder(new PrintVisitor<String, String>());
    }
}
