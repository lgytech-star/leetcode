class Solution {
    public long countPairs(int n, int[][] edges) {
        boolean[] used = new boolean[n];
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            map.get(u).add(v);
            map.get(v).add(u);
        }
        long ans = 0;
        long precount = 0;
        for(int i=0;i<n;i++){
            if(used[i])
            continue;
            List<Integer> path = new ArrayList<>();
            dfs(map,used,i,path);
            long cursize = path.size();
            ans += cursize * precount;
            precount+=cursize;
        }
        return ans;
    }
    public void dfs(HashMap<Integer,List<Integer>> map,boolean []used,int i,List<Integer> path){
        if(used[i])
        return ;
        List<Integer> list = map.get(i);
        used[i] = true;
        path.add(i);
        for(int j=0;j<list.size();j++){
            dfs(map,used,list.get(j),path);
        }
    }
}