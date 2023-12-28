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


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int[] nm = IntArray.input(br, 2);
            
            
            int[][] a = IntMatrix.input(br, nm[0], nm[1]);
            
            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> res = obj.sumZeroMatrix(a);
            
            if(res.size() == 0) {
                System.out.println(-1);
                
            } else {
            
                IntMatrix.print(res);
            }        
        }
    }
}

// } Driver Code Ends



class Solution {
    public static ArrayList<ArrayList<Integer>> sumZeroMatrix(int[][] a) {
        int n=a.length;
        int m=a[0].length;
        int[][] sum=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sum[i][j]=a[i][j]+(j>0? sum[i][j-1]:0);
            }
        }
        int maxArea=0,startRow=0,endRow=-1,startCol=0,endCol=-1;
        for(int c1=0;c1<m;c1++){
            for(int c2=c1;c2<m;c2++){
                int[] temp=new int[n];
                for(int i=0;i<n;i++){
                    temp[i]=sum[i][c2]-(c1>0 ? sum[i][c1-1]:0);
                }
                Map<Integer,Integer>map=new HashMap();
                map.put(0,-1);
                int currSum=0;
                for(int i=0;i<n;i++){
                    currSum+=temp[i];
                    if(map.containsKey(currSum)){
                        int area=(c2-c1+1)*(i-map.get(currSum));
                        if(area>maxArea){
                            maxArea=area;
                            startRow=map.get(currSum)+1;
                            endRow=i;
                            startCol=c1;
                            endCol=c2;
                        }
                    }
                    else{
                        map.put(currSum,i);
                    }
                }
                
            }
        }
        ArrayList<ArrayList<Integer>> ans=new ArrayList();
        if(maxArea==0)
        return ans;
        for(int i=startRow;i<=endRow;i++){
            ArrayList<Integer> row=new ArrayList();
            for(int j=startCol;j<=endCol;j++){
                row.add(a[i][j]);
            }
            ans.add(row);
        }
        return ans;
    }
}
        
