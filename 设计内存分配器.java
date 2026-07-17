class Allocator {
    int []allocater;
    public Allocator(int n) {
        allocater = new int[n];
    }
    public int allocate(int size, int mID) {
        int free = 0;
        for(int i=0;i<allocater.length;i++){
           if (allocater[i] > 0) { 
                free = 0;
                continue;
            }
            free++;
            if (free == size) { // 找到了
                Arrays.fill(allocater, i - size + 1, i + 1, mID);
                return i - size + 1;
            }
        }
        return -1; 
    }
    
    public int freeMemory(int mID) {
        int ans = 0;
        for(int i=0;i<allocater.length;i++){
            if(allocater[i]==mID){
                ans++;
                allocater[i] = 0;
            }
        }
        return ans;
    }
}

/**
 * Your Allocator object will be instantiated and called as such:
 * Allocator obj = new Allocator(n);
 * int param_1 = obj.allocate(size,mID);
 * int param_2 = obj.freeMemory(mID);
 */