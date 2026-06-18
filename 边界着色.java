class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        boolean [][]used = new boolean[grid.length][grid[0].length]; 
        List<int[]> list = new ArrayList<>();
        dfs(grid,row,col,color,used,row,col,list);
        for(int i=0;i<list.size();i++){
            grid[list.get(i)[0]][list.get(i)[1]] = color;
        }
        return grid;
    }
    public void dfs(int [][]grid,int row,int col,int color,boolean [][]used,int i,int j,List<int[]> list){
        if(i<0||i>=grid.length||j<0||j>=grid[i].length||grid[i][j]!=grid[row][col]||used[i][j]==true)
        return ;
        if(used[i][j]==false&&grid[i][j]==grid[row][col]&&(i+1<grid.length&&grid[i+1][j]!=grid[i][j]||i-1>=0&&grid[i-1][j]!=grid[i][j]||j+1<grid[i].length&&grid[i][j+1]!=grid[i][j]||j-1>=0&&grid[i][j-1]!=grid[i][j]||i+1==grid.length||i==0||j==0||j+1==grid[i].length)){
            list.add(new int[]{i,j});
        }
        used[i][j] = true;
        dfs(grid,row,col,color,used,i+1,j,list);
        dfs(grid,row,col,color,used,i-1,j,list);
        dfs(grid,row,col,color,used,i,j+1,list);
        dfs(grid,row,col,color,used,i,j-1,list);
    }
}