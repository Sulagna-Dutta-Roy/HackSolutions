class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int a = 0;
        for(int val : pushed){
            st.push(val);
            while(!st.isEmpty() && st.peek() == popped[a]){
                st.pop();
                a++; 
            }
        }
        return st.isEmpty();
    }
}
