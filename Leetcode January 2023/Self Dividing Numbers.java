class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
         ArrayList<Integer> ans = new ArrayList<>();
        for(int i=left;i<=right;i++){
            if(check(i)){
                ans.add(i);
            }
        }return ans;
    }
    public boolean check(int n){
        int num = n;
        while(n>0){
            int rem = n%10;
            if(rem==0){
                return false;
            }
            if(num%rem!=0){
                return false;
            }
            n /= 10;
        }
        return true;
    }
}
