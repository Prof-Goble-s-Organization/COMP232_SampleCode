package structures.generic;

public class DDLExample {
    /*
     * Initial functions we want to compare the differences between
     * - setUp
     *      How to populate a list using standard insert vs iterator insert
     * - printList
     *      printing out the contents of the list
     *          - this will show the difference between traversing with get and
     *          traversing with iterator
     * - printHalf
     *      print out the first half of the list
     */
    public static void setUp(MyDoublyLinkedList<String> lst) {
        for(int i = 0; i < 10; i++){
            lst.add("element" + (i+1));
        }
    }

    public static void setUp(MyIterableDoublyLinkedList<String> lst){
        MyIterator<String> itr = ((MyIterable<String>) lst).getIterator();
        for(int i = 0; i < 10; i++){
            itr.insert("element" + (i+1) + " from iterator");
        }
    }

    public static void printList(MyDoublyLinkedList<String> lst){
        for(int i = 0; i < lst.size() / 2; i++){
            String element = lst.get(i);
            System.out.println(element);
        }
    }

    public static void printList(MyIterableDoublyLinkedList<String> lst) {
        MyIterator<String> itr = ((MyIterable<String>) lst).getIterator();
        int ctr = 0;
        int half = lst.size() / 2;
        while (ctr < half){
            String element = itr.next();
            System.out.println(element);
            ctr++;
        }   
    }

    public static void main(String[] args) {
        /*
         * Implement two lists, one DLL and one Iterable DLL to better 
         * understand the differences when working with them.
         */
        MyDoublyLinkedList<String> list1 = new MyDoublyLinkedList<String>();
        MyIterableDoublyLinkedList<String> list2 = new MyIterableDoublyLinkedList<>();

        setUp(list1);
        printList(list1);
        String breakLine = new String(new char[30]).replace("\0", "=");
        System.out.println(breakLine);
        setUp(list2);
        printList(list2);
    }
}
