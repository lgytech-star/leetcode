class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int ans = 0;
        int flag = 0;
        Deque<int[]> q = new ArrayDeque<>();
        int [][]dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        boolean [][]visited = new boolean[maze.length][maze[0].length];
        q.offer(new int[]{entrance[0],entrance[1]});
        visited[entrance[0]][entrance[1]] = true;
        while(!q.isEmpty()){
        int size = q.size();
        for(int a=0;a<size;a++){
            for(int i=0;i<dirs.length;i++){
                int []cur = new int[]{q.peek()[0],q.peek()[1]};
                int x = dirs[i][0] + cur[0];
                int y = dirs[i][1] + cur[1];
                if((cur[0]==0||cur[0]==maze.length-1||cur[1]==0||cur[1]==maze[0].length-1)&&!(cur[0]==entrance[0]&&cur[1]==entrance[1]))
                return ans;
                if(x>=0&&x<maze.length&&y>=0&&y<maze[0].length&&maze[x][y]!='+'&&!visited[x][y]){
                visited[x][y] = true;
                q.offer(new int[]{x,y});
                }
            }
            q.poll();
        }
            ans++;
        } 
        return -1;
    }
}