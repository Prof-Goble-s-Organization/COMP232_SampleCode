package structures.generic;

/**
 * Doubly linked list implementation of myList interface
 * 
 * @author William Goble
 * @author Dickinson Colelge
 * @version Feb 12 2024
 */
public class MyDoublyLinkedList<E> implements MyList<E> {
    private DLLNode head;
    private DLLNode tail;
    private int size;    

    public MyDoublyLinkedList() {
        head = new DLLNode(null, null, null);
        tail = new DLLNode(null, head, null);
        head.next = tail;
        size = 0;
    }

    public int size() {
        return size;
    }

    public void add(E element) {
        DLLNode pred = tail.prev;
        DLLNode node = new DLLNode(element, pred, tail);
        pred.next = node;
        tail.prev = node;

        size++;
    }

    private DLLNode getNode(int index) {
        checkBounds(index);
        DLLNode curr = head.next;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        return curr;
    }

    private void checkBounds(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index 
                            + " on List of size " + size + ".");
        }
    }

    public E get(int index) throws IndexOutOfBoundsException {
        DLLNode node = getNode(index);
        return node.element;
    }

    public void set(int index, E element) throws IndexOutOfBoundsException {
        DLLNode node = getNode(index);
        node.element = element;
    }

    public void insert(int index, E element) throws IndexOutOfBoundsException {
        DLLNode succ = tail;
        if (index != size) {
            succ = getNode(index);
        }

        DLLNode node = new DLLNode(element, succ.prev, succ);
        succ.prev.next = node;
        succ.prev = node;

        size++;
    }

    /**
     * {@inheritDoc}
     */
    public E remove(int index) throws IndexOutOfBoundsException {
        // Intentionally not implemented, to be done as a homework assignment
        return null;
    }

    private class DLLNode {
        public E element;
        public DLLNode prev;
        public DLLNode next;

        public DLLNode(E element, DLLNode prev, DLLNode next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }
}
