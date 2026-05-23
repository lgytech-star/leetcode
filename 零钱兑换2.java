class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int [][]dp = new int[n][amount+1];
        for(int i=1;i<=amount;i++){
            if(i%coins[0]==0)
            dp[0][i] = 1;
        }
        for(int i=0;i<n;i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=amount;j++){
                if(j>=coins[i])
               dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i]];
               else
               dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n-1][amount];
    }
}