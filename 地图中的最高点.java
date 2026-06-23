class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length,n = isWater[0].length;
        int count = 0;
        Deque<int[]> q = new ArrayDeque<>();
        int [][]dirs = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
        int [][]ans = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(isWater[i][j]==1){
                    q.offer(new int[]{i,j});
                }
            }
        }
        while(!q.isEmpty()){
            int size = q.size();
            count++;
            for(int a = 0;a < size;a++){
                int []cur = q.peek();
                for(int i = 0;i < dirs.length;i++){
                    int x = cur[0] + dirs[i][0]; 
                    int y = cur[1] + dirs[i][1];
                    if(x>=0&&x<m&&y>=0&&y<n&&isWater[x][y]==0){
                            ans[x][y] = count;
                            isWater[x][y] = 1;
                            q.offer(new int[]{x,y});
                    }
                }
                q.poll();
            }
        }
        return ans;
    }
}