package structures.generic;

/**
 * Generic interface specifying a Stack ADT
 * 
 * @author William Goble
 * @author Dickinson College
 * @version Feb 12, 2024
 */
public interface MyStack<E> {
    /**
     * Add the provided element to the top of the stack
     * 
     * @param obj
     *          the element to push onto the stack
     */
    public void push(E obj);
    
    /**
     * Remove the element from the top of the stack and return it
     * 
     * @return
     *          the element from the top of the stack, or null if the stack 
     *          is empty
     */
    public E pop();

    /**
     * Return a reference to the element on the top of the stack without 
     * removing it.
     * 
     * @return
     *          A reference to the element on the top of the stack  or null 
     *          if the stack is empty.
     */
    public E peek();

    /**
     * Return the number of elements contained in the stack
     * 
     * @return
     *          the size of the stack
     */
    public int size();
}
