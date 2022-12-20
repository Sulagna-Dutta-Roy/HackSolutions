class Solution {
    public int findComplement(int num) {
        int i=1;
        while(num>i)
            i|= i<<1;
        return ~num & i;
    }
}
