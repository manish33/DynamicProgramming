package dynamicprogramming.largestSquareWith1s;

import java.util.ArrayList;
import java.util.List;

public class LargestSquare {

    public static void main(String[] args)
    {
        // input boolean matrix
        int mat[][] =
                {
                        { 0, 0, 1, 0, 1, 1 },
                        { 0, 1, 1, 1, 0, 0 },
                        { 0, 0, 1, 1, 1, 1 },
                        { 1, 1, 0, 1, 1, 1 },
                        { 1, 1, 1, 1, 1, 1 },
                        { 1, 1, 0, 1, 1, 1 },
                        { 1, 0, 1, 1, 1, 1 },
                        { 1, 1, 1, 0, 1, 1 }
                };

        System.out.print("The size of largest square sub-matrix of 1's is " +
                findLargestSquare(mat));

        List<Integer> a = new ArrayList<>();
        a.add(0);


        findLargestSquareRecursive(mat,a,mat.length-1,mat[0].length-1);
        System.out.println();
        System.out.print("The size of largest square sub-matrix of 1's is " +
              a.get(0) );


    }

    private static int findLargestSquareRecursive(int[][] mat, List<Integer> a,int i, int j) {

        if(i==0 || j==0){
            a.set(0, Integer.max(a.get(0),mat[0][0]));
            return  mat[i][j];
        }

        int top = findLargestSquareRecursive(mat,a,i-1,j);
        int left = findLargestSquareRecursive(mat,a,i,j-1);
        int topLeft = findLargestSquareRecursive(mat,a,i-1,j-1);

        int size=0;
        if(mat[i][j]!=0){
            size = 1+ Integer.min(Integer.min(top,left),topLeft);
        }

        if(size> a.get(0)){
            a.set(0,size);
        }

        return  size;

    }


    private static int findLargestSquare(int[][] mat) {

        int temp[][] = new int[mat.length][mat[0].length];
        int max =0 ;

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (i == 0 || j == 0) {
                    temp[i][j] = mat[i][j];
                } else {
                    temp[i][j] = mat[i][j];

                    if (temp[i][j] != 0) {
                        temp[i][j] = 1+Integer.min(Integer.min(temp[i - 1][j], temp[i][j - 1]), temp[i - 1][j - 1]);
                    }
                    if(temp[i][j]>max){
                        max=temp[i][j];
                    }


                }
            }
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(temp[i][j]);

            }
            System.out.println();
        }

return max;
    }

}
