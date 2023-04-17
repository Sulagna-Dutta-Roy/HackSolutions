class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int max = 0;
        for(int i:candies) max = Math.max(i,max);
        for(int i:candies)
            result.add(i+extraCandies>=max);
        return result;
    }
}
