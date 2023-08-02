//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {
	public int[] shortestPath(int N,int M, int[][] edges) {
	   int dis[]=new int [N];
		for(int i=0;i<N;i++){
		    dis[i]=Integer.MAX_VALUE;
		}
		dis[0]=0;
		Stack <Integer> st=new Stack<>();
		boolean vis[]=new boolean[N];
		for(int i=0;i<N;i++){
		    if(!vis[i])
		    topsort(edges,vis,i,st);
		}
	
		while(!st.isEmpty()){
		    int k=st.pop();
		    for(int i=0;i<M;i++){
		        if(edges[i][0]==k && dis[k]!=Integer.MAX_VALUE){
		            if(dis[edges[i][1]]>(dis[k]+edges[i][2]))
		            dis[edges[i][1]]=dis[k]+edges[i][2];
		        }
		    }
		}
		for(int i=0;i<N;i++){
		    if(dis[i]==Integer.MAX_VALUE)
		    dis[i]=-1;
		}
		return dis;
	}
	
	public void topsort(int edges[][],boolean vis[],int s,Stack<Integer> st){
	    vis[s]=true;
	    for(int i=0;i<edges.length;i++){
	        if(edges[i][0]==s){
	            if(!vis[edges[i][1]])
	            topsort(edges,vis,edges[i][1],st);
	        }
	    }
	    st.push(s);
	}
}
