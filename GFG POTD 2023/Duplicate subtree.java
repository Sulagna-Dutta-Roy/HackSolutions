

//User function Template for Java

/* A Binary Tree node

class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
 */

class Solution {
    int dupSub(Node root) {
        if (root == null) return 0;
        HashMap<String, Integer> hm = new HashMap<>();
        helper(root, hm);
        for(HashMap.Entry<String, Integer> entry : hm.entrySet()) {
            if(entry.getValue() > 1) return 1;
        }
        
        return 0;
    }

    String helper(Node root, HashMap<String, Integer> hm) {
        if (root == null) return "#";
        
        if(root.left == null && root.right == null) return  String.valueOf(root.data);

        String leftCount = helper(root.left, hm);
        String rightCount = helper(root.right, hm);

        String subtree = root.data + ", " + leftCount + ", " + rightCount;
        hm.put(subtree, hm.getOrDefault(subtree, 0) + 1);

        return subtree;
    }
}
