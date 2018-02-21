package algorithms;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SortsTest {
	private final int ELEMENTS = 100000;
	private final Integer[] data = new Integer[ELEMENTS];

	@Before
	public void setUp() throws Exception {
		for (int i = 0; i < data.length; i++)
			data[i] = i;
		
		Collections.shuffle(Arrays.asList(data));
	}
	
	@After
	public void tearDown() {
		assertArraySorted(data);
	}

	@Test
	public void testMergesort() {
		Sorts.mergesort(data);
	}

	@Test
	public void testQuicksort() {
		Sorts.quicksort(data);
		assertArraySorted(data);
	}
	
	//@Test
	public void testSelectionsort() {
		Sorts.selectionsort(data);
	}
	
	//@Test
	public void testInsertionsort() {
		Sorts.insertionsort(data);
	}
		
	//@Test
	public void testBinaryinsertionsort() {
		Sorts.binaryinsertionsort(data);
	}
		
	@Test
	public void testHeapsort() {
		Sorts.heapsort(data);
	}
	
	private <T extends Comparable<T>> void assertArraySorted(T[] data) {
		for (int i = 0; i < data.length - 1; i++)
			assertTrue(data[i].compareTo(data[i + 1]) <= 0);
	}

}
