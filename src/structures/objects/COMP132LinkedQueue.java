package structures.objects;

public class COMP132LinkedQueue implements COM132Queue {
    private COMP132List elements;

    public COMP132LinkedQueue() {
        elements = new COMP132SinglyLinkedList();
    }

    public Object peek() {
        if(elements.size() > 0) {
            return elements.get(0);
        } else {
            return null;
        }
    }

    public Object remove() {
        if (elements.size() > 0) {
            return elements.remove(0);
        } else {
            return null;
        }
    }

    public void add(Object obj) {
        elements.add(obj);
    }

    public int size() {
        return elements.size();
    }
}
