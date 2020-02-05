package dynamicprogramming.subSetSumProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSetSum {


    public static void main(String[] args) {
      int[] A = { 7, 3, 2, 5, 8 };


        int sum = 18;

        if (subsetSum(A, A.length - 1, sum)) {
            System.out.print("Yes");
        }
        else {
            System.out.print("No");
        }

        if (subsetSumDynamic(A, sum)) {
            System.out.print("Yes");
        }
        else {
            System.out.print("No");
        }
    }

    private static boolean subsetSumDynamic(int[] A, int sum) {
        int n = A.length;
        boolean[][] T = new boolean[n+1][sum+1];


       // temp[0][0]=true;

        for (int i = 0; i <= n; i++) {
            T[i][0] = true;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(A[i-1] > j){
                    T[i][j]=T[i-1][j];
                }
                else{
                    T[i][j]= T[i-1][j] || T[i-1][j-A[i-1]];
                }
            }
        }
        List<Integer> sumvals = new ArrayList<Integer>();

        int i=n;
        int j= sum;
        while(i>0&&j>0){
            if(T[i][j]==T[i-1][j]){
                i--;
            }
            else{
                sumvals.add(A[i-1]);

                j=j-A[i-1];
                i--;

            }
        }



        System.out.println();
        for (int p: sumvals){
            System.out.print(p+" ");
        }
        System.out.println();


        for(int p=0;p<=n;p++) {
            for (int r = 0; r <= sum; r++) {
                System.out.print(T[p][r]+" ");
            }
            System.out.println();
        }


        return T[n][sum];
    }

    private static boolean subsetSum(int[] a, int i, int sum) {

        if(sum==0){
            return true;
        }

        if(sum<0 || i<0){
            return false;
        }

        boolean include = subsetSum(a,i-1,sum-a[i]);
        boolean exlude = subsetSum(a,i-1,sum);

        return include || exlude;
    }

}

