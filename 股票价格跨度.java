class StockSpanner {
    Deque<int[]> q;
    int idx = -1;
    public StockSpanner() {
        q = new ArrayDeque<>();
        q.push(new int[]{-1,Integer.MAX_VALUE});
    }
    public int next(int price) {
        idx++;
        while(!q.isEmpty()&&price>=q.peek()[1]){
            q.pop();
        }
        int ans = idx-q.peek()[0];
        q.push(new int[]{idx,price});
        return ans;
    }
}
