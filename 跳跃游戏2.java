class Solution {
    public int jump(int[] nums) {
        int curend = 0;
        int nextend = 0;
        int ans = 0;
        for(int i = 0;i<nums.length-1;i++){
            nextend = Math.max(nextend,i+nums[i]);
            if(i==curend){
                curend = nextend;
                ans++;
            }
        }
        return ans;
    } 
}