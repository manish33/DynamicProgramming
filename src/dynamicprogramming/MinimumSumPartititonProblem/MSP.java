package dynamicprogramming.MinimumSumPartititonProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MSP {


    public static void main(String[] args)
    {
        // Input: set of items
        int[] S = { 10, 20, 15, 5, 25,33};

        // create a map to store solutions of subproblems
        Map<String, Integer> lookup = new HashMap<>();

//        System.out.println("The minimum difference is "
//                + minPartition(S, S.length - 1, 0, 0, lookup));

        ArrayList<Integer> pop=new  ArrayList<Integer>();
        System.out.println("\n The minimum difference is "
                + minPartitionDyna(S, S.length - 1, 0, 0, lookup,pop));
        System.out.println();

       for(Integer key : pop){
           System.out.print(key+"  ");
       }

    }

    private static int minPartitionDyna(int[] s, int n, int s1, int s2, Map<String, Integer> lookup, ArrayList<Integer> integers) {


        if(n<0){

            return Math.abs(s1-s2);
        }
        String key = n+"|"+s1+"|"+s2;

        if(!lookup.containsKey(key)){
            int include = minPartitionDyna(s, n-1, s1+s[n], s2, lookup, integers);
            int exclude = minPartitionDyna(s, n-1, s1, s2+s[n], lookup, integers);

            if(include<exclude){
                integers.add(n);
            }
            else if(integers.contains(n)) {

                integers.remove(integers.indexOf(n));
            }


            lookup.put(key,Integer.min(include,exclude));
        }

        return  lookup.get(key);

    }

    private static int minPartition(int[] s, int n, int s1, int s2, Map<String, Integer> lookup) {

        if (n<0){
            return Math.abs(s1-s2);
        }


        int include = minPartition(s, n-1, s1+s[n], s2, lookup);
        int exclude = minPartition(s, n-1, s1, s2+s[n], lookup);
        if(include<exclude){
       //     System.out.print(n+" ");
        }
        return  Integer.min(include,exclude);



    }
}
