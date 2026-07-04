class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
       int[] cnt = new int[nums.length];
       for(int i=0;i<cnt.length-1;i++){
            if((nums[i]%2!=0&&nums[i+1]%2!=0)||(nums[i]%2==0&&nums[i+1]%2==0))
                cnt[i]=1;
       }
       int[] sum = new int[nums.length+1];
       for(int i=1;i<nums.length+1;i++){
            sum[i] = cnt[i-1]+sum[i-1];
       }
       boolean[] ans = new boolean[queries.length];
       Arrays.fill(ans,true);
       for(int i=0;i<ans.length;i++){
            if(sum[queries[i][1]]-sum[queries[i][0]]>0)
                ans[i] = false;
       }
       return ans;
    }
}