package structures.objects;

/**
 * Container that uses the type Object to allow it to store objects of any type
 * Compare this class to the GenericBox class in the structures.generic package
 * to see how the same functionality is accomplished using Java Generics
 * 
 * @author William Goble
 * @author Dickinson College
 * @version Feb 8, 2024
 */
public class ObjectBox {
    // Use Object so value can refer to any data type
    private Object value;

    public ObjectBox(Object initValue) {
        value = initValue;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object newValue) {
        value = newValue;
    }

    public static void main(String[] args) {
        ObjectBox obj = new ObjectBox("Test String");

        /**
         * Because the compiler does not know what type is stroed in the object 
         * it is necessary to type cast the values when they are received
         */
        String str = (String) obj.getValue();
        System.out.println(String.format("initial value = %s", str));

        // We can put any type we like into this object
        obj.setValue(new Double(3.14));
        Double dbl = (Double) obj.getValue();
        System.out.println(String.format("new value: %f", dbl));

        // But that can lead to runtime errors that the compiler cannot detect
        String str2 = (String) obj.getValue();
        System.out.println(String.format("Here is my error: %s", str2));
    }
}
