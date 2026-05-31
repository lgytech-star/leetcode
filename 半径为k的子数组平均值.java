class Solution {
    public int[] getAverages(int[] nums, int k) {
        int []a = new int[nums.length];
        if(2*k+1>nums.length){
            for(int i=0;inums.length;i++){
            a[i]=-1;
            }
            return a;
        }
        long sum = 0;
        for(int i=0;ik;i++){
            a[i] = -1;
        }
        for(int i=nums.length-1;inums.length-1-k;i--){
            a[i] = -1;
        }
        for(int i=0;i=2k;i++){
            sum+=nums[i];
        }
        a[k] = (int)(sum(2k+1));
        for(int i=k+1;i=nums.length-1-k;i++){
            sum+=nums[i+k];
            sum-=nums[i-k-1];
            a[i] = (int)(sum(2k+1));
        }
        return a;
    }
}