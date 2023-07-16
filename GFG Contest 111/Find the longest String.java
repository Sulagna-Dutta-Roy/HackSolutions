//{ Driver Code Starts
import java.io.*;
import java.util.*;


class StringArray
{
    public static String[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        return s;
    }

    public static void print(String[] a)
    {
        for(String e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<String> a)
    {
        for(String e : a)
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
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            String[] arr = StringArray.input(br, n);
            
            Solution obj = new Solution();
            String res = obj.longestString(n, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static String longestString(int n, String[] arr) {
        Arrays.sort(arr); // Sort the array instead of words
        String res = "";
        Map<String, Integer> m = new HashMap<>();
        m.put("", 1);
        for (String i : arr) { // Iterate over arr instead of words
            String temp = i.substring(0, i.length() - 1);
            if (m.get(temp) != null && m.get(temp) != 0) {
                if (res.length() < i.length())
                    res = i;
                m.put(i, m.getOrDefault(i, 0) + 1);
            }
        }
        return res;
    }
}
        
