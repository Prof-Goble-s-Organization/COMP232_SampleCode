package structures.objects;

public class COMP132SinglyLinkedList implements COMP132List {
    private SinglyLinkedNode head;
    private SinglyLinkedNode tail;
    private int currentSize;

    public COMP132SinglyLinkedList() {
        head = null;
        tail = null;
        currentSize = 0;
    }

    public int size() {
        return currentSize;
    }

    public void add(Object element) {
        SinglyLinkedNode newNode = new SinglyLinkedNode(element);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        currentSize++;
    }

    public Object get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= currentSize) {
            throw new IndexOutOfBoundsException("tried to access " + index 
                        + " but size is " + currentSize + ".");
        } else {
            SinglyLinkedNode node = getNode(index);
            return node.element;
        }
    }

    private SinglyLinkedNode getNode(int index) {
        SinglyLinkedNode node = head;

        // walk down the chain of the links until we get to the correct node
        for(int i = 0; i < index; i++) {
            node = node.next;
        }

        return node;
    }

    public void set(int index, Object element) throws IndexOutOfBoundsException {
        if (index < 0 || index >= currentSize) {
            throw new IndexOutOfBoundsException("tried to set " + index 
                            + " but size is " + currentSize + ".");
        } else {
            SinglyLinkedNode node = getNode(index);
            node.element = element;
        }
    }

    public void insert(int index, Object element) throws IndexOutOfBoundsException {
        if (index < 0 || index >= currentSize) {
            throw new IndexOutOfBoundsException("tried to set " + index 
                            + " but size is " + currentSize + ".");
        } else {
            SinglyLinkedNode newNode = new SinglyLinkedNode(element);

            if (index == 0) {
                newNode.next = head;
                head = newNode;
            } else {
                // walk down the chain of links until prev refers to the 
                // node that is prior to the new node in the list.
                SinglyLinkedNode prev = head;
                for(int i = 0; i < index-1; i++) {
                    prev = prev.next;
                }

                newNode.next = prev.next;
                prev.next = newNode;
            }

            currentSize++;
        }
    }

    public Object remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= currentSize) {
            throw new IndexOutOfBoundsException("tried to set " + index 
                            + " but size is " + currentSize + ".");
        } else {
            Object obj = null;

            if(index == 0) {
                obj = head.element;
                head = head.next;
            } else {
                SinglyLinkedNode prev = head;

                for(int i = 0; i < index - 1; i++) {
                    prev = prev.next;
                }

                SinglyLinkedNode node =prev.next;
                obj = node.element;
                prev.next = node.next;

                if(index == currentSize - 1) {
                    tail = prev;
                }
            }

            currentSize--;
            return obj;
        }
    }

    /**
     * Structure used to represent a node in the linked list
     */
    private static class SinglyLinkedNode {
        public SinglyLinkedNode next;
        public Object element;

        public SinglyLinkedNode(Object element) {
            this.element = element;
            next = null;
        }
    }
}
