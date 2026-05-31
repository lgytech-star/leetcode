class Solution {
    public int maxVowels(String s, int k) {
        int num = 0;
        for(int i=0;i<k;i++){
            if(isaeiou(s.charAt(i)))
            num++;
        }
        int i=0,j=i+k-1;
        int max = num;
        while(j<s.length()){
            if(i==0){
                i++;
                j++;
                continue;
            }
            if(isaeiou(s.charAt(i-1)))
            num--;
            if(isaeiou(s.charAt(j)))
            num++;
            max=Math.max(max,num);
            i++;
            j++;
        }
        return max;
    }
    public boolean isaeiou(char a){
        if(a=='i'||a=='e'||a=='a'||a=='o'||a=='u')
        return true;
        return false;
    }
}