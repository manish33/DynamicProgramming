package dynamicprogramming.KnapSack;

import java.util.ArrayList;
import java.util.List;

public class knapsack {


    public static void main(String[] args) {
        int[] v = { 20, 5, 10, 40, 15, 25 };
        int[] w = {  1, 2,  3,  8,  7, 4 };

        // Knapsack capacity
        int W = 10;



        System.out.println("Knapsack value is " +
                knapSack(v, w, v.length - 1, W));
        System.out.println("Knapsack value is " +
                knapSackDynamic(v, w,  W));
    }

    private static int knapSackDynamic(int[] v, int[] w, int W) {

        int temp[][] =new  int[v.length+1][W+1];

        for(int i=0;i<=W;i++){
         temp[0][i]=0;
        }

        for(int i=1;i<=v.length;i++){
            for(int j=0;j<=W;j++){

                if(j<w[i-1]){
                    temp[i][j]=temp[i-1][j];
                }
          else{
              temp[i][j]= Integer.max(temp[i-1][j], v[i-1]+ temp[i-1][j-w[i-1]]);
                }

            }
        }

        for(int i=0;i<=v.length;i++){
            for(int j=0;j<=W;j++){
                System.out.print(temp[i][j]+" ");
            }
            System.out.println();
        }

        List<Integer> knapsackWeight = new ArrayList<Integer>();

        int i = v.length;
        int j = W;
        while (i>0 &&j>0){

            if(temp[i][j]==temp[i-1][j]){
                i--;
            }
            else {
                knapsackWeight.add(w[i-1]);

                j= j- w[i-1];
                i--;
            }

        }


        for(int q: knapsackWeight){
            System.out.println(q);
        }

        return temp[v.length][W];

    }

    private static int knapSack(int[] v, int[] w, int i, int W) {

        if(W<0){
            return Integer.MIN_VALUE;

        }
        if(W==0 || i<0){
            return 0;
        }

        int include= v[i]+knapSack(v,w,i-1,W-w[i]);
        int exclude = knapSack(v,w,i-1,W);

       return  Integer.max(include,exclude);

    }






}
