class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length, n = grid1[0].length;
        boolean[][] visited = new boolean[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1 && !visited[i][j]) {
                    boolean[] isSub = new boolean[]{true};
                    dfs(grid1, grid2, i, j, visited, isSub);
                    if (isSub[0]) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] grid1, int[][] grid2, int i, int j,
                     boolean[][] visited, boolean[] isSub) {
        if (i < 0 || i >= grid1.length || j < 0 || j >= grid1[0].length
            || grid2[i][j] == 0 || visited[i][j]) {
            return;
        }

        visited[i][j] = true;
        if (grid1[i][j] == 0) {
            isSub[0] = false;
        }

        dfs(grid1, grid2, i + 1, j, visited, isSub);
        dfs(grid1, grid2, i - 1, j, visited, isSub);
        dfs(grid1, grid2, i, j + 1, visited, isSub);
        dfs(grid1, grid2, i, j - 1, visited, isSub);
    }
}