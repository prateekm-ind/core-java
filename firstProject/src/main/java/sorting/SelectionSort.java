package sorting;

/*
 * - Does less memory writes as compared to
 * - QuickSort, MergeSort, Insertion Sort etc
 * - CycleSort is optimal in terms of memory writes
 *
 * - Basic idea of heap sort
 * - Not Stable
 * - In-place does not require extra space
 *
 * */
public class SelectionSort {

    public void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    swap(arr, i, j);
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] arr = {3,4,1,17,8,9,6,17,5};
        selectionSort.selectionSort(arr);
    }
}
