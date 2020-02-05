package dynamicprogramming.LcString;

public class LcString {




    public static void main(String[] args) {
        String X = "ABC";
        String Y = "BABA";
        int m = X.length(), n = Y.length();
        int length = lcstring(X,Y,m,n);

    }

    private static int lcstring(String s1, String s2, int m, int n) {
        int[][] temp = new int[m+1][n+1];

        for(int i=0;i<m+1;i++){
            temp[i][0]=0;
         }

        for(int j=0;j<n+1;j++){
            temp[0][j]=0;
        }

        int maxlength = 0;
        int lastindex= -1;
        for(int i=1; i<m+1;i++){
            for(int j=1;j<n+1;j++){

             if (s1.charAt(i-1)==s2.charAt(j-1)){
                    temp[i][j]=temp[i-1][j-1]+1;
                 System.out.println(temp[i][j]);
                    if(temp[i][j]>maxlength){
                        maxlength=temp[i][j];
                        lastindex=i;
                    }
                    else{
                        temp[i][j]=0;
                    }
                }

            }
        }

        System.out.println(s1.substring(lastindex-maxlength,lastindex));

        return maxlength;

    }
}
