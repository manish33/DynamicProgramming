package dynamicprogramming.MinimumCostToReachEndOfMatrix;

public class MCTREO {

    public static void main(String[] args)
    {
        int[][] cost =
                {
                        { 4, 7, 8, 6, 4 },
                        { 6, 7, 3, 9, 2 },
                        { 3, 8, 1, 2, 4 },
                        { 7, 1, 7, 3, 7 },
                        { 2, 9, 8, 9, 3 }
                };

        System.out.print("The minimum cost is " + findMinCost(cost));
    }

    private static int findMinCost(int[][] cost) {
        int temp[][] =  new int[cost.length][cost[0].length];

        temp[0][0]=cost[0][0];

        for(int i=1;i<cost.length;i++){
            temp[i][0]=temp[i-1][0]+cost[i][0];

        }

        for(int j=1;j<cost.length;j++){
            temp[0][j]=temp[0][j-1]+cost[0][j];

        }

        for(int i=1;i<cost.length;i++){
            for(int j=1;j<cost.length;j++){
                temp[i][j]= Integer.min(temp[i-1][j],temp[i][j-1])+cost[i][j];
            }
        }

        for(int i=0;i<cost.length;i++){
            for(int j=0;j<cost.length;j++){
                System.out.print(temp[i][j]+"  ");
            }
            System.out.println();
        }

return  2;
    }

}
