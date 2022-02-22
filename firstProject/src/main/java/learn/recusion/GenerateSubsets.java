package learn.recusion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GenerateSubsets {

    public void solution(int index, String s, String curr) {
        if (index == s.length()) {
            System.out.print(curr + " ");
            return;
        }
        //System.out.print(curr + " ");
        solution(index + 1, s, curr);
        solution(index + 1, s, curr + s.charAt(index));
    }

    public static void main(String[] args) {
        GenerateSubsets generateSubsets = new GenerateSubsets();

        generateSubsets.solution(0, "ABC", "");

        generateSubsets.countUniqueCharacters(0, "aabbc", "");

        System.out.println("\n======== ******** =========");
        generateSubsets.allSubsetsWithEachCharacterCountK(0, "aabbc", "", 2);

    }

    public void countUniqueCharacters(int index, String s, String curr) {
        if (index == s.length()) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < curr.length(); i++) {
                set.add(curr.charAt(i));
            }
            int size = set.size();
            System.out.print("\n size of set : " + size + " ");
            System.out.print(curr + " ");
            return;
        }
        //System.out.print(curr + " ");
        countUniqueCharacters(index + 1, s, curr);
        countUniqueCharacters(index + 1, s, curr + s.charAt(index));
    }

    public void allSubsetsWithEachCharacterCountK(int index, String s, String curr, int k) {
        if (index == s.length()) {
            if(curr.isBlank()){
                return;
            }
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < curr.length(); i++) {
                if (map.containsKey(curr.charAt(i))) {
                    int p = map.get(curr.charAt(i));
                    map.put(curr.charAt(i), p + 1);
                } else {
                    map.put(curr.charAt(i), 1);
                }
            }
            boolean isValidSet = true;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() != k){
                    isValidSet = false;
                    break;
                }
            }
            if(isValidSet) {
                int size = map.size();
                System.out.print("\n size of set : " + size + " ");
                System.out.print(curr + " ");
            }
            return;
        }
        allSubsetsWithEachCharacterCountK(index + 1, s, curr, k);
        allSubsetsWithEachCharacterCountK(index + 1, s, curr + s.charAt(index), k);
    }

}
