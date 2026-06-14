class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int []ans = new int[nums.length];
        Arrays.fill(ans,-1);
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0 ;i < nums.length*2;i++){
            while(!queue.isEmpty()&&nums[i%nums.length]>nums[queue.peek()]){
                    ans[queue.peek()] = nums[i%nums.length];
                    queue.pop();
            }
            if(i<nums.length)
            queue.push(i);
        }
        return ans;
    }
}