package learn.recusion;

import java.util.List;

public class SubsetWithSumK {
    public void solution(int[] arr, int k, int index, List<Integer> temp) {
        if (index == arr.length - 1) {
            if (temp.isEmpty()) {
                return;
            }
            int sum = temp.stream().mapToInt(temp::get).sum();
            if (sum == k) {
                System.out.print("yes" + " ");
            }
            return;
        }
        solution(arr, k, index + 1, temp);
        temp.add(arr[index]);
        solution(arr, k, index + 1, temp);
    }

    public static void main(String[] args) {
        SubsetWithSumK object = new SubsetWithSumK();
        int[] arr = new int[5];
        arr[0] = 10;
        arr[1] = 5;
        arr[2] = 2;
        arr[3] = 3;
        arr[4] = 6;

        //object.solution(arr, 8, 0, new ArrayList<>());

        System.out.println(object.countSubsetsWithSumK(arr, arr.length, 8));
    }

    public int countSubsetsWithSumK(int arr[], int n, int sum) {
        if (n == 0) {
            return (sum == 0) ? 1 : 0;
        }
        return countSubsetsWithSumK(arr, n - 1, sum) + countSubsetsWithSumK(arr, n - 1, sum - arr[n - 1]);
    }
}
