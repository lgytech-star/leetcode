class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum%k)&&i+1-map.get(sum%k)>=2){
                return true;
            }else if(!map.containsKey(sum%k)){
                map.put(sum%k,i+1);
            }
        }
        return false;
    }
}