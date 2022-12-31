class Solution {
    public int commonFactors(int a, int b) {
        int min = Math.min(a,b);
        int commonFactors = 0;
        for(int i=1;i<=min;i++) 
            if(a%i==0 && b%i==0) {
                commonFactors++;
            }
        return commonFactors;
    }
}
