class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(k,n,1,0);
        return res;
    }
    public void backtrack(int k,int n,int index,int sum){
        if(list.size()==k){
            if(sum==n)
            res.add(new ArrayList<>(list));
            return ;
        }
        for(int i=index;i<=9;i++){
            sum+=i;
            list.add(i);
            backtrack(k,n,i+1,sum);
            sum-=list.get(list.size()-1);
            list.remove(list.size()-1);
        }
    }
}