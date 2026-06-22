class Solution {
    private boolean flag = false;

    public boolean hasValidPath(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        dfs(grid, 0, 0, visited);
        return flag;
    }

    private void dfs(int[][] grid, int i, int j, boolean[][] visited) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            flag = true;
            return;
        }

        visited[i][j] = true;
        int type = grid[i][j];
        if (type == 1) { 
            if (j + 1 < grid[0].length && !visited[i][j + 1]) {
                int next = grid[i][j + 1];
                if (next == 1 || next == 3 || next == 5) {
                    dfs(grid, i, j + 1, visited);
                }
            }
            if (j - 1 >= 0 && !visited[i][j - 1]) {
                int next = grid[i][j - 1];
                if (next == 1 || next == 4 || next == 6) {
                    dfs(grid, i, j - 1, visited);
                }
            }
        } 
        else if (type == 2) { 
            if (i + 1 < grid.length && !visited[i + 1][j]) {
                int next = grid[i + 1][j];
                if (next == 2 || next == 5 || next == 6) {
                    dfs(grid, i + 1, j, visited);
                }
            }
            if (i - 1 >= 0 && !visited[i - 1][j]) {
                int next = grid[i - 1][j];
                if (next == 2 || next == 3 || next == 4) {
                    dfs(grid, i - 1, j, visited);
                }
            }
        }
        else if (type == 3) {
            if (i + 1 < grid.length && !visited[i + 1][j]) {
                int next = grid[i + 1][j];
                if (next == 2 || next == 5 || next == 6) {
                    dfs(grid, i + 1, j, visited);
                }
            }
            if (j - 1 >= 0 && !visited[i][j - 1]) {
                int next = grid[i][j - 1];
                if (next == 1 || next == 4 || next == 6) {
                    dfs(grid, i, j - 1, visited);
                }
            }
        }
        else if (type == 4) { 
            if (i + 1 < grid.length && !visited[i + 1][j]) {
                int next = grid[i + 1][j];
                if (next == 2 || next == 5 || next == 6) {
                    dfs(grid, i + 1, j, visited);
                }
            }
            if (j + 1 < grid[0].length && !visited[i][j + 1]) {
                int next = grid[i][j + 1];
                if (next == 1 || next == 3 || next == 5) {
                    dfs(grid, i, j + 1, visited);
                }
            }
        }
        else if (type == 5) { 
            if (i - 1 >= 0 && !visited[i - 1][j]) {
                int next = grid[i - 1][j];
                if (next == 2 || next == 3 || next == 4) {
                    dfs(grid, i - 1, j, visited);

                }
            }
            if (j - 1 >= 0 && !visited[i][j - 1]) {
                int next = grid[i][j - 1];
                if (next == 1 || next == 4 || next == 6) {
                    dfs(grid, i, j - 1, visited);
                }
            }
        }
        else if (type == 6) { 
            if (i - 1 >= 0 && !visited[i - 1][j]) {
                int next = grid[i - 1][j];
                if (next == 2 || next == 3 || next == 4) {
                    dfs(grid, i - 1, j, visited);
                }
            }
            if (j + 1 < grid[0].length && !visited[i][j + 1]) {
                int next = grid[i][j + 1];
                if (next == 1 || next == 3 || next == 5) {
                    dfs(grid, i, j + 1, visited);
                }
            }
        }
    }
}