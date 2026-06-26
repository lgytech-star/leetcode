class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean []used = new boolean[arr.length];
        return dfs(arr,start,used);
    }
    public boolean dfs(int []arr,int i,boolean[] used){
        if(i>=0&&i<arr.length&&arr[i]==0)
        return true;
        if(i<0||i>=arr.length||used[i]==true)
        return false;
        used[i] = true;
        return dfs(arr,i+arr[i],used) || dfs(arr,i-arr[i],used);
    }
}