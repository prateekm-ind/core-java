package sorting;

/*
*   - Stable sorting algorithm
*   - in the first iteration the biggest element will be transferred to the end
*   - run the loop from n-1, n-2, n-3, n-4,...1, 0.
*
* */
public class BubbleSort {
    public void bubbleSort(int [] arr){
        for(int i=0;i< arr.length-1; i++){
            for(int j=0; j<arr.length-i-1; j++){
                if(arr[j]>arr[j+1]){
                    swap(arr, j);
//                   System.out.println("inside swap");
//                    int temp = a[j];
//                    a[j]= a[j+1];
//                    a[j+1]=temp;
                }
            }
        }

        for(int i=0;i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }

    private void swap(int[] arr, int j) {
        int temp = arr[j];
        arr[j]= arr[j+1];
        arr[j+1]=temp;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,9,8,11,17,5,4};

        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(arr);
    }
}
