package learn.strings;

import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) {
        System.out.println(solution("GeeksforGeeks^", "Geeks^ForGeeks"));
        System.out.println(efficientSolution("@Geeks#ForGeeks$", "GeeksForGeeks@#$"));

    }

    public static boolean solution(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int flag = 0;
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                flag = 1;
                break;
            }
        }

        if (flag == 1) return false;
        return true;
    }

    //Idea : Use an integer array of length 256[] to insert all the characters
    //check every of s1 increment the count for each incoming character
    //and decrement the count of every incoming character from s2 string
    //finally after the iterating through the entire string check for the character array
    public static boolean efficientSolution(String s1, String s2) {
        Integer arr[] = new Integer[256];
        Arrays.fill(arr, 0);
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            arr[Integer.valueOf(s1.charAt(i))] += 1;
            arr[Integer.valueOf(s2.charAt(i))] -= 1;
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=0){
                return false;
            }
        }
        return true;
    }
}
