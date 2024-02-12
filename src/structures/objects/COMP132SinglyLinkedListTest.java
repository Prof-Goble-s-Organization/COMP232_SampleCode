package structures.objects;

import org.junit.Before;

public class COMP132SinglyLinkedListTest extends COMP132ArrayList{
    /*
     * Because the tests in COMP132ArrayListTest all use the COMP132List 
     * interface thiss class will inherit all of those tests and use the 
     * COMP132SinglyLinkedList instead!
     */
    @Before
    public void setUp() throws Exception {
        COMP132SinglyLinkedList myList = new COMP132SinglyLinkedList();
    }
}
