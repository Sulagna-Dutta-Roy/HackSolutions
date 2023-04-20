// Definition for a binary tree node.
 public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
      }
  }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int maxWidth = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> indexQueue = new LinkedList<>();
        queue.offer(root);
        indexQueue.offer(1);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int leftIndex = 0, rightIndex = 0;
            
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                int index = indexQueue.poll();
                
                if (i == 0) {
                    leftIndex = index;
                }
                if (i == levelSize - 1) {
                    rightIndex = index;
                }
                
                if (node.left != null) {
                    queue.offer(node.left);
                    indexQueue.offer(index * 2);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    indexQueue.offer(index * 2 + 1);
                }
            }
            
            maxWidth = Math.max(maxWidth, rightIndex - leftIndex + 1);
        }
        
        return maxWidth;
    }
}
