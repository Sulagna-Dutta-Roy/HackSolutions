//{ Driver Code Starts
import java.util.*;

class Sorted_Array {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            System.out.println(obj.transitionPoint(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends


class Solution {
    int transitionPoint(int arr[], int n) {
        int ans=0;
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(arr[i]);
        }
        for(int i=0;i<n;i++){
            if(arr[i]==1){
                ans=i;
                break;
            }
        }
        if(ans==0 && !list.contains(1)){
            return -1;
        }else if(ans==0 && list.contains(1)){
            return ans;
        }else{
            return ans;
        }
    }
}
