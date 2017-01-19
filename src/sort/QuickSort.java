package sort;



public class QuickSort {
	
	static int partition(int [] lists, int left, int right) {
		int key = lists[left];
		while (left < right) {
			while (left < right && lists[right] >= key) {
				right--;
			}
			lists[left] = lists[right];
			while (left < right && lists[left] <= key) {
				left++;
			}
			lists[right] = lists[left];
		}
		lists[left] = key;
		return left;
	}
	static void quickSort(int [] lists, int left, int right) {
		int pos = 0;
		if (left < right) {
			pos = partition(lists, left, right);
			quickSort(lists, left, pos - 1);
			quickSort(lists, pos + 1, right);
		}
	}
	public static void main(String[] args) {
		int a[] = {2, 8, 9, 5, 7, 0, 10, 6};
		int right = a.length - 1;
		quickSort(a, 0, right);
		for (int i : a) {
			System.out.print(i + " ");
		}
		
	}
}
