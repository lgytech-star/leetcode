class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0)
        return 0;
        HashSet<Character> set = new HashSet<>();
        int ans = 0;
        int i = 0,j = 0;
        while(j<s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
            }else{
                while(set.contains(s.charAt(j))){
                    set.remove(s.charAt(i));
                    i++;
                }
            }
            ans = Math.max(ans,j-i);
        }
        return ans;
    }
}