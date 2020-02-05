package dynamicprogramming.longestIncreasingSeqwithMAXSUM;

import java.util.ArrayList;
import java.util.List;

public class MaxSum {

    public static void main(String[] args) {
        int[] A = { 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11 };
        findLIS(A);
    }

    private static void findLIS(int[] arr) {
        List<List<Integer>> LIS = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            LIS.add(i, new ArrayList<>());
        }


        int sum[] = new int[arr.length];
        sum[0]=arr[0];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i] && sum[j]>sum[i]){

                    LIS.set(i,new ArrayList<>(LIS.get(j)));
                    sum[i]=sum[j];
                }
            }
            LIS.get(i).add(arr[i]);
            sum[i]+=arr[i];
        }

        int max=LIS.get(0).size();
        int maxindex=0;

        for(int i=1;i<LIS.size();i++){
            if(LIS.get(i).size()>max){
                max =LIS.get(i).size();
                maxindex=i;
            }
        }

        System.out.println(max);
        for(int i : LIS.get(maxindex)){
            System.out.print(i+",");
        }

    }

}

