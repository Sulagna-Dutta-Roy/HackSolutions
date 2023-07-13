//{ Driver Code Starts
import java.util.*;

class TwoStack
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in); 
		int T = sc.nextInt();
		while(T>0)
		{
			twoStacks g = new twoStacks();
			int Q = sc.nextInt();
			while(Q>0)
			{
				int stack_no = sc.nextInt();
				int QueryType = sc.nextInt();
				
				
				if(QueryType == 1)
				{
					int a = sc.nextInt();
					if(stack_no == 1)
					 g.push1(a);
					else if(stack_no ==2)
					 g.push2(a);
				}else if(QueryType == 2)
				{
					if(stack_no==1)
					System.out.print(g.pop1()+" ");
					else if(stack_no==2)
					System.out.print(g.pop2()+" ");
				}
			
				Q--;
			}
				System.out.println();
		  T--;
		}
	}
}


// } Driver Code Ends


class twoStacks
{
    int[] res =  new int[100];
    int a1 = 0,a2 = -1;
    int b1 = 99, b2 = 100;
    void push1(int x)
    {
        a2++;
        res[a2] = x;
    }
    void push2(int x)
    {
       b2--;
       res[b2] = x;
    }
    int pop1()
    {
       if(a1>a2) return -1;
       return res[a2--];
    }
    int pop2()
    {
        if(b2>b1) return -1;
        return res[b2++];
    }
}

