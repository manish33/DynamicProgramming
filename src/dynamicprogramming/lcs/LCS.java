package dynamicprogramming.lcs;

public class LCS {
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String s1 = "AGGTAB";
		 String s2 = "GXTXAYB";


		 String result = lcs(s1,s2);
		 System.out.println(result);
		 

	}

	private static String lcs(String s1, String s2) {
		// TODO Auto-generated method stub
		
		    int [][] lookup=new int[s1.length()+1][s2.length()+1];
		    for(int i=0;i<=s1.length();i++) {
		    	for(int j=0;j<=s2.length();j++) {
		    		if(i==0 | j==0) {
		    			lookup[i][j]=0;
		    		}
		    		else if(s1.charAt(i-1)==s2.charAt(j-1)) {
		    			lookup[i][j]=lookup[i-1][j-1]+1;
		    		}
		    		else {
		    			lookup[i][j] = max(lookup[i-1][j],lookup[i][j-1]);
		    		}
		    	}
		    }
		    
		    for(int i=0;i<s1.length()+1;i++) {
		    	for(int j=0;j<s2.length()+1;j++) {
		    		System.out.print(lookup[i][j]);
		    	}
		    	System.out.println("\n");
		    	}
		    
		    
		int lengthSub = lookup[s1.length()][s2.length()];
		System.out.println(lengthSub);
		StringBuilder st = new StringBuilder();
		
		int j = s2.length();
		int i = s1.length();
		while(i>0 && j>0) {
			
			if(s1.charAt(i-1)==s2.charAt(j-1)) {
				st.append(s1.charAt(i-1));
				i--;j--;
			}
			else if(lookup[i-1][j]>lookup[i][j-1]) {
				i--;
			}
			else {
				j--;
			}
			
			
		}
		
		
		return st.reverse().toString();
		
	}

	private static int max(int i, int j) {
		
		return i>j?i:j;
	}

}
