package dynamicprogramming.LongestSequenceMatrix;

import java.util.HashMap;
import java.util.Map;

public class LSM {

    static boolean  isvalid(int i, int j , int m , int n){

        return (i>=0 && i<m && j>=0 && j<n);

    }

    public  static  String longestSeq(int[][] M,int i, int j,int m, int n){


        if(!isvalid(i,j,m,n)){
            return null;
        }


        String  path = null;

        if(i-1>0 && M[i][j]+1==M[i-1][j]){
            path =  longestSeq(M,i-1,j,m,n);
        }

        if(j-1>0 && M[i][j]+1==M[i][j-1]){
            path =  longestSeq(M,i,j-1,m,n);
        }
        if(j+1<n && M[i][j]+1==M[i][j+1]){
            path = longestSeq(M,i,j+1,m,n);
        }
        if(i+1<m && M[i][j]+1==M[i+1][j]){
            path= longestSeq(M,i+1,j,m,n);
        }


        return  path!=null? (M[i][j]+"-"+path): String.valueOf(M[i][j]);




    }

    public  static  String longestSeqDyna(int[][] M,int i, int j,int m, int n, Map<String ,String> lookup){


        if(!isvalid(i,j,m,n)){
            return null;
        }

        String key= i+"|"+j;
        if(!lookup.containsKey(key)){



        String  path = null;

        if(i-1>0 && M[i][j]+1==M[i-1][j]){
            path =  longestSeq(M,i-1,j,m,n);
        }

        if(j-1>0 && M[i][j]+1==M[i][j-1]){
            path =  longestSeq(M,i,j-1,m,n);
        }
        if(j+1<n && M[i][j]+1==M[i][j+1]){
            path = longestSeq(M,i,j+1,m,n);
        }
        if(i+1<m && M[i][j]+1==M[i+1][j]){
            path= longestSeq(M,i+1,j,m,n);
        }


        lookup.put(key,path!=null? (M[i][j]+"-"+path): String.valueOf(M[i][j]));
        }

        return  lookup.get(key);

    }

    public static void main(String[] args) {



    int M[][] =
            {
                    { 10, 13, 14, 21, 23 },
                    { 11,  9, 22,  2,  3 },
                    { 12,  8,  1,  5,  4 },
                    { 15, 24,  7,  6, 20 },
                    { 16, 17, 18, 19, 25 }
            };

    Map<String,String> lookup = new HashMap<String, String>();

    long maxlen =0;
    String res="";
       for(int i=0;i<M.length;i++){
           for(int j=0;j<M[0].length;j++){
                 String temp = longestSeqDyna(M,i,j,M.length,M[0].length,lookup);

               long size = temp.chars().filter(ch -> ch == '-').count();

                 if(size>maxlen){
                     maxlen=size;
                     res=temp;
                 }

           }
       }

        System.out.println(res);




    }
}
