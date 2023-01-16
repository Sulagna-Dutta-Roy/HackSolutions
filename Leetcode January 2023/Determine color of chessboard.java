class Solution {
    public boolean squareIsWhite(String coordinates) {
        char[] coordinate = coordinates.toCharArray(); 
        
        
        int alpha = coordinate[0];
        int num =  coordinate[1];
        
        if(alpha%2==1 && num % 2 ==1) return false ;
        else if(alpha%2==1 && num % 2 ==0) return true ;
        else if(alpha%2==0 && num % 2 ==1) return true ;
        else if(alpha%2==0 && num % 2 ==0) return false ;

        return true ;
    }
}
