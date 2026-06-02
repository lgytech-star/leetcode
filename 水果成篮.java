class Solution {
    public int totalFruit(int[] fruits) {
        int i=0,j=0;
        int num = 0;
        int ans = 0;
        int []nums = new int[fruits.length];
        while(j<nums.length){
           nums[fruits[j]]++;
           if(nums[fruits[j]]==1)
           num++;
            while(num>2){
                nums[fruits[i]]--;
                if(nums[fruits[i]]==0)
                num--;
                i++;
            }
            ans = Math.max(ans,j-i+1);
            j++;
    }
     return ans;
    }
}