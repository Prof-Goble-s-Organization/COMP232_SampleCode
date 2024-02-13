package structures.generic;

/**
 * Some examples illustrating the use of Iterators to iterate over the elements
 * in a list. Also some comparison of the performance to iteration using the get
 * list operation.
 * 
 * @author William Goble
 * @author Dickinson College
 * @version Feb 12, 2024
 */
public class IteratorUseExamples {

	/**
	 * Run a comparison of List traversal with get vs. iterator.
	 * 
	 * @param args
	 *            none.
	 */
	public static void main(String[] args) {
		compareTraversals();
	}

	/**
	 * Compare the performance of traversing a LinkedList using the get
	 * operation to the same traversal using an iterator.
	 */
	public static void compareTraversals() {
		System.out.println("Building lists...");
		MyIterableDoublyLinkedList<String> linkedList = new MyIterableDoublyLinkedList<String>();
		fillList(linkedList, 100000);
		MyArrayList<String> arrayList = new MyArrayList<String>();
		fillList(arrayList, 100000);
		System.out.println("Lists built.");

		System.out.println();
		System.out.println("Traversing 100k element LinkedList with get...");
		long start = System.currentTimeMillis();
		traverseListWithGet(linkedList);
		long end = System.currentTimeMillis();
		System.out.println("Done in: " + (end - start) / 1e3 + " sec.");

		System.out.println();
		System.out
				.println("Traversing 100k element LinkedList with Iterator...");
		start = System.currentTimeMillis();
		traverseListWithIterator(linkedList);
		end = System.currentTimeMillis();
		System.out.println("Done in: " + (end - start) / 1e3 + " sec.");

		System.out.println();
		System.out.println("Traversing 100k element ArrayList with get...");
		start = System.currentTimeMillis();
		traverseListWithGet(arrayList);
		end = System.currentTimeMillis();
		System.out.println("Done in: " + (end - start) / 1e3 + " sec.");

		/*
		 * NOTE: Can't do a traversal of the ArrayList using an iterator because
		 * the MyArrayList class in the CS232Sampes.structures.generic package
		 * does not implement MyIterable. That is a HW question! So you could
		 * try this out after completing the homework if you like.
		 */
	}

	/**
	 * Traverse the list using the get operation. When using a LinkedList, this
	 * will be dramatically slower than traversing the list using an iterator.
	 * This approach using get() with a LinkedList will require O(n^2) vs O(n)
	 * with an iterator.
	 * 
	 * @param list
	 *            the list to traverse
	 */
	public static void traverseListWithGet(MyList<String> list) {
		for (int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			// do something with s.
		}
	}

	/**
	 * Traverse the list using an iterator operation. When using a LinkedList,
	 * this will be dramatically faster than traversing the list using the get()
	 * method. This approach using an iterator with a LinkedList will require
	 * O(n) vs O(n^2) with the get() method.
	 * 
	 * @param list
	 *            the list to traverse
	 */
	public static void traverseListWithIterator(MyIterable<String> list) {
		MyIterator<String> it = list.getIterator();
		while (it.hasNext()) {
			String s = it.next();
			// do something with s.
		}
	}

	/*
	 * Helper method to fill a list with a given number of elements.
	 */
	private static void fillList(MyList<String> list, int num) {
		for (int i = 0; i < num; i++) {
			list.add(new String("Item " + i));
		}
	}
}