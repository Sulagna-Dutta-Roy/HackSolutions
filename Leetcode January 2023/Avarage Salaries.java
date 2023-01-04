class Solution {
    public double average(int[] salary) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        double sum = 0;
         for(int num : salary) {
        	sum += num;
        	if(min > num)
        		min = num;
        	if(max < num)
        		max = num;
        }
        sum -= (min + max);
        int total = salary.length-2;
        return sum/total;
    }
}
