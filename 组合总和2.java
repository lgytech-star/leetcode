class Solution {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        boolean []used = new boolean[candidates.length];
        backtrack(candidates,target,0,used,0);
        return res;
    }
    public void backtrack(int []candidates,int target,int sum,boolean []used,int index){
        if(sum>=target){
            if(sum==target)
            res.add(new ArrayList<>(path));
            return ;
        }
        for(int i=index;i<candidates.length;i++){
            if(i>index&&candidates[i]==candidates[i-1]&&used[i]==false)
            continue ;
            sum+=candidates[i];
            used[i]=true;
            path.add(candidates[i]);
            backtrack(candidates,target,sum,used,i+1);
            sum-=candidates[i];
            used[i] = false;
            path.remove(path.size()-1);
        }
    }
}