class Solution {
    public int totalFruit(int[] fruits) {
         Map<Integer, Integer> basket = new HashMap<>();
        int j=0;int i=0;
        int res = 0;
        for (i = 0; i < fruits.length; i++) {
            basket.put(fruits[i], basket.getOrDefault(fruits[i], 0) + 1);
            while(basket.size() > 2) {
                basket.put(fruits[j], basket.get(fruits[j]) - 1);
                basket.remove(fruits[j], 0);
                j++;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
