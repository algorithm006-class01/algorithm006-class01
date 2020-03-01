class Solution {
public:
    int binarySearch(vector<int>& nums, int l, int r, int target){
        while(l<=r){
            int p = (l+r)/2;
            if(nums[p] == target)
                return p;
            else if(nums[p] > target)
                r = p -1;
            else if (nums[p] < target)
                l = p +1;
            
        }
        return -1;
    }
    int search(vector<int>& nums, int target) {
        if (nums.empty())
            return -1;
        
        int l = 0;
        int r = nums.size()-1;
        int p;
        while(l <=r){
            p = (l+r)/2;
            if(p== nums.size()-1 || nums[p]>nums[p+1])
                break;
            if(nums[l] > nums[p])
                r = p-1;
            else
                l = p+1;
        }
        
        if(p==nums.size()-1)
            return binarySearch(nums,0,nums.size()-1,target);
        
        int pos = binarySearch(nums,0,p,target);
        if(pos !=-1)
            return pos;
        return binarySearch(nums,p+1,nums.size()-1,target);
    }
};
