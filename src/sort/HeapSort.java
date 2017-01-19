package sort;

public class HeapSort {
//小顶堆
//	public static void heapSort(int a[]) {
//		int size = a.length;
//		buildHeap(a, size);
//		for (int i = size - 1; i >=0; i--) {
//			int tmp = a[i];
//			a[i] = a[0];
//			a[0] = tmp;
//			adjustHeap(a, 0, i);
//		}
//	}
//	public static void adjustHeap(int a[], int i, int size) {
//		int left = 2 * i + 1;
//		int right = 2 * i + 2;
//		int min = i;
//		if (i < size/2) {
//			if (a[min] > a[left] && left < size) {
//				min = left;
//			}
//			if (a[min] > a[right] && right < size) {
//				min = right;
//			}
//			if (min != i) {
//				int temp = a[min];
//				a[min] = a[i];
//				a[i] = temp;
//				adjustHeap(a, min, size);
//			}
//		}
//		
//	}
//	public static void buildHeap(int a[], int size) {
//		for (int i = size / 2 - 1; i >= 0; i--) {
//			adjustHeap(a, i, size);
//		}
//	}
//	
	public static void buildMaxHeap(int a[], int size) {
		for (int i = size / 2 - 1; i >= 0; i--) {
			adjustMaxHeap(a, i, size);
		}
	}
	public static void adjustMaxHeap(int a[], int i, int size) {
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int max = i;
		if (i < size / 2) {
			if (a[max] < a[left] && left < size) {
				max = left;
			} 
			if (a[max] < a[right] && right < size) {
				max = right;
			}
			if (max != i) {
				int temp = a[max];
				a[max] = a[i];
				a[i] = temp;
				adjustMaxHeap(a, max, size);
			}
		}
		
	}
	public static void maxHeapSort(int a[]) {
		int size = a.length;
		buildMaxHeap(a, size);
		for (int i = size - 1; i >= 0; i--) {
			int temp = a[i];
			a[i] = a[0];
			a[0] = temp;
			adjustMaxHeap(a, 0, i);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int lists[] = {3, 5, 4, 2, 1, 6, 8, 7, 9, 0, 11, 14, 12};
		
		for (int i : lists) {
			System.out.print(i + " ");
		}
		System.out.println();
		//小顶堆
		//heapSort(lists);
		//大顶堆
		maxHeapSort(lists);
		for (int i : lists) {
			System.out.print(i + " ");
		}
	}

}
