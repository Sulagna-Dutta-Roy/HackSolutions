class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int matrix[][] = new int[m][n];
        for(int arr[]:indices)
        {
            for(int i=0;i<n;i++)
                matrix[arr[0]][i]++;
            for(int i=0;i<m;i++)
                matrix[i][arr[1]]++;
        }
        int c=0;
        for(int arr[]:matrix)
        {
            for(int i:arr)
                if(i%2!=0)
                    c++;
        }
        return c;
    }
}
