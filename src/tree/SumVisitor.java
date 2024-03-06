package tree;

/**
 * A SumVisitor object can be used to visit each node in the COMP232BinaryTree 
 * computing the sum of the values at each node. This class words only on the 
 * specific case where the keys are strings and the values are ints.
 * 
 * @author William Goble
 * @author Dickinson College
 * @version Feb 27, 2024
 */
public class SumVisitor implements COMP232Visitor<String, Integer> {
    private int total;

    public SumVisitor() {
        total = 0;
    }

    public void visit(String key, Integer value) {
        total = total + value;
    }

    public int getTotal() {
        return total;
    }

    public static void main(String[] args) {
        String[] keys = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        Integer[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        COMP232BinaryTree<String, Integer> tree = new COMP232LinkedBinaryTree<String, Integer>(keys, values);
        SumVisitor sumVisitor = new SumVisitor();

        tree.visitLevelOrder(sumVisitor);
        int total = sumVisitor.getTotal();
        System.out.println("Total is " + total);
    }
}
