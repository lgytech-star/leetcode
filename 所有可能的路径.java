class Solution {
    List<Integer> list = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dfs(graph,0);
        return res;
    }
    public void dfs(int [][]graph,int i){
        list.add(i);
        if(list.size()>0&&list.get(list.size()-1)==graph.length-1){
        res.add(new ArrayList<>(list));
        }
        for(int j=0;j<graph[i].length;j++){
            dfs(graph,graph[i][j]);
        }
        list.remove(list.size()-1);
    }
}