//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcases = Integer.parseInt(br.readLine());
        while (testcases-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(a1[i]);
            }
            Solution ob = new Solution();
            int ans=ob.minNumber(a,n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    public int minNumber(int arr[], int N)
    {
        int sum = 0;
        for(int num : arr) sum = sum + num;
        for(int i = 0; i < 100; i++) if(isPrime(sum + i)) return i;
        return -1;

    }
    boolean isPrime(int num) {
        if(num == 1) return false;
        for(int i = 2; i * i <= num; i++) if(num % i == 0) return false;
        return true;
    }
}
