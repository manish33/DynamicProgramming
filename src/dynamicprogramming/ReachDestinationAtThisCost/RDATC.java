package dynamicprogramming.ReachDestinationAtThisCost;

import java.util.HashMap;
import java.util.Map;

public class RDATC {




    public static void main(String[] args)
    {
        int[][] mat =
                {
                        { 4, 7, 1, 6 },
                        { 5, 7, 3, 9 },
                        { 3, 2, 1, 2 },
                        { 7, 1, 6, 3 }
                };

        int cost = 25;
        // create a map to store solutions of subproblems
        Map<String, Integer> lookup = new HashMap<>();


        
        

        System.out.println("Total paths with cost " + cost + " are " +
                countPaths(mat, mat.length-1, mat[0].length-1, cost, lookup));

        for(String key: lookup.keySet()){
            lookup.get(key);
        }
    }

    private static int countPaths(int[][] mat, int i, int j, int cost, Map<String, Integer> lookup) {

        if(cost==0){
            return  0;
        }
        else if(i==0 && j==0){
            if(mat[i][j]-cost==0){
                return 1;
            }
            else{
                return  0;
            }
        }
        String key = i+"|"+j+"|"+cost;

        if(!lookup.containsKey(key)){



        if(i==0 && j>0){
            lookup.put(key,countPaths(mat, i, j-1, cost-mat[i][j], lookup));
        }
        else if(j==0 && i>0){
            lookup.put(key,countPaths(mat, i-1, j, cost-mat[i][j], lookup));
        }
        else{
            lookup.put(key,countPaths(mat, i, j-1, cost-mat[i][j], lookup)+countPaths(mat, i-1, j, cost-mat[i][j], lookup));
        }

        }

        return  lookup.get(key);

    }
}
