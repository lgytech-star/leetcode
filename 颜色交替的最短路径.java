class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        ans[0] = 0;
        List<int[]>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < redEdges.length; i++) {
            int u = redEdges[i][0];
            int v = redEdges[i][1];
            g[u].add(new int[]{v, 0});
        }
        for (int i = 0; i < blueEdges.length; i++) {
            int u = blueEdges[i][0];
            int v = blueEdges[i][1];
            g[u].add(new int[]{v, 1});
        }
        int[][] dis = new int[n][2];
        for (int i = 0; i < n; i++) {
            dis[i][0] = -1;
            dis[i][1] = -1;
        }
        dis[0][0] = 0;
        dis[0][1] = 0;
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        q.offer(new int[]{0, 1}); 

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int color = cur[1];       

            for (int i = 0; i < g[x].size(); i++) {
                int[] edge = g[x].get(i);
                int y = edge[0];
                int nextColor = edge[1];
                if (nextColor == color) continue;
                if (dis[y][nextColor] != -1) continue;
                dis[y][nextColor] = dis[x][color] + 1;
                q.offer(new int[]{y, nextColor});
            }
        }

        for (int i = 0; i < n; i++) {
            if (dis[i][0] != -1 && dis[i][1] != -1) {
                ans[i] = Math.min(dis[i][0], dis[i][1]);
            } else if (dis[i][0] != -1) {
                ans[i] = dis[i][0];
            } else if (dis[i][1] != -1) {
                ans[i] = dis[i][1];
            }
        }
        return ans;
    }
}