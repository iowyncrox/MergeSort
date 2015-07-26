import java.util.Arrays;

public class MergeSort {

	public static void mergeSort(Integer[] intArray) {
		Comparable[] temp = new Comparable[intArray.length];
		mergeSort(intArray, temp, 0, intArray.length - 1);
		System.out.println(Arrays.toString(intArray));
	}

	private static void mergeSort(Comparable[] a, Comparable[] temp, int start,
			int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(a, temp, start, mid);
			mergeSort(a, temp, mid + 1, end);
			merge(a, temp, start, mid + 1, end);
		}
	}

	private static void merge(Comparable[] a, Comparable[] temp, int left,
			int right, int rightEnd) {

		int k = left;
		int leftEnd = right - 1;
		int num = rightEnd - left + 1;

		while (left <= leftEnd && right <= rightEnd) {
			if (a[left].compareTo(a[right]) <= 0) {
				temp[k++] = a[left++];
			} else {
				temp[k++] = a[right++];
			}
		}

		while (left <= leftEnd) {
			temp[k++] = a[left++];
		}

		while (right <= rightEnd) {
			temp[k++] = a[right++];
		}

		for (int i = 0; i < num; i++, rightEnd--) {
			a[rightEnd] = temp[rightEnd];
		}
	}

	public static void main(String[] args) {
		Integer[] a = { 4, 8, 1, 7, 6, 5, 3, 2, 0 };
		MergeSort.mergeSort(a);
	}
}