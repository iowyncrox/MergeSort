import java.util.Arrays;

public class MergeSort {

	public static void mergeSort(Comparable[] array) {
		Comparable[] temp = new Comparable[array.length];
		mergeSort(array, temp, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
	}

	private static void mergeSort(Comparable[] array, Comparable[] temp,
			int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(array, temp, start, mid);
			mergeSort(array, temp, mid + 1, end);
			merge(array, temp, start, mid + 1, end);
		}
	}

	private static void merge(Comparable[] array, Comparable[] temp, int left,
			int right, int rightEnd) {

		int k = left;
		int leftEnd = right - 1;
		int num = rightEnd - left + 1;

		while (left <= leftEnd && right <= rightEnd) {
			if (compare(array[left], array[right])) {
				temp[k++] = array[left++];
			} else {
				temp[k++] = array[right++];
			}
		}

		while (left <= leftEnd) {
			temp[k++] = array[left++];
		}

		while (right <= rightEnd) {
			temp[k++] = array[right++];
		}

		for (int i = 0; i < num; i++, rightEnd--) {
			array[rightEnd] = temp[rightEnd];
		}
	}

	private static boolean compare(Comparable i, Comparable j) {
		return i.compareTo(j) <= 0;
	}

	public static void main(String[] args) {
		Integer[] a = { 4, 8, 1, 7, 6, 5, 3, 2, 0 };
		MergeSort.mergeSort(a);
	}
}
