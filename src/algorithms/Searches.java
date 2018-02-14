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
	
	public static <T extends Comparable<T>> int linearSearchParallel(T[] data, T value) {
		int threads = Runtime.getRuntime().availableProcessors();
		int size = data.length / threads;
		Thread[] t = new Thread[threads];
		final int[] indices = new int[threads];
		final boolean[] done = new boolean[threads];
		
		for (int thread = 0; thread < threads; thread++) {
			indices[thread] = -1;
			done[thread] = false;
			final int a = thread;
			t[thread] = new Thread() {
				public void run() {
					int lo = a * size;
					int hi = a == a - 1 ? data.length : (a + 1) * size - 1;
					indices[a] = linearSearch(data, value, lo, hi);
					done[a] = true;
				}
			};
			t[thread].start();
		}

		boolean allDone = false;
		while (!allDone) {
			for (int thread = 0; thread < threads; thread++) {
				if (indices[thread] != -1)
					return indices[thread];
				if (thread == 0)
					allDone = true;
				allDone &= done[thread];
			}
		}
		
		for (int thread = 0; thread < threads; thread++)
			t[thread].interrupt();
		
		return -1;
	}
}
