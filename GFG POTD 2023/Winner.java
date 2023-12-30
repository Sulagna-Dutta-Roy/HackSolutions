//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String arr[] = new String[n];
            
            for(int i = 0; i < n; i++)
                arr[i] = sc.next();
            
            Solution obj = new Solution();    
            String result[] = obj.winner(arr, n);
            System.out.println(result[0] + " " + result[1]);
            
           
        }
        
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to return the name of candidate that received maximum votes.
    public static String[] winner(String arr[], int n)
    {
        TreeMap<String,Integer> map = new TreeMap<>(new LexicographicComparator());
        for(String i : arr){
            if(map.containsKey(i))
            map.put(i,map.getOrDefault(i,0)+1);
            else
            map.put(i,1);
        }
        String result[] = new String[2];
        result[1] = "0";
        for(Map.Entry<String,Integer> it : map.entrySet()){
            if(Integer.parseInt(result[1]) < it.getValue()){
                result[0] = it.getKey();
                result[1] = Integer.toString(it.getValue());

            }
        }
        return result;
    }
    static class LexicographicComparator implements Comparator<String> {
        public int compare(String str1, String str2){
            return str1.compareTo(str2);
        }
    }
}
