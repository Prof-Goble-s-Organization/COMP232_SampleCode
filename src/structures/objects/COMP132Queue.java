package structures.objects;

/**
 * Interface specifying a Queue ADT
 * 
 * @author William Goble
 * @author Dickinson College
 * @version Feb 8, 2024
 */
public interface COMP132Queue {
    public void add(Object obj);

    public Object remove();

    public Object peek();

    public int size();
}
