//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.*;


public class Driver {
    
    public static void main(String[] args)throws IOException {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-->0)
        {
            String s1 = br.readLine();
            String s2 = br.readLine();
            
            Solution obj = new Solution();
            
            boolean a = obj.areIsomorphic(s1,s2);
            if(a)
            System.out.println(1);
            else
            System.out.println(0);
        }
    }
    
}

// } Driver Code Ends


class Solution
{
    //Function to check if two strings are isomorphic.
    public static boolean areIsomorphic(String str1,String str2)
    {
        // Your code here
        if (str1.length()!=str2.length())
        return false;
        HashMap<Character,Character> hs1=new HashMap<>();
        HashMap<Character,Character> hs2=new HashMap<>();
        for(int i=0;i<str1.length();i++)
        {
          if (!hs1.containsKey(str1.charAt(i)))
            hs1.put(str1.charAt(i),str2.charAt(i));
            else 
            if(hs1.get(str1.charAt(i))!=str2.charAt(i))
            return false;
        }
       
        for(int i=0;i<str1.length();i++)
        {
          if (!hs2.containsKey(str2.charAt(i)))
            hs2.put(str2.charAt(i),str1.charAt(i));
            else 
            if(hs2.get(str2.charAt(i))!=str1.charAt(i))
            return false;
        }
        return true;
    }
}
