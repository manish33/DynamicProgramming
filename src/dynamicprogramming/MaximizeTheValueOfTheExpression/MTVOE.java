package dynamicprogramming.MaximizeTheValueOfTheExpression;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MTVOE {

    // https://www.techiedelight.com/maximize-value-of-the-expression/

    public static void main(String[] args)
    {
        int[] A = { 3, 9, 10, 1, 30, 40 };

        // array should have atleast 4 elements
        if (A.length >= 4) {
            System.out.println(maximizeExpression(A));
        }
    }

    private static int maximizeExpression(int[] a) {

        //l1 store value of A[s]
        //l2 store value of A[s]-A[r]
        //l3 store value of A[s]-A[r]+A[q]
        //l4 store valye of A[s]-A[r]+A[q]-A[p]
        int l1[] = new int[a.length+1];
        Arrays.fill(l1,Integer.MIN_VALUE);
        int l2[] = new int[a.length];
        Arrays.fill(l2,Integer.MIN_VALUE);
        int l3[] = new int[a.length-1];
        Arrays.fill(l3,Integer.MIN_VALUE);
        int l4[] = new int[a.length-2];
        Arrays.fill(l4,Integer.MIN_VALUE);

        for(int i=a.length-1;i>=0;i--){
            l1[i]= Integer.max(l1[i+1],a[i]);
        }
        for(int i=a.length-2;i>=0;i--){
            l2[i]= Integer.max(l2[i+1],l1[i]-a[i]);
        }
        for(int i=a.length-3;i>=0;i--){
            l3[i]= Integer.max(l3[i+1],l2[i]+a[i]);
        }
        for(int i=a.length-4;i>=0;i--){
            l4[i]= Integer.max(l4[i+1],l3[i]-a[i]);
        }

return  l4[0];
    }

}
