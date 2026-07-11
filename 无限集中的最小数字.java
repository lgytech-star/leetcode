class SmallestInfiniteSet {
    int min;
    TreeSet<Integer> set;
    public SmallestInfiniteSet() {
        set = new TreeSet<>();
        min = 1;
    }
    
    public int popSmallest() {
        if(set.isEmpty()){
            int ans = min;
            min++;
            return ans;
        }
        int ans = set.pollFirst();
        return ans;
    }
    public void addBack(int num) {
        if(num<min){
            set.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */