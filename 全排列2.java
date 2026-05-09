class Solution {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean []used = new boolean[nums.length];
        backtrack(nums,used);
        return res;
    }
    public void backtrack(int []nums,boolean []used){
        if(path.size()==nums.length){
            res.add(new ArrayList<>(path));
            return ;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]==true||i>0&&nums[i]==nums[i-1]&&used[i-1]==false){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtrack(nums,used);
            path.remove(path.size()-1);
            used[i]=false;
        }
    }
}