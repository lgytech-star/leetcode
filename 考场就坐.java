class ExamRoom {
    TreeSet<Integer> set;
    int size;
    int n;
    public ExamRoom(int n) {
        set = new TreeSet<>();
        this.size = 0;
        this.n = n;
    }
    public int seat() {
        if(size==0){
            set.add(0);
            size++;
            return 0;
        }else if(size==1){
            int x = set.getFirst();
            if((n-1-x)>(x-0)){
            set.add(n-1);
            size++;
            return n-1;
            }
            else{
            set.add(0);
            size++;
            return 0;
            }
        }else{
            List<Integer> a = new ArrayList<>(set);
            int index1 = 0,index2 = 0;
            for(int i=1;i<a.size();i++){
                if((a.get(i)-a.get(i-1))/2>(index2-index1)/2){
                    index1 = a.get(i-1);
                    index2 = a.get(i);
                }
            }
            int first = set.getFirst();
            int last = set.getLast();
            if(!set.contains(n-1)&&(n-1-last)>(index2-index1)/2&&(n-1-last)>(first-0)){
                set.add(n-1);
                size++;
                return n-1;
            }
            if(!set.contains(0)&&(first-0)>=(n-1-last)/2&&(first-0)>=(index2-index1)/2){
                set.add(0);
                size++;
                return 0;
            }
            set.add((index2+index1)/2);
            size++;
            return (index2+index1)/2;
        }
    }
    public void leave(int p) {
        set.remove(p);
        size--;
    }
}