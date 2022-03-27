package learn.arrays;

public class SlidingWindow {

    //window sliding to find sub-array with sum k
    public boolean subArrayWithSumK(int[] arr, int k) {
        int start = 0;
        int end = 0;
        int windowSum = 0;
        for (end = 0; end < arr.length; end++) {
            while (windowSum > k && start < end - 1) {
                windowSum = windowSum - arr[start];
                start++;
            }
            if (windowSum == k) {
                return true;
            }
            if (end < arr.length) {
                windowSum = windowSum + arr[end];
            }
        }
        return windowSum == k;
    }

    public static void main(String[] args) {

    }
}
