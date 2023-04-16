class Solution {
    public int numWays(String[] words, String target) {
        int N = words.length;
        int W = words[0].length(); 
        int T = target.length();
        int[][] freq = new int[W][26];
        for (int i = 0; i < W; i++) {
            for (int j = 0; j < N; j++) {
                int let = words[j].charAt(i) - 'a';
                freq[i][let]++;
            }
        }
        long[][] dp = new long[T + 1][W + 1];
        for (int i = 0; i <= W; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < T; i++) {
            char tar = target.charAt(i);
            for (int j = 0; j < W; j++) {
                int num = freq[j][tar - 'a'];
                dp[i + 1][j + 1] = (dp[i + 1][j] + (dp[i][j] * num) % 1000000007) % 1000000007;
            }
        }
        return (int)dp[T][W];
    }
}
