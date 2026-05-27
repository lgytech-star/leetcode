class Solution {
    public int numberOfSpecialChars(String word) {
        int upper[] = new int[26];
        int lower[] = new int[26];
        for(int i=0;i<26;i++){
            lower[i]=-1;
            upper[i]=-1;
        }
        for(int i=0;i<word.length();i++){
            if(word.charAt(i)>='A'&&word.charAt(i)<='Z'){
                if(upper[word.charAt(i)-'A']==-1)
                upper[word.charAt(i)-'A']=i; 
            }else{
                lower[word.charAt(i)-'a']=i;
            }
        }
        int count = 0;
        for(int i=0;i<26;i++){
            if(upper[i]!=-1&&lower[i]!=-1&&upper[i]>lower[i])
            count++;
        }
        return count;
    }
}