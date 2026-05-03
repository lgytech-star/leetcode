class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int []a = new int[n-k+1];
        Deque<Integer> q = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            while(!q.isEmpty()&&nums[q.getLast()]<=nums[i]){
                q.removeLast();
            }
            q.addLast(i);
            int left = i-k+1;
            if(q.getFirst()<left){
                q.removeFirst();
            }
            if(left>=0){
                a[left] = nums[q.getFirst()];
            }
        }
        return a;
    }
}