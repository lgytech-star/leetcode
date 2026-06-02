class Solution {
    public int minRemoval(int[] nums, int k) {
        if(nums.length==1)
        return 0;
        Arrays.sort(nums);
        int i = 0,j = 0;
        int max = 0;
        while(j<nums.length){
            while((long)nums[i]*k<nums[j]){
                i++;
            }
            max = Math.max(max,j-i+1);
            j++;
        }
        return nums.length - max;
    }
}