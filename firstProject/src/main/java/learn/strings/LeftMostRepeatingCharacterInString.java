package learn.strings;
import java.util.Arrays;

public class LeftMostRepeatingCharacterInString {
    public static void main(String[] args) {
        System.out.println(efficientSol01("GeksandhGroiskmasd"));
    }

    public static int efficientSol01(String s) {

        Integer arr[] = new Integer[256];
        Arrays.fill(arr, -1);
        int res= Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            if(arr[Integer.valueOf(s.charAt(i))]==-1) arr[Integer.valueOf(s.charAt(i))]=i;
            else {
                res= Math.min(arr[Integer.valueOf(s.charAt(i))], res);
            }
        }
        return res;
    }
}
