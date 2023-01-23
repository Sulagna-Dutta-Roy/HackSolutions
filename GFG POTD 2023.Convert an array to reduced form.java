class Solution {
    void convert(int[] arr, int n) {
        //Code here
        int crr[] = new int[n];
        for(int i=0;i<n;i++)
          crr[i] = arr[i];
        Arrays.sort(crr);
        for(int i=0;i<n;i++) {
            int l=0,r=n-1,mid;
            while(l<=r) {
                mid = (l+r)/2;
                if(crr[mid]==arr[i]) { 
                   System.out.println(mid+" ");
                   break; 
                }
                else if (crr[mid]<arr[i]) {
                    l = mid+1; 
                }
                else{
                    l = mid-1;
                }     }
         }  
    }
}
