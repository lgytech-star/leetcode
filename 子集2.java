class Solution {
    List<Integer> path=new ArrayList<>();
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        boolean []used = new boolean[nums.length];
        Arrays.sort(nums);
        ziji(nums,0,used);
        return result;
    }
    public void ziji(int nums[],int startindex,boolean []used)
    {
        if(path.size()>nums.length)
        {
            return ;
        }
        result.add(new ArrayList<>(path));
        for(int i=startindex;i<nums.length;i++){
            if(i>startindex&&nums[i]==nums[i-1]&&used[i-1]==false)
            continue;
            path.add(nums[i]);
            used[i]=true;
            ziji(nums,i+1,used);
            path.remove(path.size()-1);
            used[i]=false;
        }
    }
}