class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;int m = queries.length;
        int[] sum = new int[n+1];
        for(int i=1;i<=n;i++){
            sum[i] = sum[i-1]^arr[i-1];
        }
        int[] ans = new int[m];
        for(int i=0;i<m;i++){
            ans[i] = sum[queries[i][1]+1]^sum[queries[i][0]];
        }
        return ans;
    }
}