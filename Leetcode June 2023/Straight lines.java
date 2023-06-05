class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
               double slopes=((coordinates[1][1]-coordinates[0][1])*1.0)/(coordinates[1][0]-coordinates[0][0]);
        for(int i=0;i<coordinates.length;i++){
            for(int j=i+1;j<coordinates.length;j++){
                double slope = ((coordinates[j][1]-coordinates[i][1])*1.0)/(coordinates[j][0]-coordinates[i][0]);
                if(slope!=slopes && slope!=-slopes) return false;
            }
        }
        return true;
    }
}
