//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            
            int matrix[][] = new int[n][n];
            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++)
                    matrix[i][j] = sc.nextInt();

            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.sumTriangles(matrix,n);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to return sum of upper and lower triangles of a matrix.
    static ArrayList<Integer> sumTriangles(int matrix[][], int n)
    {
        // code here
ArrayList<Integer> a = new ArrayList<>();
        int sum1 = 0, sum2 =0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                sum1 += matrix[i][j];
                sum2 += matrix[n-i-1][n-1-j];
            }
        }
        a.add(sum1);
        a.add(sum2);
        return a; 
    }
}
