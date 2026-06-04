class Solution {
    public int lowerbound(int []nums,int target){
        int i = 0, j = nums.length - 1;
        while(i <= j){
            int mid = i+(j-i)/2; 
            if(nums[mid]<target){
                i = mid + 1;
            }else if(nums[mid]>=target){
                j = mid - 1;
            }
        }
         return i;
    }
    public int[] searchRange(int[] nums, int target) {
         int start = lowerbound(nums,target);
         if(start>=nums.length||nums[start]!=target)
         return new int[]{-1,-1};
         int end = lowerbound(nums,target+1)-1;
         return new int[]{start,end};
    }
}