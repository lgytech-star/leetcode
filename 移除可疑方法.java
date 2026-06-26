class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer>[] g = new ArrayList[n];
        for(int i=0;i<n;i++){
            g[i] = new ArrayList<>();
        }
        boolean []visited = new boolean[n];
        for(int i=0;i<invocations.length;i++){
            int u = invocations[i][0];
            int v = invocations[i][1];
            g[u].add(v);
        }
        List<Integer> res = new ArrayList<>(); 
        dfs(g,k,visited);
        for(int i=0;i<invocations.length;i++){
            int u = invocations[i][0];
            int v = invocations[i][1];
            if(!visited[u]&&visited[v]){
                for(int j=0;j<n;j++){
                    res.add(j);
                }
                return res;
            }
        }
        for(int i=0;i<n;i++){
            if(!visited[i])
            res.add(i);
        }
        return res;
    }
    public void dfs(List<Integer>[] g,int index,boolean[] used){
        if(used[index])
        return ;
        used[index] = true;
        for(int i=0;i<g[index].size();i++){
            dfs(g,g[index].get(i),used);
        }
    }
}