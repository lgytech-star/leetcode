class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] cnt = new int[words.length+1];
        int[] ans = new int[queries.length];
        int sum = 0;
        for(int i=0;i<words.length;i++){
            if(yuanyin(words[i])){
                sum++;
            }
            cnt[i+1] = sum;
        }
        for(int i=0;i<queries.length;i++){
            ans[i] = cnt[queries[i][1]+1]-cnt[queries[i][0]];
        }
        return ans;
    }
    public boolean yuanyin(String s){
        int n = s.length()-1;
        if((s.charAt(0)=='a'||s.charAt(0)=='e'||s.charAt(0)=='i'||s.charAt(0)=='o'||s.charAt(0)=='u')&&(s.charAt(n)=='a'||s.charAt(n)=='e'||s.charAt(n)=='i'||s.charAt(n)=='o'||s.charAt(n)=='u'))
        return true;
        return false;
    }
}