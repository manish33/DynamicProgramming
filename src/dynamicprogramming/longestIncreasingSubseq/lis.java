package dynamicprogramming.longestIncreasingSubseq;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lis {

    public static void main(String[] args) {
        int[] arr = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };

        findLIS(arr);

    }

    private static void findLIS(int[] arr) {
        List<List<Integer>> LIS = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            LIS.add(i, new ArrayList<>());
        }


        for(int i=0;i<arr.length;i++){
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i] && LIS.get(j).size()>LIS.get(i).size()){

                    LIS.set(i,new ArrayList<>(LIS.get(j)));
                }
            }
            LIS.get(i).add(arr[i]);
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
