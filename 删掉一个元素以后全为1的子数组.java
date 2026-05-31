class Solution {
    public int longestSubarray(int[] nums) {
        int num = 0;
        int i = 0, j = 0;
        int ans = 0;
        while(j<nums.length){
            if(num<=1){
                if(nums[j]==0)
                num++;
                j++;
            }else{
                while(num==2&&i<nums.length){
                        if(nums[i]==0)
                        num--;
                        i++;  
                }
                }
                if(num<=1)
                ans = Math.max(ans,j-i-1);
            }
             return ans;
        }
}