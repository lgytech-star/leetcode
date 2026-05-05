class Solution {
    List<String> path = new ArrayList<>();
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtrack(s,0);
        return res;
    }
    public void backtrack(String s,int index){
        if(index>=s.length()){
            res.add(new ArrayList<>(path));
            return ;
        }
        for(int i=index;i<s.length();i++){
            if(ishuiwen(s,index,i)){
                path.add(s.substring(index,i+1));
                backtrack(s,i+1);
                path.remove(path.size()-1);
            }else{
                continue;
            }
        }
    }
    public boolean ishuiwen(String s,int i,int j){
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j))
            return false;
            i++;
            j--; 
        }
        return true;
    }
}