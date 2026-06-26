class Solution {
    int ans = Integer.MAX_VALUE;   

    public int minScore(int n, int[][] roads) {
        List<int[]>[] g = new ArrayList[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < roads.length; i++) {
            int u = roads[i][0] - 1;
            int v = roads[i][1] - 1;
            int w = roads[i][2];
            g[u].add(new int[]{v, w});
            g[v].add(new int[]{u, w});
        }

        dfs(g, 0, visited);
        return ans;
    }

    public void dfs(List<int[]>[] g, int index, boolean[] visited) {
        if (visited[index]) {
            return;
        }
        visited[index] = true;   
        for (int i = 0; i < g[index].size(); i++) {
            int[] edge = g[index].get(i);
            int v = edge[0];
            int w = edge[1];
            if (w < ans) {
                ans = w;
            }
            if (!visited[v]) {
                dfs(g, v, visited);
            }
        }
    }
}