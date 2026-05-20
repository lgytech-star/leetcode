class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int [][]dp = new int[m+1][n+1];
        int [][]num = new int[strs.length][2];
        for(int i=0;i<strs.length;i++){
            for(int j=0;j<strs[i].length();j++){
                if(strs[i].charAt(j)=='0')
                num[i][0]++;
                else
                num[i][1]++;
            }
        }   
        for(int i=0;i<strs.length;i++){
            for(int j=m;j>=num[i][0];j--){
                for(int k=n;k>=num[i][1];k--){
                dp[j][k] = Math.max(dp[j-num[i][0]][k-num[i][1]]+1,dp[j][k]);
                }
            }
        }
        return dp[m][n];
    }
}