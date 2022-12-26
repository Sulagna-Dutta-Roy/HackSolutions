class Solution {
    public int subtractProductAndSum(int n) {
        int m = 0;
        int s = 1;
        while(n>0) {
            int d = n%10;
            n/=10;
            m+=d;
            s*=d;
        }
    return s-m;
    }
}
