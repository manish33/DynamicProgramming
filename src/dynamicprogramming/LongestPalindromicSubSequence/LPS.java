package dynamicprogramming.LongestPalindromicSubSequence;

public class LPS {


    public static void main(String[] args) {

        String X = "ABBDCACB";
        int result = lpalindromicsub(X);
        System.out.println("----------");
    }

    private static int lpalindromicsub(String s1) {
        int temp[][]= new int[s1.length()][s1.length()];

        for(int i=0;i<s1.length();i++){
            temp[i][i]=1;
        }

        for(int i=0;i<s1.length()-1;i++){
            if(s1.charAt(i)==s1.charAt(i+1)){
                temp[i][i+1]=2;
            }
            else{
                temp[i][i+1]=1;
            }
        }

         for(int l=0;l<s1.length();l++){
             for(int i=0;i<s1.length()-l;i++){
                 int j=i+l;
                 if(j>i && j>=2 && j!=i+1){
                     if(s1.charAt(i)==s1.charAt(j)){
                         temp[i][j]= temp[i+1][j-1]+2;
                     }
                     else{
                         temp[i][j]= Math.max(temp[i+1][j],temp[i][j-1]);
                     }
                 }

             }

         }

        for(int i=0;i<s1.length();i++){
            for(int j=0;j<s1.length();j++){
                System.out.print(temp[i][j]);
            }
            System.out.println();
        }

         StringBuilder st= new StringBuilder("");
         int i=0;
         int j=s1.length()-1;
         while(j>i){
             System.out.println("i:"+i+" :j"+ j);
             if(temp[i+1][j-1]+2==(temp[i][j])){


                st.append(s1.charAt(j));
                i++;
                j--;
             }
             else if(temp[i][j-1]>temp[i+1][j]){
                 j--;
             }
             else {
                 i++;
             }
         }
          st.append(s1.charAt(j));
       if(st.length()%2==0){
           st.append(st.reverse());
       }
       else{
           StringBuilder tempx = new StringBuilder(st);
           tempx.reverse();
           st.append(tempx.substring(1));

       }
        System.out.println(st);

           return temp[0][s1.length()-1];

    }


}
