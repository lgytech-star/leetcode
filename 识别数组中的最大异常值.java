class Solution {
    public int getLargestOutlier(int[] nums) {
        int ans = Integer.MIN_VALUE;
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            if(map.get(nums[i])==null)
            map.put(nums[i],1);
            else
            map.put(nums[i],map.get(nums[i])+1);
            sum+=nums[i];
        }
        for(int i = 0;i<nums.length;i++){
            int x = sum - 2 * nums[i];
            if(map.containsKey(x)&&(x!=nums[i]||map.get(x)>1)){
                ans = Math.max(ans,x);
            }
        }
        return ans;
    }
}