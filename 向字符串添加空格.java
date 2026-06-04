class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder(s);
        int num=1;
        for(int i=0;i<spaces.length;i++){
            if(i>0){
            spaces[i]+=num;
            num++;
            }
            sb.insert(spaces[i],' ');
        }
        return sb.toString();
    }
}