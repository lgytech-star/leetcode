class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        if(nums[0]>=0){
            if(k%2!=0)
            nums[0] = (-1)*nums[0];
            for(int i=0;i<nums.length;i++){
                sum+=nums[i];
            }
            return sum;
        }
        int i=0;
        while(k>0&&i<nums.length){
            if(nums[i]<0){
                k--;
                nums[i] = (-1)*nums[i];
                i++;
            }else{
                break;
            }
        }
        if(k>0&&nums.length==i){
            if(k%2!=0){
                nums[i-1] = -nums[i-1];
            }
             for(int j=0;j<nums.length;j++){
                sum+=nums[j];
        }
            return sum;
        }
        if(k%2!=0&&i<nums.length){
            if(Math.abs(nums[i])>Math.abs(nums[i-1]))
                nums[i-1] = (-1)*nums[i-1];
            else
                nums[i] = nums[i]*(-1);
        }
        for(int j=0;j<nums.length;j++){
                sum+=nums[j];
        }
            return sum;
    }
}