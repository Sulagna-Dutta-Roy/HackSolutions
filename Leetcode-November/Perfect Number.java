class Solution {
    public boolean checkPerfectNumber(int num) {
         if(num==1){
            return false;
        }
        int sum=0;
        for(int i=2;i<Math.pow(num,0.5);i++){
            if(num%i==0){
                sum+=i+(num/i);
            }
        }
        return ++sum==num;
    }
}
