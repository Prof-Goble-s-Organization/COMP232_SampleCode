package structures.objects;

/**
 * A Linked-List based implementation of the Queue ADT.
 * 
 * @author William Goble
 * @author Dickinson College
 * @version Feb 8, 2024
 */
public class COMP132LinkedQueue implements COMP132Queue {
    private COMP132List elements;

    /**
	 * Create a new Linked-list based stack.
	 */
    public COMP132LinkedQueue() {
        elements = new COMP132SinglyLinkedList();
    }

    /**
	 * {@inheritDoc}
	 */
    public Object peek() {
        if(elements.size() > 0) {
            return elements.get(0);
        } else {
            return null;
        }
    }

    /**
	 * {@inheritDoc}
	 */
    public Object remove() {
        if (elements.size() > 0) {
            return elements.remove(0);
        } else {
            return null;
        }
    }

    /**
	 * {@inheritDoc}
	 */
    public void add(Object obj) {
        elements.add(obj);
    }

    /**
	 * {@inheritDoc}
	 */
    public int size() {
        return elements.size();
    }
}
