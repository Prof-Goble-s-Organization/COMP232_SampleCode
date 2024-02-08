package structures.objects;

import java.util.ArrayList;

/**
 * Sample comparing the use of COMP132ArrayList which uses the Object type to 
 * the Java ArrayList which is generic and uses a type parameter
 * 
 * @author William Goble
 * @author Dickinson College
 * @version Feb 8, 2024
 */
public class COMP132VsJavaAPI {
    public static void main(String[] args) {

        /**
         * Using the COMP132Array List: The 132 ArrayList stored its elements 
         * as type Object, which allowed the list to store any tpye of object. 
         * While this is desirable, it means that lots of casting is required 
         * and that the compiler cannot catch many common type errors. Because 
         * the compiler cannot catch the errors they become runtime errors, 
         * which is often more difficult to diagnose and fix.
         */
        COMP132ArrayList list1 = new  COMP132ArrayList();
        list1.add("A string");
        list1.add(new Integer(42));
        list1.add(new Double(3.14159));

        String str1 = (String) list1.get(0);        // type cast is required
        System.err.println(String.format("Here is my first string: %s", str1));
        Double dbl1 = (Double) list1.get(1);        // error!
        System.out.println(String.format("Here is my double: %f", dbl1));
        /**
         * Using Java's ArrayList: The Java ArrayList is generic. The type of 
         * objects that can be stored in the list is specified by a type 
         * parameter when the list is creaeted. This allows the compiler to 
         * detect many common type errors. It also means that casts are not 
         * required when retrieving items from the list.
         */
        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("a string");
        list2.add("another string");
        list2.add("only adding strings!");
        // list2.add(new Integer(42));     // no good

        String str2 = list2.get(1);     // no need to cast
        System.out.println(String.format("Here is my second string: %s", str2));
        // Double dbl2 = list2.get(2);     // no good
    }
}
