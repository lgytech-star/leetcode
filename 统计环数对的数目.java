class Solution {
    public long countBadPairs(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        long ans = 0;
        map.put(nums[0]-0,1);
        for(int i=1;i<nums.length;i++){
            if(map.get(nums[i]-i)!=null){
                int x = nums[i]-i;
                ans+=map.get(x);
                map.put(x,map.get(x)+1);
            }else{
                map.put(nums[i]-i,1);
            }
        }
        return (long)n*(n-1)/2 - ans;
    }
}