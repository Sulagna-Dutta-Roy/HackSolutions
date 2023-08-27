

//User function Template for Java


class Reverse
{
    // Complete the function
    // str: input string
    public static String reverseWord(String str)
    {
        StringBuilder res = new StringBuilder("");
        for(int i=0;i<str.length();i++) {
            res.insert(0,str.charAt(i));
        }
        return res.toString();
    }
}
