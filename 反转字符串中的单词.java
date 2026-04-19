class Solution {
    public String reverseWords(String s) {
        int i=0,j=s.length()-1;
        while(i<s.length()&&s.charAt(i)==' '){
            i++;
        }
        while(j>=0&&s.charAt(j)==' '){
            j--;
        }
        s = s.substring(i,j+1);
        j = s.length()-1;
        i = j;
        StringBuilder sb = new StringBuilder();
        while(i>=0){
            while(i>=0&&s.charAt(i)!=' '){
                i--;
            }
            sb.append(s.substring(i+1,j+1)+" ");
            while(i>=0&&s.charAt(i)==' '){
                i--;
            }
            j=i;
        }
        return sb.toString().substring(0,sb.length()-1);
    }

}