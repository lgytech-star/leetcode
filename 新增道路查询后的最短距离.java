class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<Integer>[] g = new ArrayList[n];
        for(int i=0;i<n;i++){
            g[i] = new ArrayList<>();
        } 
        for(int i=0;i<=n-2;i++){
            g[i].add(i+1);
        }
        int []dis = new int[n];
        int []ans = new int[queries.length];
        Deque<Integer> q = new ArrayDeque<>();
        for(int i=0;i<queries.length;i++){
            Arrays.fill(dis, -1);
            int u = queries[i][0];
            int v = queries[i][1];
            g[u].add(v);
            q.offer(0);
            dis[0] = 0;
            while(!q.isEmpty()){
                int x = q.poll();
                for(int j=0;j<g[x].size();j++){
                    if(dis[g[x].get(j)]==-1){
                    dis[g[x].get(j)] = dis[x]+1;
                    q.offer(g[x].get(j));
                    }
                }
            }
            ans[i] = dis[n-1];
        }
        return ans;
    }
}