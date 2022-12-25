class Solution {
    public int minimumSum(int num) {
        int[] n = new int[4];          
        n[0] = num%10;                 
        num /= 10;
        n[1] = num%10;                 
        num /= 10;
        n[2] = num%10;                 
        num /= 10;
        n[3] = num%10;                  
        num /= 10;
        Arrays.sort(n);                 
        int num1 = n[0]*10 + n[2];     
        int num2 = n[1]*10 + n[3];      
        return num1 + num2;
    }
}
