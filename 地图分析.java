class Solution {
    public int maxDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        if (queue.isEmpty() || queue.size() == m * n) {
            return -1;
        }

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int distance = -1; 
        while (!queue.isEmpty()) {
            int size = queue.size();
            distance++; // 每层距离 +1
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 0) {
                        grid[x][y] = distance + 1; 
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
        return distance;
    }
}