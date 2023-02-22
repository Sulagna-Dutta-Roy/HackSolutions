class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int ans = 0;
        
        int l = 0;
        int r = Integer.MAX_VALUE;
        
        while(l<=r){
            int mid = l + (r-l)/2;
            if(possible(weights,mid,days)){
                ans = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }
    
    static boolean possible(int[] arr, int mid, int days){
        int n = arr.length;
        int weight = 0;
        int day = 1;
        
        for(int i = 0; i<n; i++){
            if(arr[i] > mid)
                return false;
            
            weight+=arr[i];
            if(weight>mid){
                day++;
                weight = arr[i];
            }
            
            if(day>days)
                return false;
        }
        
        return true;
    }
}
