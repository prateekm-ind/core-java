package learn.recusion;

public class Permutations {
    public void solution(String s, int i) {
        if (i == s.length()) {
            System.out.print(s + " ");
            return;
        }
        for (int j = i; j < s.length(); j++) {
            //swap to get a new string
            String swapNew = swap(i, j, s);
            solution(swapNew, i + 1);
            //swap back to get the original string
        }
    }

    String swap(int i, int j, String s) {
        return null;
    }
}
