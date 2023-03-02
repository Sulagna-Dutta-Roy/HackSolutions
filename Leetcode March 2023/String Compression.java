class Solution {
    public int compress(char[] chars) {
        int i=0,k=0;
        while(i<chars.length){
            int j=i;
            while(j<chars.length && chars[i]==chars[j]){
                j++;
            }
            chars[k]=chars[i];
            k++;
            if((j-i)>1){
                String s = String.valueOf(j-i);
                for(int x=0;x<s.length();x++){
                    chars[k++]=s.charAt(x);
                }
            }
            i=j;
        }
        return k;
    }
}
