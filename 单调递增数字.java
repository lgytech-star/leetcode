class Solution {
    public int monotoneIncreasingDigits(int n) {
        char[]a = Integer.toString(n).toCharArray();
        int flag = a.length;
        for(int i=a.length-1;i>0;i--){
            if(a[i-1]>a[i]){
                flag = i;
                a[i-1]--;
            }
        }
        for(int i=flag;i<a.length;i++){
            a[i] = '9';
        }
        return Integer.parseInt(new String(a));
    }
}