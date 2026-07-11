class Solution {
    public int[] resultsArray(int[][] queries, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->b-a);
        int []ans = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int x = queries[i][0],y = queries[i][1];
            q.offer(Math.abs(x)+Math.abs(y));
            if(q.size()>k){
                q.poll();
            }
            if(q.size()==k)
            ans[i] = q.peek();
            else
            ans[i] = -1;
        }
        return ans;
    }
}