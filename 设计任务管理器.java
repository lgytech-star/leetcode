class TaskManager {
    PriorityQueue<List<Integer>> queue;
    HashMap<Integer,int[]> map;
    public TaskManager(List<List<Integer>> tasks) {
        map = new HashMap<>();
        queue = new PriorityQueue<>((a, b) -> {
            // 先按优先级降序
            int priorityCmp = Integer.compare(b.get(2), a.get(2));
            if (priorityCmp != 0) {
                return priorityCmp;
            }
            // 优先级相同，按taskId降序
            return Integer.compare(b.get(1), a.get(1));
        });
        for(int i=0;i<tasks.size();i++){
            queue.add(tasks.get(i));
            int userId = tasks.get(i).get(0),taskId = tasks.get(i).get(1),priority = tasks.get(i).get(2);
            map.put(taskId,new int[]{userId,priority});
        }
    }
    public void add(int userId, int taskId, int priority){
        map.put(taskId,new int[]{userId,priority});
        List<Integer> list = new ArrayList<>();
        list.add(userId);
        list.add(taskId);
        list.add(priority);
        queue.add(new ArrayList<>(list));
    }
    public void edit(int taskId, int newPriority) {
        int userId = map.get(taskId)[0];
        map.put(taskId,new int[]{userId,newPriority});
        List<Integer> list = new ArrayList<>();
        list.add(userId);
        list.add(taskId);
        list.add(newPriority);
        queue.offer(new ArrayList<>(list));
    }
    public void rmv(int taskId) {
        map.remove(taskId);
    }
    public int execTop(){
        while(!queue.isEmpty()){
            List<Integer> list = queue.poll();
            int userId = list.get(0);
            int taskId = list.get(1);
            int priority = list.get(2);
            if(map.containsKey(taskId)){
                if(map.get(taskId)[1]==priority&&map.get(taskId)[0]==userId){
                    map.remove(taskId);
                    return userId;
                }
            }
        }
        return -1;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */