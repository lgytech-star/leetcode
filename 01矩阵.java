class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length,n = mat[0].length;
        int [][]ans = new int[m][n];
        int [][]dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        Deque<int[]> q = new ArrayDeque<>();
        int count = 0;
        for(int i = 0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                q.offer(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()){
            int size = q.size();
            count++;
            for(int a = 0; a < size; a++){
                int []cur = q.peek();
                for(int i=0;i<dirs.length;i++){
                    int x = cur[0] + dirs[i][0];
                    int y = cur[1] + dirs[i][1];
                    if(x>=0&&x<m&&y>=0&&y<n&&mat[x][y]==1){
                        ans[x][y] = count;
                        mat[x][y] = 0;
                        q.offer(new int[]{x,y});
                    }
                }
                q.poll();
            }
        }
        return ans;
    }
}