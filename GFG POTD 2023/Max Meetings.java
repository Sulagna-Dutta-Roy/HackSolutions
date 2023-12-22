//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N; 
            N = Integer.parseInt(br.readLine());
            
            
            int[] S = IntArray.input(br, N);
            
            
            int[] F = IntArray.input(br, N);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.maxMeetings(N, S, F);
            
            IntArray.print(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> maxMeetings(int N, int[] S, int[] F) {
ArrayList<Integer> ans=new ArrayList<>();
        
        int[][]meetings=new int[N][3];
        
        for(int i=0;i<N;i++)
        {
            meetings[i][0]=S[i];
            meetings[i][1]=F[i];
            meetings[i][2]=i+1;
        }
        
        
        Arrays.sort(meetings,(a,b)->a[1]==b[1]?a[0]-b[0]:a[1]-b[1]);
        
        int lastfinish=-1;
        
        for(int i=0;i<N;i++)
        {
            if(meetings[i][0]>lastfinish)
              {
                  ans.add(meetings[i][2]);
                  lastfinish=meetings[i][1];
              }
        }
        
        Collections.sort(ans);
        return ans;
    }
}
        
