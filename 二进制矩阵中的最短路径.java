class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length,n = grid[0].length;
        boolean [][]visited = new boolean[m][n];
        if(grid[0][0]==1)
        return -1;
        int [][]dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{-1,1},{1,-1},{1,1},{-1,-1}};
        int ans = 0;
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0});
        while(!q.isEmpty()){
            int size = q.size();
            for(int a = 0;a<size;a++){
                for(int i=0;i<dirs.length;i++){
                    int []cur = new int[]{q.peek()[0],q.peek()[1]};
                    if(cur[0]==m-1&&cur[1]==n-1)
                    return ans+1;
                    int x = cur[0] + dirs[i][0];
                    int y = cur[1] + dirs[i][1];
                    if(x>=0&&x<m&&y>=0&&y<n&&visited[x][y]==false&&grid[x][y]==0){
                        q.offer(new int[]{x,y});
                        visited[x][y] = true;
                    }
                }
                q.poll();
            }
            ans++;
        }
        return -1;
    }
}