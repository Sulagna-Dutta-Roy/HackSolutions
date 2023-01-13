class Solution {
    public int countDigits(int num) {
        int val = 0;
        for (int n = num; n > 0; n /= 10)
            if (num % (n % 10) == 0)
                val++;
        return val;
    }
}
