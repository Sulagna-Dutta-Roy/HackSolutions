class Solution {
    public List<String> fizzBuzz(int n) {
        ArrayList<String> res = new ArrayList<String>();
        for(int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                res.add("FizzBuzz");
                continue;
            }
            if (i % 3 == 0) {
                res.add("Fizz");
                continue;
            }
            
            if (i % 5 == 0) {
                res.add("Buzz");
                continue;
            }
            res.add(Integer.toString(i));
        }
        return res;
    }
}
