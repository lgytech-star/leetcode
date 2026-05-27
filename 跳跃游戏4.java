class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        boolean []a = new boolean[s.length()];
        a[0] = true;
        if(s.length()==1)
        return true;
        if(s.charAt(s.length()-1)=='1')
        return false;
        int j = 1;
        for(int i=0;i<s.length()&&j<s.length();i++){
            if(a[i]==true&&s.charAt(i)=='0'){
                for(j=Math.max(i+minJump,j);j<=Math.min(s.length()-1,i+maxJump);j++){
                    a[j] = true;
                }
            }
        }
        return a[s.length()-1];
    }
}