class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int ans = 100001;
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.get(nums[i])==null){
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i],new ArrayList<>(list));
            }else{
                List<Integer> list = map.get(nums[i]);
                list.add(i);
            }
        }
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(reverse(nums[i]))){
                int x = lowerbound(map.get(reverse(nums[i])),i+1);
                if(x<map.get(reverse(nums[i])).size())
                ans = Math.min(ans,map.get(reverse(nums[i])).get(x)-i);
            }
        }
        if(ans!=100001)
        return ans;   
        return -1;
    }
    public int lowerbound(List<Integer> list,int target){
        int left = 0,right = list.size()-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(list.get(mid)<target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }
    public int reverse(int num){
        List<Integer> list = new ArrayList<>();
        int temp = 1;
        int sum = 0;
        while(num>0){
            int a = num%10;
            list.add(a);
            num/=10; 
        }
        for(int i=list.size()-1;i>=0;i--){
            sum+=list.get(i)*temp;
            temp*=10;
        }
        return sum;
    }
}