class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1)
        return -1;
        List<Integer>[] graph = new ArrayList[n];
        int count = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<connections.length;i++){
            int x = connections[i][0];
            int y = connections[i][1];
            graph[x].add(y);
            graph[y].add(x);
        }
        for(int i=0;i<n;i++){
            if(visited[i])
            continue;
            dfs(graph,visited,i);
            count++;
        }
        return count-1;
    }
    public void dfs(List<Integer>[] graph,boolean []visited,int index){
        if(visited[index])
        return ;
        visited[index] = true;
        for(int i = 0;i<graph[index].size();i++){
            dfs(graph,visited,graph[index].get(i));
        }
    }
}