//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.printMinNumberForPattern(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static String printMinNumberForPattern(String S){
       int n= S.length();
       int count =1;
       char[] ans= new char[n+1];
       for(int i=0;i<=n;i++){
           if(i == n || S.charAt(i) == 'I'){
               
               for(int j=i-1 ; j>=-1;j--){
                   ans[j+1]= (char)('0'+count);
                   count++;
                   if( j>=0 && S.charAt(j)  == 'I')
                   break;
               }
           }
       }
       return new String(ans);
    }
}
