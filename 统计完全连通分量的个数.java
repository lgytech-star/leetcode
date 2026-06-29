class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        int ans = 0;
        List<Integer>[] g = new ArrayList[n];
        for(int i=0;i<n;i++){
            g[i] = new ArrayList<>();
        }
        boolean[] visited = new boolean[n];
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            g[u].add(v);
            g[v].add(u);
        }
        for(int i=0;i<n;i++){
            if(visited[i])
            continue;
            int []count = new int[]{0,0};
            dfs(g,i,visited,count);
            if((count[0]*(count[0]-1))==count[1])
            ans++;
        }
        return ans;
    }
    public void dfs(List<Integer>[] g,int index,boolean[] visited,int[] count){
        if(visited[index])
        return ;
        visited[index] = true;
        count[0]++;
        for(int i = 0;i<g[index].size();i++){
            count[1]++;
            dfs(g,g[index].get(i),visited,count);
        }
    }
}