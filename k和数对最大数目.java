class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int num = 0;
        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(k-nums[i])){
                num++;
                map.put(k-nums[i],map.get(k-nums[i])-1);
                if(map.get(k-nums[i])==0)
                map.remove(k-nums[i]);
            }else{
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            }
        }
        return num;
    }
}