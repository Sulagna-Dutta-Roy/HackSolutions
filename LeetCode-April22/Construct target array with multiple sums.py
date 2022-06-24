class Solution {
public:
    bool isPossible(vector<int>& target) {
        long sum = 0;
        int max=0;
        for(int i=0;i<target.length;i++){
            sum += target[i];
            if(target[Max]<target[i]){
                max=i;
            }
        }
        long diff = sum-target[max];
        if(target[max]==1 || diff == 1) return true;
        
        if(diff>target[max] || diff==0 || target[max]%diff==0) return false;
        
        target[max] %= diff;
        
        return isPossible(target);
    }
};
