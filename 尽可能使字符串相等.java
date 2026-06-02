class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int i = 0,j = 0;
        char []s1 = s.toCharArray();
        char []t1 = t.toCharArray();
        boolean []used = new boolean[s.length()];
        int sum = 0;
        int ans = 0;
        while(j<s.length()){
            sum+=Math.abs(s1[j]-t1[j]);
            while(sum>maxCost){
                sum-=Math.abs(s1[i]-t1[i]);
                i++;
            }
            ans = Math.max(j-i+1,ans);
            j++;
        }
        return ans;
    }
}