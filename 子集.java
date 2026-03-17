class Solution {
    List<Integer> list = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        dfs(0,nums);
        return res;
    }
    public void dfs(int startindex,int []nums){
                res.add(new ArrayList<>(list));
                for(int i=startindex;i<nums.length;i++){
                    list.add(nums[i]);
                    dfs(i+1,nums);
                    list.remove(list.size()-1);
                }
    }
}