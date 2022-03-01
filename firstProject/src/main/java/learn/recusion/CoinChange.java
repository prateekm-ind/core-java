package learn.recusion;

public class CoinChange {
    public static void main(String[] args) {

    }

    //infinite supply of coins
    public int solution(int[] coins, int sum, int n) {
        if (sum == 0 || n == 0) {
            return 0;
        }
        int res = solution(coins, sum - coins[n - 1], n - 1);
        if (coins[n - 1] <= sum) {
            res = res + solution(coins, sum, n - 1);
        }
        return res;
    }
}
