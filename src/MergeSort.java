import java.util.Arrays;

public class MergeSort {

	public static void mergeSort(Integer[] intArray) {
		Comparable[] temp = new Comparable[intArray.length];
		mergeSort(intArray, temp, 0, intArray.length - 1);
		System.out.println(Arrays.toString(intArray));
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
			if (array[left].compareTo(array[right]) <= 0) {
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

	public static void main(String[] args) {
		Integer[] a = { 4, 8, 1, 7, 6, 5, 3, 2, 0 };
		MergeSort.mergeSort(a);
	}
}
