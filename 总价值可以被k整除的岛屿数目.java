class Solution {
    public int countIslands(int[][] grid, int k) {
        boolean [][]used = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[i].length;j++){
                long sum = 0;
                if(grid[i][j]!=0&&used[i][j]==false){
                sum = dfs(grid,i,j,used);
                if(sum%k==0)
                ans++;
                }
            }
        }
        return ans;
    }
    public long dfs(int [][]grid,int i,int j,boolean [][]used){
        if(i<0||i>=grid.length||j>=grid[i].length||j<0||used[i][j]==true||grid[i][j]==0){
            return 0;
        }
        else
        used[i][j] = true;
        return grid[i][j] + dfs(grid,i,j+1,used) + dfs(grid,i,j-1,used) + dfs(grid,i+1,j,used) + dfs(grid,i-1,j,used);
    }
}