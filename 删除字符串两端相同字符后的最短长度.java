class Solution {
    public int minimumLength(String s) {
        if(s.length()==1)
        return 1;
        int i = 0,j = s.length()-1;
        while(i<j&&s.charAt(i)==s.charAt(j)){
            while(i<j&&s.charAt(i)==s.charAt(i+1))
                i++;
            while(i<j&&s.charAt(j)==s.charAt(j-1))
                j--;
            i++;
            j--;
        }
        if(j<i)
        return 0;
        return j-i+1;
    }
}