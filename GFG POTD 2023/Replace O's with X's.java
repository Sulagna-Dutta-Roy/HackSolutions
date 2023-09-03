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
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static char[][] fill(int n, int m, char a[][])
    {
        int vis[][] = new int[n][m];
        char ans[][] = new char[n][m];
        for(int j = 0; j < m; j++){
            if(vis[0][j] == 0 && a[0][j] == 'O'){
                vis[0][j] = 1;
                dfs(0, j, vis, a, n, m);
            }
        }
        for(int i = 0; i < n; i++){
            if(vis[i][0] == 0 && a[i][0] == 'O'){
                vis[i][0] = 1;
                dfs(i, 0, vis, a, n, m);
            }
        }
        for(int j = 0; j < m; j++){
            if(vis[n - 1][j] == 0 && a[n - 1][j] == 'O'){
                vis[n - 1][j] = 1;
                dfs(n - 1, j, vis, a, n, m);
            }
        }
        for(int i = 0; i < n; i++){
            if(vis[i][m - 1] == 0 && a[i][m - 1] == 'O'){
                vis[i][m - 1] = 1;
                dfs(i, m - 1, vis, a, n, m);
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(vis[i][j] == 1){
                    ans[i][j] = 'O';
                }
                else{
                    ans[i][j] = 'X';
                }
            }
        }
        return ans;
    }
    static void dfs(int row, int col, int vis[][], char a[][], int n, int m){
        // vis[row][col] = 1;
        int delrow[] = {-1, 0, 1, 0};
        int delcol[] = {0, 1, 0, -1};
        for(int i = 0; i < 4; i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && a[nrow][ncol] == 'O'){
                vis[nrow][ncol] = 1;
                dfs(nrow, ncol, vis, a, n, m);
            }
        }
    }
}
