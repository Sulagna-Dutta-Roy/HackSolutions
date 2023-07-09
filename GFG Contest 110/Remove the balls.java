import java.util.Stack;
class Solution {
    public int findLength(int N, int[] color, int[] radius) {
        Stack<Pair<Integer, Integer>> st = new Stack<>();
        for (int i = 0; i < N; i++) {
            if (st.empty()) {
                st.push(new Pair<>(color[i], radius[i]));
            } else if (st.peek().getKey() == color[i] && st.peek().getValue() == radius[i]) {
                st.pop();
            } else {
                st.push(new Pair<>(color[i], radius[i]));
            }
        }
        return st.size();
    }
}
