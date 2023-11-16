//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


class GFG{
    static class FastReader{ 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader(){ 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next(){ 
            while (st == null || !st.hasMoreElements()){ 
                try{ st = new StringTokenizer(br.readLine()); } catch (IOException  e){ e.printStackTrace(); } 
            } 
            return st.nextToken(); 
        } 
  
        String nextLine(){ 
            String str = ""; 
            try{ str = br.readLine(); } catch (IOException e) { e.printStackTrace(); } 
            return str; 
        } 

        Integer nextInt(){
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) throws IOException
    {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int t = sc.nextInt();
        while(t-- > 0){
            int N = sc.nextInt(), K = sc.nextInt();
            Solution ob = new Solution();
            String ans = ob.findString(N, K);
            boolean ok = true;
            for(int i = 0; i < ans.length(); i++){
                char c = ans.charAt(i);
                if(c < '0' || c > K - 1 + '0')
                    ok = false;
            }
            if(!ok){
                out.println("-1");
                continue;
            }
            HashSet<String> st = new HashSet<String>();
            for(int i = 0; i + N - 1 < ans.length(); i++){
                st.add(ans.substring(i, i+N));
            }
            int tot = 1;
            for(int i=1;i<=N;i++)
                tot *= K;

            if(st.size() == tot){
                out.println(ans.length());
            }
            else{
                out.println("-1");
            }
        }
        out.flush();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public String findString(int n, int k){
         K = k;

        N = n;

        st.clear();

        if(n == 1) {

            char[] r = new char[k];

            for(int i = 0; i < k; i++)

                r[i] = (char)(i + '0');

            return new String(r);

        }

 

        tot = 1;

 

        for(int i = 1; i <= n; i++)

            tot *= k;

 

        char[] ansa = new char[n];

        Arrays.fill(ansa, '0');

        ans = new String(ansa);

        st.add(ans);

        dfs();

        return ans;

    }

 

    int K, N;

    long tot;

    HashSet<String> st = new HashSet<>();

    String ans;

 

    boolean dfs() {

        if(st.size() == tot) {

            return true;

        }

 

        String tmp = "";

        if(N > 1) {

            tmp = ans.substring(ans.length()-N+1);

        }

 

        for(int i = 0; i < K; i++) {

            tmp += i;

            if(!st.contains(tmp)) {

                ans += i;

                st.add(tmp);

                if(dfs())

                    return true;

                st.remove(tmp);

                ans = ans.substring(0, ans.length()-1);

            }

            tmp = tmp.substring(0, tmp.length()-1);

        }

 

        return false;
    }
}
