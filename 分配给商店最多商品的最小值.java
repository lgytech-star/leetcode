class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1, right = 0;
        for(int i=0;i<quantities.length;i++){
            right = Math.max(right,quantities[i]);
        }
        while(left<=right){
            int mid = left + (right - left) / 2;
            if(check(n,quantities,mid)){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
    public boolean check(int n,int []quantities,int num){
        for(int i=0;i<quantities.length;i++){
            if(quantities[i]%num==0)
            n-=quantities[i]/num;
            else
            n-=quantities[i]/num + 1;
            if(n<0)
            return false;
        }
        return true;
    }
}