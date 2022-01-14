package learn.matrix;

public class Matrix {
    public static void main(String[] args) {

        //Array of two objects
        //two individual objects are added into the array
        int arr[][] = {{1, 2, 3}, {4, 5, 6}};
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }

        jaggedArray();
        int arrp[][] = new int[3][4];
        iterateInSnakePattern(arr);
    }

    //variable length at every row for the 2D-Array
    public static void jaggedArray() {
        int m = 3;
        int arr[][] = new int[m][];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[i + 1];
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = i + 1;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }

    //Idea: Iterate over the 2D-array such that odd number row will iterate left->right
    // and the even number rows will iterate over the arrays from right->left
    public static void iterateInSnakePattern(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < arr[i].length; i++) {
                    arr[i][j] = j;
                    System.out.print(arr[i][j] + " ");
                }
            } else {
                for (int j = arr[i].length - 1; j >= 0; i++) {
                    arr[i][j] = j;
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println("");
        }
    }

    //Idea : print the boundary elements
    // handle two corner cases namely : 1 2 3 4 - only rows
    // handle case of single column
    //1
    //2
    //3
    //4

    public void matrixBoundaryTraversal(int mat[][]){
        if(mat.length==1){
            for(int i=0; i<mat[0].length; i++){
                System.out.print(mat[0][i]+" ");
            }
        } else if( mat[0].length==1) {
            for (int i = 0; i < mat.length; i++) {
                System.out.print(mat[i][0] + " ");
            }
        } else {
            for(int i=0; i<mat[0].length; i++){

            }
        }
    }


}
