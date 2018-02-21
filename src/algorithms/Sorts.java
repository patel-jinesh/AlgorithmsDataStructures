package algorithms;

import java.util.concurrent.ForkJoinPool;

import javafx.scene.chart.PieChart.Data;

public class Sorts {
	public static <T extends Comparable<T>> void merge(T[] data, int lo, int hi) {
		Comparable[] aux = new Comparable[hi - lo + 1];
		int pa = lo;
		int mid = (lo + hi) / 2;
		int pb = mid + 1;

		for (int index = 0; index < aux.length; index++) {
			if (pb > hi || (pa <= mid && data[pa].compareTo(data[pb]) <= 0))
				aux[index] = data[pa++];
			else if (pb <= hi)
				aux[index] = data[pb++];
			else
				System.out.println("Hit else");
		}

		System.arraycopy(aux, 0, data, lo, aux.length);
	}

	public static <T extends Comparable<T>> void mergesort(T[] data, int lo, int hi) {
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

	public static <T extends Comparable<T>> void quicksort(T[] data) {
		quicksort(data, 0, data.length - 1);
	}

	public static <T extends Comparable<T>> void quicksort(T[] data, int lo, int hi) {
		if (lo >= hi)
			return;

		int[] p = partition(data, data[lo], lo, hi);

		quicksort(data, lo, p[0] - 1);
		quicksort(data, p[1] + 1, hi);
	}

	public static <T extends Comparable<T>> int[] partition(T[] data, T pivot, int lo, int hi) {
		int lt = lo;
		int gt = hi;
		int i = lo;

		while (i <= gt) {
			int cmp = data[i].compareTo(pivot);
			if (cmp > 0) {
				T temp = data[gt];
				data[gt] = data[i];
				data[i] = temp;
				gt--;
			} else if (cmp < 0) {
				T temp = data[lt];
				data[lt] = data[i];
				data[i] = temp;
				lt++;
				i++;
			} else {
				i++;
			}
		}

		return new int[] { lt, gt };
	}

	public static <T extends Comparable<T>> void selectionsort(T[] data) {
		for (int i = 0; i < data.length; i++) {
			int index = i;

			for (int j = i + 1; j < data.length; j++)
				if (data[j].compareTo(data[index]) < 0)
					index = j;

			T temp = data[i];
			data[i] = data[index];
			data[index] = temp;
		}
	}

	public static <T extends Comparable<T>> void insertionsort(T[] data) {
		for (int i = 1; i < data.length; ++i) {
			for (int j = i; j > 0 && data[j].compareTo(data[j - 1]) < 0; --j) {
				T temp = data[j];
				data[j] = data[j - 1];
				data[j - 1] = temp;
			}
		}
	}

	public static <T extends Comparable<T>> void binaryinsertionsort(T[] data) {
		for (int i = 1; i < data.length; i++) {
			T value = data[i];
			int index = binarySearch(data, value, 0, i - 1);

			for (int j = i; j > index; j--)
				data[j] = data[j - 1];

			data[index] = value;
		}
	}

	private static <T extends Comparable<T>> int binarySearch(T[] x, T value, int lo, int hi) {
		if (lo > hi)
			return lo;

		int mid = (lo + hi) / 2;

		if (x[mid].compareTo(value) < 0)
			return binarySearch(x, value, mid + 1, hi);
		if (x[mid].compareTo(value) > 0)
			return binarySearch(x, value, lo, mid - 1);

		return mid;
	}

	private static <T extends Comparable<T>> void sink(T[] a, int n, int i) {
		int parent = i;
		int leftChild = 2 * i + 1;
		int rightChild = leftChild + 1;

		if (leftChild < n && a[leftChild].compareTo(a[parent]) >= 0)
		    parent = leftChild;
		if (rightChild < n && a[rightChild].compareTo(a[parent]) >= 0)
		    parent = rightChild;

		if (parent != i) {
		    T temp = a[i];
		    a[i] = a[parent];
		    a[parent] = temp;

		    sink(a, n, parent);
		}
	}

	public static <T extends Comparable<T>> void heapsort(T[] data) {
		for (int i = data.length / 2 - 1; i >= 0; i--)
		    sink(data, data.length, i);

		for (int i = data.length - 1; i >= 0; i--) {
		    T temp = data[0];
		    data[0] = data[i];
		    data[i] = temp;

		    sink(data, i, 0);
		}
	}
}
