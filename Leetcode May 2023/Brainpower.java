class Solution {
    public long mostPoints(int[][] questions) {
       int n = questions.length;
        long[] dp = new long[n + 1];
        for (int i = n - 1; i >= 0; --i) {
            int points = questions[i][0];
            int jump = questions[i][1];
            int nextQuestion = Math.min(jump + i + 1, n);
            long pointsFromThisQuestion = points + dp[nextQuestion];
            dp[i] = Math.max(pointsFromThisQuestion, dp[i + 1]);
        }
        return dp[0]; 
    }
}
