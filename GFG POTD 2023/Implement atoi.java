//{ Driver Code Starts
//Initial template for JAVA

import java.util.Scanner;

class aToi
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			
			Solution obj = new Solution();
			int num = obj.atoi(str);
			
			System.out.println(num);
		t--;
		}
	}
}
// } Driver Code Ends


//User function template for JAVA

/*You are required to complete this method */
class Solution
{
    int atoi(String s) {
int flag = 0;
    try{
        Integer.parseInt(s);
        flag = 1;
        
    }
    catch(Exception e){
        flag = 0;
    }
if(flag==1){
    return Integer.valueOf(s);
}
else{
    return -1;
}
    }
}
