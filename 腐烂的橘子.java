class Solution {
    public int orangesRotting(int[][] grid) {
        int ans = 0;
        int num = 0;
        Deque<int[]> q = new ArrayDeque<>();
        int m = grid.length,n = grid[0].length;
        int [][]dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        boolean [][]used = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                   q.offer(new int[]{i,j});
                }
                if(grid[i][j]==1){
                    num++;
                }
            }
        }
        while(!q.isEmpty()&&num>0){
            int size = q.size();
            for(int a = 0; a<size;a++){
                 int []cur = new int[]{q.peek()[0],q.peek()[1]};
                 for(int i=0;i<dirs.length;i++){
                    int x = cur[0] + dirs[i][0];
                    int y = cur[1] + dirs[i][1];
                    if(x>=0&&x<m&&y>=0&&y<n&&grid[x][y]==1){
                        q.offer(new int[]{x,y});
                        grid[x][y] = 2;
                        num--;
                    }
                 }
                 q.poll();
            }
            ans++;
        }
        if(num==0)
        return ans;
        else
        return -1;
    }
    
}