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
            
            String St[] = br.readLine().split(" ");
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
           
            int[] arr = IntArray.input(br, N);
            
            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> res = obj.kTop(arr, N, K);
            
            IntMatrix.print(res);
            
        }
    }
}

// } Driver Code Ends




class Pair {
    int num;
    int freq;

    Pair(int n, int f) {
        num = n;
        freq = f;
    }
}
class Solution {
    static class PairComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair p1, Pair p2) {
            if (p1.freq != p2.freq)
                return Integer.compare(p2.freq, p1.freq);
            return Integer.compare(p1.num, p2.num);
        }
    }

    public static ArrayList<ArrayList<Integer>> kTop(int[] arr, int N, int K) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        HashMap<Integer, Pair> frequencyMap = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(new PairComparator());

        for (int i = 0; i < N; i++) {
            int currentNum = arr[i];
            int currentFreq = 1;
            // Update the frequency of the current number in the PriorityQueue
            Pair currentPair = frequencyMap.get(currentNum);
            if (currentPair != null) {
                currentFreq+=currentPair.freq;
                pq.remove(currentPair);
            }

            currentPair = new Pair(currentNum, currentFreq);
            frequencyMap.put(currentNum, currentPair);
            pq.add(currentPair);

            ArrayList<Integer> currentList = new ArrayList<>();
            PriorityQueue<Pair> tempPQ = new PriorityQueue<>(pq);

            int count = 0;
            while (!tempPQ.isEmpty() && count < K) {
                currentList.add(tempPQ.poll().num);
                count++;
            }

            result.add(new ArrayList<>(currentList));
        }

        return result;
    }
}
