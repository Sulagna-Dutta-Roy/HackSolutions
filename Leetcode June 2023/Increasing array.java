Set<Integer> set=new HashSet<>();
        for(int x: arr2) {
            set.add(x);
        }
        List<Integer> list=new ArrayList<>(set);
        Collections.sort(list);
        dp=new Integer[arr1.length][list.size()+1];
        int ret=util(arr1, list, 0, -1);

        return (ret>=Integer.MAX_VALUE/2)?-1:ret;
    }

    private Integer dp[][];

    private int util(int  arr1[], List<Integer> arr2, int i, int j) { //j=>-1 means not replaces in previous iteration
        if(i==arr1.length) {
            return 0;
        }

        if(dp[i][j+1]!=null) return dp[i][j+1];

        int prev = i==0 ? Integer.MIN_VALUE : (j==-1?arr1[i-1]:arr2.get(j));

        int getIndex=binarySearch(arr2, prev);

        if(arr1[i]>prev) { //choice repace or not
            if(getIndex==arr2.size()) { //can't replace
                return dp[i][j+1]=util(arr1, arr2, i+1, -1);
            }

            //1=>replace
            int ret1=1+util(arr1, arr2, i+1, getIndex);
            //2=>don't replace
            int ret2=util(arr1, arr2, i+1, -1);

            // return minimum of both ret1 & ret2;
            return dp[i][j+1]=Math.min(ret1, ret2);
        }else { //no choice 
            if(getIndex==arr2.size()) return Integer.MAX_VALUE/2; //no options left
            return dp[i][j+1]=1+util(arr1, arr2, i+1, getIndex);
        }
    }

    private int binarySearch(List<Integer> arr2, int target) {
        int l=-1;
        int h=arr2.size();
        //just greater
        while(l+1<h) {
            int mid=(l+h)/2;
            if(arr2.get(mid)<=target) {
                l=mid;
            }else {
                h=mid;
            }
        }
        return h;
