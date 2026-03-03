class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0)
        return 0;
        Set<Integer> set = new HashSet<>();
        int ans = 1;
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        for(int x:set){
            if(set.contains(x-1))
            continue;
            int y=x+1;
            while(set.contains(y)){
                y++;
            }
            ans=Math.max(y-x,ans);
        }
        return ans;
    }
}