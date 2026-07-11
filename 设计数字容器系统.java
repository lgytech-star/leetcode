class NumberContainers {
    HashMap<Integer,Integer> map1;//index,number
    HashMap<Integer,TreeSet<Integer>> map2;//number,index
    public NumberContainers() {
        map1 = new HashMap<>();
        map2 = new HashMap<>();
    }
    public void change(int index, int number) {
        if(map1.containsKey(index)){
            int prenumber = map1.get(index);
            TreeSet<Integer> set1 = map2.get(prenumber);
            set1.remove(index);
            if(set1.isEmpty())
            map2.remove(prenumber);
        }
        if(!map2.containsKey(number)){
            map2.put(number,new TreeSet<>());
        }
        TreeSet<Integer> set2 = map2.get(number);
        set2.add(index);
        map1.put(index,number);
    }
    public int find(int number) {
        if(map2.containsKey(number)){
            return map2.get(number).getFirst();
        }
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */