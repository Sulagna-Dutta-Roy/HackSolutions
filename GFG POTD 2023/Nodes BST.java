//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException
    {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            Solution T = new Solution();
            int target = Integer.parseInt(br.readLine().trim());
            int k = Integer.parseInt(br.readLine().trim());
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = T.KDistanceNodes(root,target,k);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right;
// }
class Solution {
    public static Node findNode(Node root, int target) {
        if (root == null || root.data == target)
            return root;

        Node left = findNode(root.left, target);
        Node right = findNode(root.right, target);

        return left != null ? left : right;
    }

    public static void markParent(Node root, Map<Node, Node> parent_track, int target) {

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.left != null) {
                parent_track.put(curr.left, curr);
                q.add(curr.left);
            }
            if (curr.right != null) {
                parent_track.put(curr.right, curr);
                q.add(curr.right);
            }
        }
    }

    public static ArrayList<Integer> KDistanceNodes(Node root, int target, int k) {
        HashMap<Node, Node> parent_track = new HashMap<>();
        markParent(root, parent_track, target);

        HashMap<Node, Boolean> visited = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(findNode(root, target));
        visited.put(findNode(root, target), true);
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            if (level == k)
                break;
            level++;
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();

                if (curr.left != null && visited.get(curr.left) == null) {
                    q.add(curr.left);
                    visited.put(curr.left, true);
                }

                if (curr.right != null && visited.get(curr.right) == null) {
                    q.add(curr.right);
                    visited.put(curr.right, true);
                }
                if (parent_track.get(curr) != null && visited.get(parent_track.get(curr)) == null) {
                    q.add(parent_track.get(curr));
                    visited.put(parent_track.get(curr), true);
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            Node curr = q.poll();
            ans.add(curr.data);
        }
        Collections.sort(ans);
        return ans;
    }
}
