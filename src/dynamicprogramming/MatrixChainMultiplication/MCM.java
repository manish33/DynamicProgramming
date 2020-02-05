package dynamicprogramming.MatrixChainMultiplication;

public class MCM {

    static int i=65;

    public static void main(String[] args)
    {
        // Matrix M[i] has dimension dims[i-1] x dims[i] for i = 1..n
        // input is 10 x 30 matrix, 30 x 5 matrix, 5 x 60 matrix
        int[] dims = { 10, 30, 5, 60 };

        System.out.print("Minimum cost is "
                + matrixChainMultiplication(dims));
    }

    private static int matrixChainMultiplication(int[] dims) {

        int temp[][] = new int[dims.length+1][dims.length+1];


        for(int l=0;l<dims.length+1;l++){
            for(int i=0;i<dims.length+1-l;i++){
                int j = i+l;
                 if(i==0 || j>=dims.length){
                 continue;
                 }

               // System.out.println(i+":"+j);

                if(i==j){
                    temp[i][j]=0;
                }
                else{
                    int min= Integer.MAX_VALUE;
                    int index=0;
                    for(int k=i;k<j;k++){
                      //  System.out.println("k"+k);
                        int q = temp[i][k]+temp[k+1][j]+dims[i-1]*dims[j]*dims[k];

                        if(q<min){
                            min=q;
                            index=k;
                        }
                    }
                    temp[i][j]=min;
                    temp[j][i]=index;

                }

//               System.out.print(temp[i][j]+" ");
            }
//            System.out.println();
        }

        printrecursive(temp,1,dims.length-1);

        return temp[1][dims.length-1];
    }

    private static void printrecursive(int[][] temp, int j, int k) {
        if(j==k){

            System.out.print((char)(MCM.i++));
            return;
        }

        System.out.print("(");
        printrecursive(temp,j,temp[k][j]);
        printrecursive(temp,temp[k][j]+1,k);
        System.out.print(")");


    }
}
