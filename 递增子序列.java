class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    HashSet<List<Integer>> set= new HashSet<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backtrack(nums,0);
        return res;
    }
    public void backtrack(int []nums,int index){
        if(path.size()>=2&&!set.contains(path)){
        res.add(new ArrayList<>(path));
        set.add(new ArrayList<>(path));
        }
        for(int i=index;i<nums.length;i++){
            if(path.size()==0||nums[i]>=path.get(path.size()-1)){
                path.add(nums[i]);
                backtrack(nums,i+1);
                path.remove(path.size()-1);
            }
        }
    }
}