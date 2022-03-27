package sorting;

/*
 * - O(n2) Worst case
 * - in-place and stable
 * - used in practice for small arrays (TimSort and IntraSort)
 * - O(n) best case
 * - best sorting algorithm for the smaller arrays
 * */
public class InsertionSort {

    public void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }

        for(int i=0;i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,9,8,11,17,5,4};
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.insertionSort(arr);

        System.out.println();
    }
}
