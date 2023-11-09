//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            int arr[][] = new int[N][N];
            
            for(int i = 0; i < N; i++)
            {
                int k = 0;
                String str[] = read.readLine().trim().split("\\s+");
                for(int j = 0; j < N; j++){
                  arr[i][j] = Integer.parseInt(str[k]);
                  k++;
                }
            }
            
            System.out.println(new Solution().columnWithMaxZeros(arr,N));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    int columnWithMaxZeros(int arr[][], int N)
    {
        int max = 0;
        int sum = 0;
        int in = -1;
        for(int i = 0 ; i < N ; i++)
        {
            max = 0;
            for(int j = 0 ; j < N ; j++)
            {
                if(arr[j][i]  == 0)
                {
                    max++;
                }
            }
                if(max > sum)
                {
                    sum = max;
                     in = i;
                }
               
                
            
             
            
        }
        return in;
    }
}
