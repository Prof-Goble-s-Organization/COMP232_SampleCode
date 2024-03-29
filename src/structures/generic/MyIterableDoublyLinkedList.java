package structures.generic;

import java.util.NoSuchElementException;

/**
 * Doubly linked list implementation of the MyList interface. This
 * implementation also implements MyIterable. It is separate from the
 * MyDoublyLinkedList class only so that our discussion of that class would
 * not be clouded by these details. In practice there would only be one
 * DoublyLinked implementation of MyList and it would implement both
 * MyList and MyIterable (i.e. this class).
 * 
 * @author William Goble
 * @author Dickinson College
 * @version Feb 8, 2024
 */
public class MyIterableDoublyLinkedList<E> implements MyList<E>, MyIterable<E> {
    private DLLNode head;
    private DLLNode tail;
    private int size;

    /**
	 * Construct a new empty myIterableDoublyLinkedList.
	 */
	public MyIterableDoublyLinkedList() {
		/*
		 * This implementation uses dummy head and tail nodes to simplify the
		 * implementation of insert/remove/add operations at the start or end of
		 * the list.
		 */
		head = new DLLNode(null, null, null);
		tail = new DLLNode(null, head, null);
		head.next = tail;
		size = 0;
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
	public void add(E element) {
		DLLNode pred = tail.prev;
		DLLNode node = new DLLNode(element, pred, tail);
		pred.next = node;
		tail.prev = node;

		size++;
	}

	/*
	 * Helper method to get the DLLNode at the specified index.
	 * 
	 * Throws exception if the index is not valid.
	 */
	private DLLNode getNode(int index) {
		checkBounds(index);
		DLLNode cur = head.next;
		for (int i = 0; i < index; i++) {
			cur = cur.next;
		}
		return cur;
	}

	/*
	 * Helper method that throws an exception if the index is not valid.
	 */
	private void checkBounds(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Invalid index: " + index
					+ " on List of size " + size + ".");
		}
	}

    /**
	 * {@inheritDoc}
	 */
	public E get(int index) throws IndexOutOfBoundsException {
		DLLNode node = getNode(index);
		if (node != null) {
			return node.element;
		} else {
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void set(int index, E element) throws IndexOutOfBoundsException {
		DLLNode node = getNode(index);
		node.element = element;
	}

    /**
	 * {@inheritDoc}
	 */
	public void insert(int index, E element) throws IndexOutOfBoundsException {
		/*
		 * If the list is empty then tail will succeed (appear immediately
		 * after) the new node. Otherwise, the node at index succeeds the new
		 * node.
		 */
		DLLNode succ = tail;
		if (index != size) {
			succ = getNode(index);
		}

		// Whatever succ points to now comes after new node.
		DLLNode node = new DLLNode(element, succ.prev, succ);
		succ.prev.next = node;
		succ.prev = node;

		size++;
	}

	/**
	 * {@inheritDoc}
	 */
	public E remove(int index) throws IndexOutOfBoundsException {
		// Intentionally not implemented... see HW assignment!
		return null;
	}

	/*
	 * Defines the node object for the doubly linked list. Note: Fields are
	 * public so that they can be accessed directly rather than via accessors
	 * and mutators. This make the implementations of the doubly linked list
	 * methods above easier to implement and read. And because the DLLNode class
	 * is private to this class it is not an egregious violation of
	 * encapsulation.
	 */
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

    /**
	 * {@inheritDoc}
	 */
	public MyIterator<E> getIterator() {
		return new DLLIterator();
	}

	/*
	 * Iterator implementation for the doubly linked list.
	 */
	private class DLLIterator implements MyIterator<E> {

		private DLLNode cursor;

		public DLLIterator() {
			cursor = head;
		}

		public boolean hasNext() {
			return cursor.next != tail;
		}

		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException("There is no next element.");
			} else {
				cursor = cursor.next;
				return cursor.element;
			}
		}

		public boolean hasPrevious() {
			// Intentionally not implemented, see HW assignment!
			throw new UnsupportedOperationException("Not implemented");
		}

		public E previous() {
			// Intentionally not implemented, see HW assignment!
			throw new UnsupportedOperationException("Not implemented");
		}

		public void insert(E element) {
			/*
			 * NOTE: cursor may be on head, but will never be on tail. So
			 * insert just places the new element after cursor, regardless
			 * of where it is.  Thank you dummy nodes!
			 */
			DLLNode node = new DLLNode(element, cursor, cursor.next);
			cursor.next.prev = node;
			cursor.next = node;
			cursor = node;
			size++;
		}

		public E remove() {
			// Intentionally not implemented, see HW assignment!
			throw new UnsupportedOperationException("Not implemented");
		}
	}
}
