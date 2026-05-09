class Solution {
    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        backtrack(s,0,0);
        return res;
    }
    private  void backtrack(String s,int index,int point){
        if(point==3){
            if(isValid(s,index,s.length()-1)){
            res.add(s);
            }
            return ;
        }
        for(int i=index;i<s.length();i++){
            if(isValid(s,index,i)){
                s=s.substring(0,i+1)+"."+s.substring(i+1);
                point++;
                backtrack(s,i+2,point);
                point--;
                s=s.substring(0,i+1)+s.substring(i+2);
            } else
            break;
        }
    }
    private  boolean isValid(String s,int start,int end){
        int num = 0;
        if(start>end){
            return false;
        }
        if(s.charAt(start)=='0'&&start!=end)
            return false;
        for(int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') { // 遇到⾮数字字符不合法
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) { // 如果⼤于255了不合法
                return false;
            }
        }
         return true;
    }
}
