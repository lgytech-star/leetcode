class Solution {
    public int[][] generateMatrix(int n) {
        int up=0,left=0,right = n-1,down = n-1;
        int num = 1;
        int [][] a = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=left;j<=right;j++){
                a[up][j] = num;
                num++;
            }
            up++;
            if(left>right||up>down)
                break;
            for(int j=up;j<=down;j++){
                a[j][right] = num;
                num++;
            }
            right--;
            if(left>right||up>down)
                break;
            for(int j=right;j>=left;j--){
                a[down][j] = num;
                num++;
            }
            down--;
            if(left>right||up>down)
                break;
            for(int j=down;j>=up;j--){
                a[j][left]=num;
                num++;
            }
            left++;
            if(left>right||up>down)
                break;
        }
        return a;
    }
}