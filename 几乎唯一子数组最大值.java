class Solution {
    public long maxSum(List<Integer> nums, int m, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int num = 0;
        long sum = 0;
        long ans = 0;
        for(int i=0;i<k;i++){
            if(!map.containsKey(nums.get(i))){
                num++;
            }
            map.put(nums.get(i),map.getOrDefault(nums.get(i),0)+1);
            sum+=nums.get(i);
        }
        if(num>=m)
        ans = sum;
        int i = 1,j=i+k-1;
        while(j<nums.size()){
            sum+=nums.get(j);
            sum-=nums.get(i-1);
            map.put(nums.get(i-1),map.get(nums.get(i-1))-1);
            if(map.get(nums.get(i-1))==0){
                num--;
                map.remove(nums.get(i-1));
            }
            map.put(nums.get(j),map.getOrDefault(nums.get(j),0)+1);
            if(map.get(nums.get(j))==1){
                num++;
            }
            if(num>=m)
            ans = Math.max(ans,sum);
            i++;
            j++;
        }
        return ans;
    }
}