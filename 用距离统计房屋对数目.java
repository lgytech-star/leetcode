class Solution {
    public int[] countOfPairs(int n, int a, int y) {
        List<Integer>[] g = new ArrayList[n];
        for(int i=0;i<n;i++){
            g[i] = new ArrayList<>();
        }
        Deque<Integer> q = new ArrayDeque<>();
        for(int i=0;i<=n-2;i++){
            g[i].add(i+1);
            g[i+1].add(i);
        }
        g[a-1].add(y-1);
        g[y-1].add(a-1);
        int[] ans = new int[n];
        int[] dis = new int[n];
        for(int i=0;i<n;i++){
            Arrays.fill(dis,-1);
            q.offer(i);
            dis[i]=0;
            while(!q.isEmpty()){
                int x = q.poll();
                for(int j=0;j<g[x].size();j++){
                    if(dis[g[x].get(j)]==-1){
                        dis[g[x].get(j)]=dis[x]+1;
                        q.offer(g[x].get(j));
                        ans[dis[g[x].get(j)]-1]++;
                    }
                }
            }
        }
        return ans;
    }
}