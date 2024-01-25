//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

// } Driver Code Ends
//User function Template for Java
class Solution{
    int solve(int num1,int num2){
        int isPrime[] = new int[10000];
        Arrays.fill(isPrime,1);
        for(int i =2 ;i*i<10000;i++){
            for(int j = i*i;j<10000;j=j+i){
                if(isPrime[j]==1){
                    isPrime[j]=0;
                }
            }
        }
        
        int vis[] = new int[10000];
        int dp[] = new int[10000];
        
        Queue<Integer> q = new LinkedList<>();
        q.add(num1);
        while(!q.isEmpty()){
            int currNode = q.poll();
            vis[currNode]=1;
            String str = currNode+"";
            for(int i =0 ;i<4;i++){
                for(char c ='0';c<='9';c++){
                    if((c=='0'&& i==0) || str.charAt(i)==c){
                        continue;
                    }
                    String nextNode = str.substring(0,i)+c+str.substring(i+1);
                   
                    int nxtNode = Integer.parseInt(nextNode);
                    if(isPrime[nxtNode]==1 && dp[nxtNode]==0){
                        //  System.out.println(nextNode+"next node");
                        dp[nxtNode] = 1+ dp[currNode];
                        q.add(nxtNode);
                    }
                }
            }
        }
        
        return dp[num2];
    }
}

//{ Driver Code Starts.
class GFG{
    public static void main(String args[]) throws IOException{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            int num1=Integer.parseInt(input_line[0]);
            int num2=Integer.parseInt(input_line[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.solve(num1,num2));
        }
    }
}
// } Driver Code Ends
