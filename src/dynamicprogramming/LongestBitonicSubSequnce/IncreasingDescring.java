package dynamicprogramming.LongestBitonicSubSequnce;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class IncreasingDescring {
    public static void main(String[] args) {
        int[] arr = { 4, 2, 5, 9, 7, 6, 10, 3, 1 };

        findLIS(arr);
    }

    private static void findLIS(int[] arr) {
        List<List<Integer>> LIS = new ArrayList<>();
        List<List<Integer>> LISRev = new ArrayList<>();
        int[] arr2 =new int[arr.length];
        int k=0;
        for (int i=arr.length-1; i>=0;i--){
            arr2[k]=arr[i];
            k++;
        }





        for (int i = 0; i < arr.length; i++) {
            LIS.add(i, new ArrayList<>());
            LISRev.add(i, new ArrayList<>());
        }


        for(int i=0;i<arr.length;i++){
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i] && LIS.get(j).size()>LIS.get(i).size()){

                    LIS.set(i,new ArrayList<>(LIS.get(j)));
                }
            }
            LIS.get(i).add(arr[i]);
        }

        for(int i=arr.length-1;i>=0;i--){
            for(int j=arr.length-1;j>i;j--){
                if(arr[j]<arr[i] && LISRev.get(j).size()>LISRev.get(i).size()){

                    LISRev.set(i,new ArrayList<>(LISRev.get(j)));
                }
            }
            LISRev.get(i).add(arr[i]);
        }

        for(int m =0 ; m<LIS.size(); m++){
            for(int i : LIS.get(m)){
                System.out.print(i+",");
            }
            System.out.println();
        }
        System.out.println("-------");
      for(int m =0 ; m<LISRev.size(); m++){
          for(int i : LISRev.get(m)){
              System.out.print(i+",");
          }
          System.out.println();
      }



        int max=LIS.get(0).size()+ LISRev.get(0).size();
        int maxindex=0;

        for(int i=1;i<LIS.size();i++){
            if(LIS.get(i).size()+ LISRev.get(i).size()>max){
                max =LIS.get(i).size()+LISRev.get(i).size();
                maxindex=i;
            }
        }

      //  LIS.get(maxindex).addAll(LISRev.get(maxindex));

        System.out.println(max);
        for(int i : LIS.get(maxindex)){
            System.out.print(i+",");
        }
        for(int i=LISRev.get(maxindex).size()-2;i>=0;i--){
            System.out.print(LISRev.get(maxindex).get(i)+",");
        }

    }

}
