package learn.recusion;

public class RopeCuttingProblem {
    public int solution(int n, int a, int b, int c) {
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return -1;
        }

        int res = Math.max(solution(n - a, a, b, c),
                Math.max(solution(n - b, a, b, c),
                        solution(n - c, a, b, c)));

        //to handle corner case of
        // n=9, a=2, b=2, c=2
        if (res == -1) {
            return -1;
        }

        return res + 1;
    }

    public static void main(String[] args) {
        RopeCuttingProblem ropeCuttingProblem = new RopeCuttingProblem();
        System.out.println(ropeCuttingProblem.solution(23, 12, 11, 9));
    }
}
