class Solution {
    public int shortestBridge(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int [][]dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        Deque<int[]> q = new ArrayDeque<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    dfs(grid,i,j,q);
                    int ans = 0;
                    while(!q.isEmpty()){
                        int size = q.size();
                        for(int a = 0;a<size;a++){
                            int []cur = q.peek();
                            for(int k = 0;k<dirs.length;k++){
                                int x = cur[0] + dirs[k][0];
                                int y = cur[1] + dirs[k][1];
                                if(x>=0&&x<m&&y>=0&&y<n&&grid[x][y]==1)
                                return ans;
                                if(x>=0&&x<m&&y>=0&&y<n&&grid[x][y]!=-1){
                                    q.offer(new int[]{x,y});
                                    grid[x][y] = -1;
                                }
                            }
                            q.poll();
                        }
                        ans++;
                    }
                }
            }
        }
        return 0;
    }
    public void dfs(int [][]grid,int i,int j,Deque<int[]> q){
        if(i>=0&&i<grid.length&&j>=0&&j<grid.length&&grid[i][j]==1){
        grid[i][j] = -1;
        q.offer(new int[]{i,j});
        }
        else
        return ;
        dfs(grid,i+1,j,q);
        dfs(grid,i-1,j,q);
        dfs(grid,i,j+1,q);
        dfs(grid,i,j-1,q);
    }
}