/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
        return construct(grid,0,0,grid.length);
    }
    public Node construct(int[][] grid,int i,int j,int length){
        if(length==1){
            return new Node(grid[i][j]==1,true);
        }
        else{
            Node node=new Node(false,false);
            Node topLeft=construct(grid,i,j,length/2);
            Node topRight=construct(grid,i,j+length/2,length/2);
            Node bottomLeft=construct(grid,i+length/2,j,length/2);
            Node bottomRight=construct(grid,i+length/2,j+length/2,length/2);  
            if(topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf && topLeft.val==topRight.val && topLeft.val==bottomRight.val && topLeft.val==bottomLeft.val){
                node.isLeaf=true;
                node.val=topLeft.val;
            }
            else{
                node.topLeft=topLeft;
                node.topRight=topRight;
                node.bottomLeft=bottomLeft;
                node.bottomRight=bottomRight;
            }
            return node;
    }
  }
}
