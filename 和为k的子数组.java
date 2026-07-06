class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length+1];
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int ans = 0;
        for(int i=1;i<sum.length;i++){
            sum[i] = sum[i-1] + nums[i-1];  
            if(map.containsKey(sum[i]-k))
            ans+=map.get(sum[i]-k);
            map.put(sum[i],map.getOrDefault(sum[i],0)+1);
        }
        return ans;
    }
}