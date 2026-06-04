class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans = 0;
        for(int j = 1;j<nums.length;j++){
            int l = lowerbound(nums,j-1,lower-nums[j]);
            int r = lowerbound(nums,j-1,upper-nums[j]+1);
            ans+=r-l;
        }
        return ans;
    }
    public int lowerbound(int []nums,int right,int target){
        int left = 0;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]<target)
            left = mid + 1;
            else
            right = mid -1;
        }
        return left;
    }
}