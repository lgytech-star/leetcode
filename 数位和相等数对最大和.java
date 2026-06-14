class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int ans = -1;
        for(int i=0;i<nums.length;i++){
            int num = 0;
            int a = nums[i];
            while(a!=0){
                num+=a%10;
                a/=10;
            }
            if(map.containsKey(num)){
                ans = Math.max(ans,nums[map.get(num)]+nums[i]);
                if(nums[i]>nums[map.get(num)])
                map.put(num,i);
            }else{
                map.put(num,i);
            }
        }
        return ans;
    }
}