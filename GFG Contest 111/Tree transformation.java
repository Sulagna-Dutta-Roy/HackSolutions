class Solution {
    public static int solve(int N, int[] p) {
        int connect[] = new int[N];
        for(int i=1;i<N;i++){
            connect[i]++;
            connect[p[i]]++;
        }
        int count = 0;
        for(int c:connect){
            if(c==1)
                count++;
        }
        return (count==N)?0:N-count-1;
    }
}
