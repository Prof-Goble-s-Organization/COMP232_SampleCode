package hashing.list;

import java.util.NoSuchElementException;

/**
 * Doubly Linked list implementation of the List interface
 * 
 * @author William Goble
 * @author Dickinson College
 * @version April 8, 2024
 */
public class IterableDoublyLinkedList<E> implements List<E>, Iterable<E> {
    private DLLNode head;
    private DLLNode tail;
    private int size;

    public IterableDoublyLinkedList() {
        head = new DLLNode(null, null, null);
        tail = new DLLNode(null, head, null);
        head.next = tail;
        size = 0;
    }

    public int size() {
        return size;
    }

    public void add(E element) {
        DLLNode prev = tail.prev;
        DLLNode node = new DLLNode(element, prev, tail);
        prev.next = node;
        tail.prev = node;

        size++;
    }

    private DLLNode getNode(int index) {
        checkBounds(index);
        DLLNode current = head.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private void checkBounds(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index + " on List of size " + size + ".");
        }
    }

    public E get(int index) throws IndexOutOfBoundsException {
        DLLNode node = getNode(index);

        if (node != null) {
            return node.element;
        } else {
            return null;
        }
    }

    public void set(int index, E element) throws IndexOutOfBoundsException {
        DLLNode node = getNode(index);
        node.element = element;
    }

    public void insert(int index, E element) throws IndexOutOfBoundsException {
        DLLNode succeed = tail;
        if (index != size) {
            succeed = getNode(index);
        }

        DLLNode node = new DLLNode(element, succeed.prev, succeed);
        succeed.prev.next = node;
        succeed.prev = node;

        size++;
    }

    public E remove(int index) throws IndexOutOfBoundsException {
        DLLNode node = getNode(index);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
        return node.element;
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

    public Iterator<E> getIterator() {
        return new DLLIterator();
    }

    public class DLLIterator implements Iterator<E> {
        private DLLNode cursor;
        private DLLNode lastReturned;

        public DLLIterator() {
            cursor = head;
            lastReturned = null;
        }

        public boolean hasNext() {
            return cursor.next != tail;
        }

        public E next() {
            if(!hasNext()) {
                throw new NoSuchElementException("There is no next element");
            } else {
                cursor = cursor.next;
                lastReturned = cursor;
                return cursor.element;
            }
        }

        public boolean hasPrevious() {
            return cursor.prev != null;
        }

        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException("There is no previous element");
            } else {
                lastReturned = cursor;
                E element = cursor.element;
                cursor = cursor.prev;
                return element;
            }
        }

        public void insert(E element) {
            DLLNode node = new DLLNode(element, cursor, cursor.next);
            cursor.next.prev = node;
            cursor.next = node;
            cursor = node;
            lastReturned = null;
            size++;
        }

        public E remove() {
            if (lastReturned == null) {
                throw new IllegalStateException("At the start of the list, cannot remove");
            } else {
                DLLNode node = lastReturned;
                cursor = lastReturned.prev;
                node.prev.next = node.next;
                node.next.prev = node.prev;
                size--;
                lastReturned = null;
                return node.element;
            }
        }
    }

    public boolean checkListIntegrity() {
        if (size == 0) {
            return head.next == tail && tail.prev == head;
        } else {
            DLLNode curr = head.next;

            while (curr.next != tail) {
                DLLNode prev = curr.prev;
                DLLNode next = curr.next;

                if (prev.next != curr || next.prev != curr) {
                    return false;
                }

                curr = curr.next;
            }
        }

        return true;
    }
}
