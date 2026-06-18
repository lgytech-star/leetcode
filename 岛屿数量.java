class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[i].length;j++){
                if(grid[i][j]=='1'){
                    ans++;
                    dfs(grid,i,j);
                }
            }
        }
        return ans;
    }
    public void dfs(char [][]grid,int i,int j){
        if(i>=0&&i<grid.length&&j>=0&&j<grid[i].length&&grid[i][j]=='1')
        grid[i][j] = '2';
        else
        return ;
        dfs(grid,i+1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
        dfs(grid,i-1,j);
    }
}