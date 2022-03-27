package learn.search;

public class BinarySearch {
    public static int binarySearch(int[] arr, int start, int x, int end) {
        if (end >= start) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == x) {
                return mid;
            }

            if (arr[mid] > x) {
                return binarySearch(arr, start, x, mid - 1);
            }
            return binarySearch(arr, mid+1, x, end);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 6, 8, 9};
        System.out.println(binarySearch(arr, 0, 8, arr.length-1));

        System.out.println(binarySearch(arr, 0, 0, arr.length-1));
    }
}
