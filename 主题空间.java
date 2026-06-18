class Solution {

    private final int[][] DIRS = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
    private boolean connect = false;

    private int dfs(char[][] grid, int i, int j, char same) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            connect = true;
            return 0;
        }
        if (grid[i][j] != same) {
            return 0;
        }
        grid[i][j] = 'x';
        int area = 1;
        for (int k = 0; k < DIRS.length; k++) {
            int x = i + DIRS[k][0];
            int y = j + DIRS[k][1];
            area += dfs(grid, x, y, same);
        }
        return area;
    }

    public int largestArea(String[] grid) {
        int n = grid.length;
        int m = grid[0].length();
        char[][] g = new char[n][m];
        int p = 0;
        for (String s : grid) {
            g[p++] = s.toCharArray();
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] != '0' && g[i][j] != 'x') {
                    connect = false;
                    int area = dfs(g, i, j, g[i][j]);
                    if (!connect) {
                        res = Math.max(res, area);
                    }
                }
            }
        }
        return res;
    }
}