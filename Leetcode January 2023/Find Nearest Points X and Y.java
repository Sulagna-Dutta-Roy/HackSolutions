import java.lang.Math;
class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int ans=-1;
        int temp=10001;
        for(int i=0;i<points.length;i++)
        {
            if(points[i][0]==x||points[i][1]==y)
            {
                int val=Math.abs(points[i][0]-x)+Math.abs(points[i][1]-y);
                if(val<temp){
                    temp=val;
                    ans=i;
                }
            }
        }
        return ans;
    }
}
