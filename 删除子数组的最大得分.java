class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int sum = 0;
        int i = 0,j = 0;
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        while(j<nums.length){
            sum+=nums[j];
            while(set.contains(nums[j])){
                set.remove(nums[i]);
                sum-=nums[i];
                i++;
            }
            set.add(nums[j]);
            j++;
            ans = Math.max(ans,sum);
        }
        return ans;
    }
}