package algorithms;

public class Searches {
	public static <T extends Comparable<T>> int binarySearch(T[] data, T value, int lo, int hi) {
		if (lo > hi)
			return -1;
		
		int mid = (lo + hi) / 2;

		if (data[mid].compareTo(value) == 0) return mid;
		if (data[mid].compareTo(value) < 0) return binarySearch(data, value, mid + 1, hi);
		if (data[mid].compareTo(value) > 0) return binarySearch(data, value, lo, mid - 1);
		return -1;
	}
	
	public static <T extends Comparable<T>> int binarySearch(T[] data, T value) {
		return binarySearch(data, value, 0, data.length - 1);
	}
	
	public static <T extends Comparable<T>> int linearSearch(T[] data, T value) {
		return linearSearch(data, value, 0, data.length - 1);
	}
	
	public static <T extends Comparable<T>> int linearSearch(T[] data, T value, int lo, int hi) {
		for (int i = lo; i <= hi; i++)
			if (data[i].compareTo(value) == 0)
				return i;
		return -1;
	}
}
