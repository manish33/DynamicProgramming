package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lcs {
	
	
	
	
	public static void main(String[] args) {
//		 String s1 = "AGGTAB";
//		 String s2 = "GXTXAYB";
		// String X = "ABCBDAB", Y = "BDCABA";
		String X = "ABCDFGHJQZ";
		String Y = "ABCDEFGIJKRXYZ";
//		String X = "ATACTCGGA";
//		String Y = X;


		 List<String> links3= new ArrayList<String>();
		 StringBuilder s3= new StringBuilder();
	//	 int result= lcsRecursive(0,0,s1,s2,s3);
	//	 int result2= lcsDyna(s1,s2,s3);
        int result3 = lcdDynaAllLcs(X,Y,links3);	 
		 System.out.println(result3);
		 System.out.println(s3);
	}

	private static int lcdDynaAllLcs(String s1,String s2, List<String> links3) {
		int[][] temp= new int[s1.length()+1][s2.length()+1];
	       
	       for(int i=0;i<s1.length()+1;i++){
	    	   temp[i][0]=0;
	       }
	       
	       for(int j=0;j<s2.length()+1;j++){
	    	   temp[0][j]=0;
	       }
	       
	       for(int i=1;i<s1.length()+1;i++) {
	    	   for(int j=1; j<s2.length()+1;j++) {
	    		   
	    		   if(s1.charAt(i-1)==s2.charAt(j-1)) {
	    			   temp[i][j]=temp[i-1][j-1]+1;
	    		   }
	    		   else {
	    			   temp[i][j]= Math.max(temp[i-1][j], temp[i][j-1]);
	    		   }
	    		   
	    	   }
	       }
	       
	       
	       for(int i=0;i<s1.length()+1;i++) {
	    	   for(int j=0; j<s2.length()+1;j++) {
	    		   
	    		System.out.print(temp[i][j]+"  ");
	    		   
	    	   }
	    	   System.out.println();
	       }
	       
	        links3 = addLCSinTheList(s1,s2,s1.length(),s2.length(),temp);
	        
	        for(String s: links3) {
	        	System.out.println(s);
	        }
	       
	       return temp[s1.length()][s2.length()];
	}
         private static List<String> addLCSinTheList(String s1, String s2, int i, int j,int[][] temp) {
	
        	 if(i==0 || j==0) {
        		 return new ArrayList<String>(Arrays.asList(""));
        	 }
        	 else if(s1.charAt(i-1)==s2.charAt(j-1)) {
        		 ArrayList<String> t2 = new ArrayList<String>();
        		 t2 = (ArrayList<String>) addLCSinTheList(s1,s2,i-1,j-1,temp);
        		 
        		 for(int q=0; q<t2.size();q++) {
        			 t2.set(q,t2.get(q)+s1.charAt(i-1));
        		 }
        		 return t2;
        		 
        	 }
        	 else if(temp[i-1][j]>temp[i][j-1]) {
        		 return addLCSinTheList(s1, s2, i-1, j, temp);
        	 }
        	 else if(temp[i-1][j]<temp[i][j-1]) {
        		 return addLCSinTheList(s1, s2, i, j-1, temp);
        	 }
        	 ArrayList<String> top =  (ArrayList<String>) addLCSinTheList(s1, s2, i-1, j, temp);
        	 ArrayList<String> left =  (ArrayList<String>) addLCSinTheList(s1, s2, i, j-1, temp);
        	 
	           top.addAll(left);
	           return top;
		
	}

	/////////////////////////////////////////////////////////////////////////
	private static int lcsDyna(String s1, String s2, StringBuilder s3) {
       int[][] temp= new int[s1.length()+1][s2.length()+1];
       
       for(int i=0;i<s1.length()+1;i++){
    	   temp[i][0]=0;
       }
       
       for(int j=0;j<s2.length()+1;j++){
    	   temp[0][j]=0;
       }
       
       for(int i=1;i<s1.length()+1;i++) {
    	   for(int j=1; j<s2.length()+1;j++) {
    		   
    		   if(s1.charAt(i-1)==s2.charAt(j-1)) {
    			   temp[i][j]=temp[i-1][j-1]+1;
    		   }
    		   else {
    			   temp[i][j]= Math.max(temp[i-1][j], temp[i][j-1]);
    		   }
    		   
    	   }
       }
       
       
       for(int i=0;i<s1.length()+1;i++) {
    	   for(int j=0; j<s2.length()+1;j++) {
    		   
    		System.out.print(temp[i][j]);
    		   
    	   }
    	   System.out.println();
       }
       
       
       int i=s1.length();
       int j= s2.length();
       
       while(true) {
    	   if(i==0||j==0) {
    		   break;
    	   }
    	   else if(s1.charAt(i-1)==s2.charAt(j-1)) {
    		  s3.append(s1.charAt(i-1));
    		   i--;
    		   j--;
    	   }
    	   else if(temp[i-1][j]>temp[i][j-1]) {
    		   i--;
    	   }
    	   else {
    		   j--;
    	   }
    	   
       }
       s3 = s3.reverse();
       
      return temp[s1.length()][s2.length()];
		
	}
/////////////////////////////////////////////////////////////////////////
	private static int lcsRecursive(int i, int j,String s1, String s2,StringBuilder s3) {
		
		if(i==(s1.length())|| j==(s2.length())) {
			return 0;
		}
		else if(s1.charAt(i)==s2.charAt(j)) {
			return 1+lcsRecursive(i+1,j+1,s1,s2,s3);
			
		}
		else {
			return Math.max(lcsRecursive(i+1,j,s1,s2,s3), lcsRecursive(i,j+1,s1,s2,s3));
		}
		
		
	}

}
