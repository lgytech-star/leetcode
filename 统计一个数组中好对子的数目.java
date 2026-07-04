class Solution {
    public int countNicePairs(int[] nums) {
        long ans = 0;
        int a = 1000000007;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.get(nums[i]-rev(nums[i]))!=null){
                ans+=map.get(nums[i]-rev(nums[i]));
                map.put(nums[i]-rev(nums[i]),map.get(nums[i]-rev(nums[i]))+1);
            }else{
                map.put(nums[i]-rev(nums[i]),1);
            }
        }
        return (int)(ans%a);
    }
    public int rev(int num){
        int sum = 0;
        while(num>0){
            sum=sum*10+num%10;
            num/=10;
        }
        return sum;
    }
}