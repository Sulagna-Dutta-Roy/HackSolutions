//{ Driver Code Starts
//Initial template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        
        while(t-->0)
        {
            int sizeOfStack =sc.nextInt();
            Stack <Integer> myStack=new Stack<>();
            
            //adding elements to the stack
            for(int i=0;i<sizeOfStack;i++)
            {
                int x=sc.nextInt();
                myStack.push(x);
                
            }
                Solution obj=new Solution();
                obj.deleteMid(myStack,sizeOfStack);
                
                while(!myStack.isEmpty())
                {
                    System.out.print(myStack.peek()+" ");
                    myStack.pop();
                }
                System.out.println();
        }
        
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public void deleteMid(Stack<Integer>s,int sizeOfStack){
        int n = sizeOfStack;
        int mid = (n+1)/2;
        int ele = s.pop();
        int curr = n;
        
        modify(s,ele,curr,mid);
    }
        void modify(Stack<Integer>s,int ele,int curr,int mid){
        if(curr==mid){ 
            return;
        }
        modify(s,s.pop(),curr-1,mid);
        s.add(ele);
    } 
}

