package learn.arrays;

import java.util.Comparator;

public class MinimumNumberOfOperationsToMoveBall {
    public static int[] minOperations(String boxes) {
        final int n=boxes.length();
        int[] tar= new int[n];
        int count=0;
        if(boxes.charAt(0)=='1'){
            count=1;
        }
        tar[0]=0;
        for(int i=1;i<n;i++){
            if(boxes.charAt(i-1)=='1'){
                tar[i]=count+tar[i-1];
            }
            if(boxes.charAt(i-1)=='0' && tar[i-1]!=0){
                tar[i]=tar[i-1]+1;
            }
            if(boxes.charAt(i-1)=='0' && tar[i-1]==0){
                tar[i]=tar[i-1];
            }
            if(boxes.charAt(i)=='1') {
                count++;
            }
        }
        count=0;
        if(boxes.charAt(n-1)=='1'){
            count=1;
        }
        int[] tar2= new int[n];
        for(int i=n-2;i>=0;i--){
            if(boxes.charAt(i+1)=='1'){
                tar2[i]=count+tar2[i+1];
            }
            if(boxes.charAt(i+1)=='0' && tar2[i+1]!=0){
                tar2[i]=tar2[i+1]+1;
            }
            if(boxes.charAt(i+1)=='0' && tar[i-1]==0){
                tar2[i]=tar2[i+1];
            }
            if(boxes.charAt(i)=='1') {
                count++;
            }
        }

        for(int i=0;i<n;i++){
            tar[i]+=tar2[i];
        }

        return tar;
    }

    public static void main(String[] args) {
        System.out.println(minOperations("001011").toString());
    }
}
