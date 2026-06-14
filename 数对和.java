class Solution {
    public List<List<Integer>> pairSums(int[] nums, int k) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(k-nums[i])){
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                list.add(k-nums[i]);
                res.add(new ArrayList<>(list));
                map.put(k-nums[i],map.get(k-nums[i])-1);
                if(map.get(k-nums[i])==0)
                map.remove(k-nums[i]);
            }else{
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            }
        }
        return res;
    }
}