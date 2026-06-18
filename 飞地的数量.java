class Solution {
    boolean connect = false;
    int sum = 0;
    int num = 0;
    public int numEnclaves(int[][] grid){
        int count_1 = 0;
        boolean [][]used = new boolean[grid.length][grid[0].length];
        for(int i = 0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    count_1++;
                    if(used[i][j]==false)
                    dfs(grid,i,j,used);
                }
                if(connect == true){
                    sum+=num;
                    connect = false;
                }
                num = 0;
            }
        }
        return count_1 - sum;
    }
    public void dfs(int [][]grid,int i,int j,boolean [][]used){
        if(i<0||i>=grid.length||j>=grid[0].length||j<0){
            connect = true;
            return ;
        }
        if(grid[i][j]==0||used[i][j]==true)
        return ;
        else{
            num++;
            used[i][j]=true;
            dfs(grid,i+1,j,used);
            dfs(grid,i-1,j,used);
            dfs(grid,i,j-1,used);
            dfs(grid,i,j+1,used);
        }
    }
}