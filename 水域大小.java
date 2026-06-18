class Solution {
    public int[] pondSizes(int[][] land) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<land.length;i++){
            for(int j = 0;j<land[i].length;j++){
                if(land[i][j]==0)
                list.add(dfs(land,i,j));
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i); 
        }
        Arrays.sort(ans);
        return ans;
    }
    public int dfs(int [][]land,int i, int j){
        if(i<0||i>=land.length||j<0||j>=land[i].length||land[i][j]!=0)
            return 0;
        land[i][j] = -1;
        return 1+dfs(land,i,j+1)+dfs(land,i,j-1)+dfs(land,i-1,j)+dfs(land,i+1,j)+dfs(land,i+1,j+1)+dfs(land,i-1,j-1)+dfs(land,i-1,j+1)+dfs(land,i+1,j-1);
    }
}