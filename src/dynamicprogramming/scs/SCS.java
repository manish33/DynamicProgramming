package dynamicprogramming.scs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SCS {

	private static int[][] lookup;
	
	private static List<String> scsStrings(String s1, String s2,int i,int j){
		
		if(i==0) {
			return Arrays.asList(s2.substring(0, j));
		}
		else if (j==0) {
			return Arrays.asList(s1.substring(0, i));
		}
		
		if(s1.charAt(i-1)==s2.charAt(j-1)) {
			List<String> scsstr=	scsStrings(s1,s2,i-1,j-1);
			
			List<String> res = new ArrayList<>();
			for(String s:scsstr) {
				res.add(s+s1.charAt(i-1));
			}
			return res;
		}
		
		if(lookup[i-1][j]<lookup[i][j-1]) {
			List<String> scsstr=	scsStrings(s1,s2,i-1,j);
			
			List<String> res = new ArrayList<>();
			for(String s:scsstr) {
				res.add(s+s1.charAt(i-1));
			}
			return res;
		}
		
		if(lookup[i][j-1]<lookup[i-1][j]) {
			List<String> scsstr=	scsStrings(s1,s2,i,j-1);
			
			List<String> res = new ArrayList<>();
			for(String s:scsstr) {
				res.add(s+s2.charAt(j-1));
			}
			return res;
		}
		
		List<String> res = new ArrayList<>();
        List<String> top = scsStrings(s1,s2,i-1,j);
        for(String s:top) {
        	res.add(s+s1.charAt(i-1));
        }
        List<String> left = scsStrings(s1,s2,i,j-1);
        for(String s:left) {
        	res.add(s+s2.charAt(j-1));
        }
		
		return res;
		
		
	}
	
	private static void  scs(String s1, String s2) {
		// TODO Auto-generated method stub

		
		for(int i=0;i<=s1.length();i++) {
			lookup[i][0]=i;
		}
		
		for(int j=0;j<=s2.length();j++) {
			lookup[0][j]=j;
		}
		
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				

				 if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					lookup[i][j] = lookup[i - 1][j - 1] + 1;
				} else {
					lookup[i][j] = 1 + min(lookup[i - 1][j], lookup[i][j - 1]);
				}
			}
		}

		for (int i = 0; i < s1.length() + 1; i++) {
			for (int j = 0; j < s2.length() + 1; j++) {
				System.out.print(lookup[i][j]);
			}
			System.out.println("\n");
		}
		
				

	}

	private static int min(int i, int j) {
		// TODO Auto-generated method stub
		return i < j ? i : j;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String X = "ABCBDAB", Y = "BDCABA";
		// SCSLength(X,Y,X.length(),Y.length());
		lookup = new int[X.length() + 1][Y.length() + 1];
		 scs(X, Y);
		 
		 List<String> sg = scsStrings(X,Y,X.length(),Y.length());
		 
		 Set<String> setofSS = new HashSet<>(sg);
		 
		 System.out.println("--------");
		 for(String s:setofSS) {
			 System.out.println(s);
		 }
		 
		 
	}

}
