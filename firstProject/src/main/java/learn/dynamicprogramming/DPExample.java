package learn.dynamicprogramming;

import java.util.Arrays;

public class DPExample {
    public int factorial(int n, int[] dpArr) {
        if (n <= 1) {
            return n;
        }

        if (dpArr[n] != -1) {
            System.out.println("from dpArr");
            return dpArr[n];
        }

        return dpArr[n] = factorial(n - 1, dpArr) + factorial(n - 2, dpArr);
    }

    public static void main(String[] args) {
        DPExample dpExample = new DPExample();
        int[] arr = new int[7];
        Arrays.fill(arr, -1);
        System.out.println(dpExample.factorial(6, arr));
    }
}
