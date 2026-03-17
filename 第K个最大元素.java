class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return quickselect(0,n-1,nums,n-k);
    }
    int quickselect(int l,int r,int []nums,int k){
        if(l==r){
            return nums[k];
        }
        int x = nums[l],i=l-1,j=r+1;
        while(i<j){
            while(nums[++i]<x);
            while(nums[--j]>x);
            if(i<j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        if(k<=j)return quickselect(l,j,nums,k);
        else return quickselect(j+1,r,nums,k);
    }
}