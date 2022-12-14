class Solution {
    public String convertToTitle(int columnNumber) {
        String title = "";
        while(columnNumber > 0){
            int remainder = (columnNumber-1) % 26;
            title = (char)('A' + remainder) + title;
            columnNumber = (columnNumber - 1) / 26;
        }
        return title;
    }
}
