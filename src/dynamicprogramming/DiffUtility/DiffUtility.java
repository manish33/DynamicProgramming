package dynamicprogramming.DiffUtility;

import java.util.List;

public class DiffUtility {


    public static void main(String[] args) {
        String X = "ABCDFGHJQZ";
        String Y = "ABCDEFGIJKRXYZ";
        lcdDynaAllLcs(X,Y);
    }



    private static void lcdDynaAllLcs(String s1,String s2) {

        int[][] temp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i < s1.length() + 1; i++) {
            temp[i][0] = 0;
        }

        for (int j = 0; j < s2.length() + 1; j++) {
            temp[0][j] = 0;
        }

        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    temp[i][j] = temp[i - 1][j - 1] + 1;
                } else {
                    temp[i][j] = Math.max(temp[i - 1][j], temp[i][j - 1]);
                }

            }
        }


        for (int i = 0; i < s1.length() + 1; i++) {
            for (int j = 0; j < s2.length() + 1; j++) {

                System.out.print(temp[i][j] + "  ");

            }
            System.out.println();
        }

        printDiff(s1,s2,s1.length(),s2.length(),temp);


    }

    private static void printDiff(String s1, String s2, int i, int j, int[][] temp) {

        if(i>0 && j>0 && s1.charAt(i-1)==s2.charAt(j-1)){
            printDiff(s1,s2,i-1,j-1,temp);
            System.out.print(" "+s1.charAt(i-1));
        }
        else if(i>0 &&(j==0 || temp[i-1][j]> temp[i][j-1])){
            printDiff(s1,s2,i-1,j,temp);
            System.out.print(" -"+s1.charAt(i-1));
        }
        else if(j>0 &&(i==0 || temp[i-1][j] <= temp[i][j-1])){
            printDiff(s1,s2,i,j-1,temp);
            System.out.print(" +"+s2.charAt(j-1));
        }
    }
}
