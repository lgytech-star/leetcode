class Solution {
    public String reverseWords(String s) {
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        int i=0,j=0;
        int num = 0;
        while(j<s.length()&&s.charAt(j)!=' '){
            if(isyuanyin(s.charAt(j)))
            sum++;
            j++;
        }
        sb.append(s.substring(0,j));
        if(j==s.length())
        return s;
        sb.append(" ");
        i = j+1;
        j = i;
        while(j<s.length()){
            while(j<s.length()&&s.charAt(j)!=' '){
                if(isyuanyin(s.charAt(j)))
                    num++;
                    j++;
            }
            if(num==sum)
            sb.append(reverse(s.substring(i,j)));
            else
            sb.append(s.substring(i,j));
            if(j<s.length())
            sb.append(" ");
            j++;
            i=j;
            num=0;
        }
        return sb.toString();
    }
    public boolean isyuanyin(char a){
        if(a=='a'||a=='e'||a=='i'||a=='o'||a=='u'){
            return true;
        }
        return false;
    }
    public String reverse(String s){
        StringBuilder sb = new StringBuilder();
        int j = s.length()-1;
        while(j>=0){
        sb.append(s.charAt(j));
        j--;
        }
        return sb.toString();
    }
}