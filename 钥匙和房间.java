class Solution {
    int num = 0;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean []used = new boolean[rooms.size()];
        dfs(rooms,0,used);
        if(num==rooms.size())
        return true;
        return false;
    }
    public void dfs(List<List<Integer>> rooms,int i,boolean[] used){
        if(used[i]==false){
            used[i] = true;
            num++;
            for(int j = 0;j<rooms.get(i).size();j++){
                dfs(rooms,rooms.get(i).get(j),used);
            }
        }
    }
}