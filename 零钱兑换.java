class Solution {
    public int coinChange(int[] coins, int amount) {
        int []dp = new int[amount+1];
        int n = coins.length;
        dp[0] = 0;
        for(int i=1;i<=amount;i++){
            dp[i] = amount+1;
        }
        for(int i = 0;i<coins.length;i++){
            for(int j=1;j<=amount;j++){
                if(j>=coins[i])
                dp[j] = Math.min(dp[j],dp[j-coins[i]]+1);
            }
        }
        if(dp[amount]==amount+1)
        return -1;
        else
        return dp[amount];  
    }
}