package learn.arrays;

import java.util.HashSet;
import java.util.Set;

public class SubArrayWithAGivenSum {
    public static void main(String[] args) {
        int[] arr = new int[6];
        arr[0] = 5;
        arr[1] = 8;
        arr[2] = 6;
        arr[3] = 13;
        arr[4] = 3;
        arr[5] = -1;
        System.out.println("Sol : " + solution(arr, 22));
    }


    //Idea : use prefix sum technique with HashSet
    // to find the existing element in the hash table subtract the prefix sum for each
    //index and check if there is an element in hash table if exist return true
    //corner case : if the prefix sum == number then return true as well
    public static boolean solution(int[] arr, int k) {
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == k) return true;

            if (set.contains(sum - k)) {
                return true;
            }
            set.add(sum);
        }
        return false;
    }
}
