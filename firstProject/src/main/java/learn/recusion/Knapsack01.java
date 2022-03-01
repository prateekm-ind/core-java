package learn.recusion;

public class Knapsack01 {

    /*
     *   Idea :  - create a recursion tree
     *           - to find all possible conditions
     *           - Similar to the subset recursion problem
     *           - Consider each weight and corresponding value once,
     *             and ignore once
     * */


    // int w = weight
    // int n = total number of possible element
    // int[] wt = wt array
    // int val = val array
    public int solution(int w, int n, int[] wt, int[] val) {
        if (n == 0 || w == 0) {
            return 0;
        }
        if (wt[n - 1] < w) {
            return solution(w, n - 1, wt, val);
        }
        return Math.max(solution(w, n - 1, wt, val),
                val[n - 1] + solution(w - wt[n - 1], n - 1, wt, val));

    }

    public static void main(String[] args) {

    }
}
