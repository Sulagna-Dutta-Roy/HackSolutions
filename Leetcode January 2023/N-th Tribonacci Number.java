class Solution {
    int[] arr = new int[38];
    public int tribonacci(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 1;
        if(arr[n]>0) return arr[n];
        else arr[n] = tribonacci(n-1)+tribonacci(n-2)+tribonacci(n-3);
        return arr[n];
    }
}
