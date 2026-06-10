class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = nums[0];
        for(int i = 1;i<nums.length;i++){
            right = Math.max(nums[i],right);
        }
        while(left<=right){
            int mid = left + (right - left) / 2;
            if(!check(nums,mid,threshold)){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }
    public boolean check(int []nums,int chushu,int threshold){
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%chushu==0)
            sum+=nums[i]/chushu;
            else
            sum+=(nums[i]/chushu + 1);
        }
        if(sum<=threshold)
        return true;
        else
        return false;
    }
}