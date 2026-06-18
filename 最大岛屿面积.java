class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                int[] sum = new int[1]; 
                if(grid[i][j]==1)
                dfs(grid, i, j, sum);
                ans = Math.max(ans, sum[0]);
            }    
        }
        return ans;
    }
    public void dfs(int [][]grid,int i,int j,int []sum){
        if(i>=0&&i<grid.length&&j>=0&&j<grid[i].length&&grid[i][j]==1){
            grid[i][j] = 2;
            sum[0]++;
        }else
        return ;
        dfs(grid,i,j+1,sum);
        dfs(grid,i,j-1,sum);
        dfs(grid,i-1,j,sum);
        dfs(grid,i+1,j,sum);
    }
}