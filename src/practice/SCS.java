package practice;

import java.util.ArrayList;

public class SCS {

	public static void main(String[] args) {
		String X = "ABCBDAB";
		String Y = "BDCABA";

		ArrayList<String> scsstrings;
		int scslength = SCSlengthRecursilve(X,Y);
	}

	private static int SCSlengthRecursilve(String s1, String s2) {
		
		int temp[][] = new int[s1.length()+1][s2.length()+1];

		for(int i=0;i<s1.length()+1;i++){
			temp[i][0]=i;
		}
		for(int i=0;i<s2.length()+1;i++){
			temp[0][i]=i;
		}

      for(int i=1;i<s1.length()+1;i++){
      	for(int j=1;j<s2.length()+1;j++){
      		if(s1.charAt(i-1)==s2.charAt(j-1)){
      			temp[i][j]=1+temp[i-1][j-1];
			}
      		else {
      			temp[i][j]= Math.min(temp[i-1][j],temp[i][j-1])+1;
			}
		}
	  }
		for(int i=0;i<s1.length()+1;i++){
			for(int j=0;j<s2.length()+1;j++){
                  System.out.print(temp[i][j]);
          }
			System.out.println();
		}

		int i= s1.length();
		int j= s2.length();

		String sb = getScsStrings(s1,s2,s1.length(),s2.length(),temp);

		System.out.println(sb);
		return 0;
	}


	private static String getScsStrings(String s1, String s2, int i, int j,int[][] temp) {

		if(i==0){
			return s2.substring(0,j);
		}
		else if(j==0){
			return s1.substring(0,i);
		}
		else if(s1.charAt(i-1)==s2.charAt(j-1)){
			return  getScsStrings(s1,s2,i-1,j-1,temp)+s1.charAt(i-1);
		}
		else if(temp[i-1][j]<temp[i][j-1]){
			return getScsStrings(s1, s2, i-1, j, temp)+s1.charAt(i-1);
		}
		else{
            return getScsStrings(s1, s2, i, j-1, temp)+s2.charAt(j-1);
		}
	}
}
