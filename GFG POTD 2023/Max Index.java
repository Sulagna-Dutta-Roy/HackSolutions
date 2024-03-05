//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim()); // size of array
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]); // input elements of array
		    }
		    
		    Solution ob = new Solution();
		    
		    System.out.println(ob.maxIndexDiff(arr, n)); // print the result
		}
	}
}
// } Driver Code Ends


class Solution{
    
    // A[]: input array
    // N: size of array
    // Function to find the maximum index difference.
    static int maxIndexDiff(int a[], int n) { 
Stack<Integer> st=new Stack<>();
        
        st.push(n-1);
        
        for(int i=n-2;i>=0;i--)
        {
            if(a[i]>a[st.peek()])
            {
                st.push(i);
            }
        }
        
        int low=0;
        int ans=0;
        
        
        while(!st.isEmpty() && low<n)
        {
            if(a[st.peek()]>=a[low])
            {
                ans=Math.max(ans,st.pop()-low);
            }
            
            else
            {
                low++;
            }
        }
        
        return ans;
       
       
    }
}


