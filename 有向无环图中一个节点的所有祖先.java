class Solution {
    int count=0;
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Integer>[] g = new ArrayList[n];
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            g[i] = new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            g[v].add(u);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++)
            visited[j] = false;
            List<Integer> list = new ArrayList<>();
            dfs(g,i,visited,list);
            Collections.sort(list);
            res.add(new ArrayList<>(list));
            count=0;
        }
        return res;
    }
    public void dfs(List<Integer>[] g,int index,boolean[] visited,List<Integer> list){
        if(visited[index])
        return ;
        if(count>0)
        list.add(index);
        visited[index]=true;
        count++;
        for(int i=0;i<g[index].size();i++){
            dfs(g,g[index].get(i),visited,list);
        }
    }
}