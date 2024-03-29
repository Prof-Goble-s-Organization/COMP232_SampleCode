package structures.generic;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * An example illustrating sources of ConcurrentModificationExceptions.
 * 
 * @author William Goble
 * @author Dickinson College
 * @version Feb 12, 2024
 */
public class ConcurrentModificationIssues {
    public static void main(String[] args) {
        /*
		 * Concurrent modification issues occur when the list is modified using
		 * the List's insert, add, remove while also using an iterator. The
		 * issue is that the iterator would not know that the list has changed
		 * and may miss an element, return an element multiple times, or the
		 * cursor may even be on an element that is no longer in the list.
		 * 
		 * When using an iterator, always use the iterator's insert and remove
		 * methods to modify the list!
		 */
        ArrayList<String> list = getList();
        Iterator<String> itr = list.iterator();

        while(itr.hasNext()) {
            String str = itr.next();
            if(str.equals("Three")) {
                list.remove(2);
            }
        }

        /**
         * The for each loop in Java relies on the use of an iterator behind 
         * the scenes. So it is easy to introduce with concurrent modifications 
         * when using a for each loop.
         */
        list = getList();
        for(String str: list) {
            if(str.equals("Three")) {
                list.remove(2);
            }
        }
    }

    public static ArrayList<String> getList() {
        ArrayList<String> list = new ArrayList<String>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");

        return list;
    }
}
