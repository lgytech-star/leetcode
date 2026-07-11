class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->b-a);
        int ans = 0;
        for(int i=0;i<piles.length;i++){
            q.offer(piles[i]);
        }
        for(int i=0;i<k;i++){
            int x = q.poll();
            x = (x+1)/2;
            q.offer(x);
        }
        while(!q.isEmpty()){
            ans+=q.poll();
        }
        return ans;
    }
}