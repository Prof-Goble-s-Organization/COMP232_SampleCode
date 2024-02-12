package structures.objects;

public class COMP132LinkedStack implements COMP132Stack{
    private COMP132List elements;

    public COMP132LinkedStack() {
        elements = new COMP132SinglyLinkedList();
    }

    public Object peek() {
        if(elements.size() > 0) {
            return elements.get(0);
        } else {
            return null;
        }
    }

    public Object pop() {
        if(elements.size() > 0) {
            return elements.remove(0);
        } else {
            return null;
        }
    }

    public void push(Object obj) {
        elements.insert(0, obj);
    }

    public int size() {
        return elements.size();
    }
}
