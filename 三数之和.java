class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            int a = i+1,b = nums.length-1;
            if(nums[i]>0){
                return res;
            }
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            while(a<b){
                int sum = nums[i]+nums[a]+nums[b];
                if(sum>0){
                    b--;
                }
                else if(sum<0){
                    a++;
                }
                else{
                    while(nums[b]==nums[b-1]&&b>a){
                        b--;
                    }
                    while(nums[a]==nums[a+1]&&b>a){
                        a++;
                    }
                    res.add(Arrays.asList(nums[i],nums[a],nums[b]));
                    a++;
                    b--;
                }
            }
        }
        return res;
    }
}