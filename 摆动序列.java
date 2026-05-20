class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if(nums.length<2){
            return n;
        }
        int []up = new int[nums.length];
        int []down = new int[nums.length];
        up[0] = 1;
        down[0] = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                down[i] = down[i-1];
                up[i] = Math.max(down[i-1]+1,up[i-1]);
            }
            else if(nums[i]<nums[i-1]){
                up[i] = up[i-1];
                down[i] = Math.max(up[i-1]+1,down[i-1]); 
            }else{
                up[i] = up[i-1];
                down[i] = down[i-1];
            }
        }
        return Math.max(down[n-1],up[n-1]);
    }
}