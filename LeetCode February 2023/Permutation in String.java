class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        
        for (int i = 0; i < s1.length(); i++){
            arr1[s1.charAt(i) - 'a']++;
            arr2[s2.charAt(i) - 'a']++;
        }
        for (int i = s1.length(); !Arrays.equals(arr1, arr2); i++){
            if (i == s2.length()){
                return false;
            }
            arr2[s2.charAt(i - s1.length()) - 'a']--;
            arr2[s2.charAt(i) - 'a']++;
        }
        return true;
    }
}
