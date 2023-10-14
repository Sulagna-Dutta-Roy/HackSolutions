//{ Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;
import java.math.*;

class Node{
    int data;
    Node left, right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

// } Driver Code Ends
//User function Template for Java


class Solution
{
    //Function to find the nodes that are common in both BST.
	public static ArrayList<Integer> findCommon(Node root1,Node root2)
    {
        ArrayList<Integer> ans = new ArrayList<>();
       HashMap<Integer,Integer> map = new HashMap<>();
       inorder(root1,ans,true,map);
       inorder(root2,ans,false,map);
       return ans;
    }
    static void inorder(Node root,ArrayList<Integer> ans ,boolean f,HashMap<Integer,Integer> map){
        if(root==null){
            return;
        }
        inorder(root.left,ans,f,map);
        if(f){
            map.put(root.data,map.getOrDefault(root.data,0)+1);
        }
        else{
            if(map.containsKey(root.data)){
                ans.add(root.data);
            }
        }
        inorder(root.right,ans,f,map);
    }
}


//{ Driver Code Starts.
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
    
    public static void main(String args[]) throws IOException {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root1 = buildTree(s);
            
            s = br.readLine();
            Node root2 = buildTree(s);
            
            Solution g = new Solution();
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = g.findCommon(root1,root2);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
            
            t--;
        }
    }
}
// } Driver Code Ends
