//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class Node {
    int data;
    Node right;
    Node left;

    Node(int val) {
        data = val;
        right = null;
        left = null;
    }
}

class GFG {

    public static Node insert(Node tree, int val) {
        Node temp = null;
        if (tree == null) {
            return new Node(val);
        }

        if (val < tree.data) {
            tree.left = insert(tree.left, val);
        } else if (val > tree.data) {
            tree.right = insert(tree.right, val);
        }

        return tree;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            Node root = null;
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int k = sc.nextInt();
                root = insert(root, k);
            }

            int s = sc.nextInt();

            Solution obj = new Solution();
            int ans = obj.floor(root, s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int floor(Node root, int x) {
        Queue<Node> q = new LinkedList<>();
        if (root == null) return -1;
        q.add(root);
        
        int ans = -1;
        while (q.size() > 0) {
            Node node = q.poll();
            if (node.data == x) return x;
            
            if (node.data < x) {
                ans = node.data;
                if (node.right != null) q.add(node.right);
            }
            else {
                if (node.left != null) q.add(node.left);
            }
        }
        
        return ans;
    }
}
