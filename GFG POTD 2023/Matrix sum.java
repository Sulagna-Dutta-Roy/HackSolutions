//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String arr[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(arr[0]);
            int m = Integer.parseInt(arr[1]);
            int mat[][] = new int[n][m];
            for(int i = 0;i < n;i++){
                String a[] = in.readLine().trim().split("\\s+");
                for(int j = 0;j < m;j++)
                    mat[i][j] = Integer.parseInt(a[j]);
            }
            int q = Integer.parseInt(in.readLine());
            int queries[][] = new int[q][3];
            for(int i = 0;i < q;i++){
                String a1[] = in.readLine().trim().split("\\s+");
                for(int j = 0;j < 3;j++)
                    queries[i][j] = Integer.parseInt(a1[j]);
            }
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.matrixSum(n, m, mat, q, queries);
            for(int i = 0;i < q;i++)
                System.out.println(ans.get(i));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static List<Integer> matrixSum(int n, int m, int mat[][], int q, int queries[][])
    {
        ArrayList<Integer> ans = new ArrayList<>();
        int[][] dir1 = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        int[][] dir2 = {{0,2},{1,2},{2,2},{-1,2},{-2,2},{0,-2},{1,-2},{2,-2},{-1,-2},{-2,-2},{2,0},{2,1},{2,-1},{-2,0},{-2,1},{-2,-1}};
        int x, y;
        for(int[] query: queries) {
            int sum = 0;
            if(query[0] == 1) {
                for(int i = 0; i < 8; i++) {
                    x = query[1] + dir1[i][0];
                    y = query[2] + dir1[i][1];
                    if(x >= 0 && x < n && y >= 0 && y < m) sum += mat[x][y];
                }
            }else {
                for(int i = 0; i < 16; i++) {
                    x = query[1] + dir2[i][0];
                    y = query[2] + dir2[i][1];
                    if(x >= 0 && x < n && y >= 0 && y < m) sum += mat[x][y];
                }
            }
            ans.add(sum);
        }
        return ans;
    }
}
