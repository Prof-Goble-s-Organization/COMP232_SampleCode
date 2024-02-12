package structures.objects;

/**
 * Interface specifying a Stack ADT
 * 
 * @author William Goble
 * @author Dickinson College
 * @version Feb 8, 2024
 */
public interface COMP132Stack {
    /**
     * Add the provided Object to the top of the stack
     * 
     * @param obj
     *          the Object to push onto the stack
     */
    public void push(Object obj);
    
    /**
     * Remove the Object from the top of the stack and return it
     * 
     * @return
     *      The Object from the top of the stack or null if the stack is 
     *      empty.
     */
    public Object pop();

    /**
     * Return a reference to the Object on the top of the stack without 
     * removing it.
     * 
     * @return
     *       A reference to the object on the top of the stack or null if 
     *      the stack is empty
     */
    public Object peek();
    
    /**
     * Return th enumber of elements contained in the stack
     * 
     * @return
     *      The size of the stack
     */
    public int size();
}
