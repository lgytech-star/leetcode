class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min = nums.length+1;
        int i = -1, j = 0;
        int num = 0;
        while(j < nums.length){
            if(num < target){
                num += nums[j];
                j++;
            }
            
            while(num >= target){            
                min = Math.min(j - i - 1, min); 
                i++;
                num -= nums[i];
            }
        }
        if(min == nums.length+1)
            return 0; 
        return min;   
    }
}