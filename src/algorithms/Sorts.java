package algorithms;

public class Sorts {
	private static <T extends Comparable<T>> void merge(T[] data, int lo, int hi) {
		Comparable[] aux = new Comparable[hi - lo + 1];
		int pa = lo;
		int mid = (lo + hi) / 2;
		int pb = mid + 1;

		for (int index = 0; index < aux.length; index++)
			if (pb > hi || (pa <= mid && data[pa].compareTo(data[pb]) <= 0))
				data[index] = data[pa++];
			else if (pb <= hi)
				data[index] = data[pb++];

		System.arraycopy(aux, 0, data, lo, aux.length);
	}
	
	private static <T extends Comparable<T>> void mergesort(T[] data, int lo, int hi) {
		if (lo < hi) {
			int mid = (lo + hi) / 2;
				
			mergesort(data, lo, mid);
			mergesort(data, mid + 1, hi);
			
			merge(data, lo, hi);
		}
	}
	
	public static <T extends Comparable<T>> void mergesort(T[] data) {
		mergesort(data, 0, data.length - 1);
	}
	
	public static <T extends Comparable<T>> void mergesortparallel(T[] data) {
		
	}
}
