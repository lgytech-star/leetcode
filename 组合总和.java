class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates,target,0,0);
        return res;
    }
    public void backtrack(int []candidates,int target,int sum,int index){
        if(sum>=target){
            if(sum==target)
            res.add(new ArrayList<>(list));
            return ;
        }
        for(int i=index;i<candidates.length;i++){
            sum+=candidates[i];
            list.add(candidates[i]);
            backtrack(candidates,target,sum,i);
            sum-=candidates[i];
            list.remove(list.size()-1);
        }
    }
}