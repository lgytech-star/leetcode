class Solution {
    public int findCircleNum(int[][] isConnected) {
        int m = isConnected.length,n = isConnected[0].length;
        int ans = 0;
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(isConnected[i][j]==1){
                    dfs(isConnected,i,j);
                    ans++;
                }
            }
        }
        return ans;
    }
    public void dfs(int [][]isConnected,int i,int j){
        if(i>=0&&i<isConnected.length&&j>=0&&j<isConnected[0].length&&isConnected[i][j]==1){
            isConnected[i][j] = 2;
        }else
        return ;
        dfs(isConnected,i+1,j);
        dfs(isConnected,i-1,j);
        dfs(isConnected,i,j+1);
        dfs(isConnected,i,j-1);
    }
}