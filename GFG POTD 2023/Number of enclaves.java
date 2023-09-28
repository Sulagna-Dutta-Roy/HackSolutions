//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                s = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution ob = new Solution();
            out.println(ob.numberOfEnclaves(a));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int count=0;
    int numberOfEnclaves(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        boolean vis[][] = new boolean[r][c];
        for(int i = 0; i<r;i++){
            if(i ==0 || i == r-1){
                for(int j =0 ; j< c;j++){
                    if(!vis[i][j] && grid[i][j] == 1){
                        dfs(i,j,grid,vis,false);
                    }
                }
            }
            if(i>0 && i<=r-1){
                if(!vis[i][0] && grid[i][0] == 1)
                    dfs(i,0,grid,vis,false);
                if(!vis[i][c-1] && grid[i][c-1] == 1)
                    dfs(i,c-1,grid,vis,false);
            }
        }
        for(int i = 0; i<r;i++){
            for(int j =0 ; j< c;j++){
                if(!vis[i][j] && grid[i][j] == 1){
                    dfs(i,j,grid,vis,true);
                }
            }
        }
        return count;
    }
    void dfs(int i, int j,int[][] grid,boolean vis[][],boolean indicator ){
        int r = grid.length;
        int c = grid[0].length;
        vis[i][j] = true;
        if(indicator){
            count++;
            if(i-1>=0 && !vis[i-1][j] && grid[i-1][j]==1)
                dfs(i-1,j,grid,vis,indicator);
            if(i+1>r && !vis[i+1][j] && grid[i+1][j]==1)
                dfs(i+1,j,grid,vis,indicator);
            if(j-1>=0 && !vis[i][j-1] && grid[i][j-1]==1)
                dfs(i,j-1,grid,vis,indicator);
            if(j+1<c && !vis[i][j+1] && grid[i][j+1]==1)
                dfs(i,j+1,grid,vis,indicator);
        }else{
            if(i-1>=0 && !vis[i-1][j] && grid[i-1][j]==1)
                dfs(i-1,j,grid,vis,indicator);
                
            if(i+1<r && !vis[i+1][j] && grid[i+1][j]==1)
                dfs(i+1,j,grid,vis,indicator);
                
            if(j-1>=0 && !vis[i][j-1] && grid[i][j-1]==1)
                dfs(i,j-1,grid,vis,indicator);
                
            if(j+1<c && !vis[i][j+1] && grid[i][j+1]==1)
                dfs(i,j+1,grid,vis,indicator);
        }
    }
}
