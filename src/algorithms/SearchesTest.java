package algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SearchesTest {

	final static int ELEMENTS = 10000000;
	final static Integer[] test = new Integer[ELEMENTS];
	static int find = -1;
	boolean initial = true;
	
	@BeforeClass
	public static void setupBeforeClass() throws Exception {
		long start = System.currentTimeMillis();
		for (int i = 0; i < test.length; i++)
			test[i] = i;
		
		Collections.shuffle(Arrays.asList(test));
		find = test[test.length - 1];//ThreadLocalRandom.current().nextInt(0, test.length);
		long end = System.currentTimeMillis();
		System.out.println("Setup complete in " + (end - start) + " ms.");
	}

	@Test
	public void testBinarySearch() {
		Integer[] t = Arrays.copyOf(test, test.length);
		Arrays.sort(t);
		long start = System.currentTimeMillis();
		int index = Searches.binarySearch(t, find);
		long end = System.currentTimeMillis();
		System.out.println("Binary Search : Found " + find + " at index " + index + " in " + (end - start) + " ms");
		
	}

	@Test
	public void testLinearSearchTArrayT() {
		long start = System.currentTimeMillis();
		int index = Searches.linearSearch(test, find);
		long end = System.currentTimeMillis();
		System.out.println("Linear Search : Found " + find + " at index " + index + " in " + (end - start) + " ms");
	}

	@Test
	public void testLinearSearchParallel() {
		long start = System.currentTimeMillis();
		int index = Searches.linearSearchParallel(test, find);
		long end = System.currentTimeMillis();
		System.out.println("Linear Search Parallel : Found " + find + " at index " + index + " in " + (end - start) + " ms");
	}

}
