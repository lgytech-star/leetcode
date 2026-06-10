class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int left = weights[0] ,right = weights[0];
        for(int i = 0;i<weights.length;i++){
            right = Math.max(weights[i],right);
        }
        left = right;
        right = right * weights.length;
        while(left<=right){
            int mid = left + (right - left) / 2;
            if(check(weights,days,mid)){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
    public boolean check(int []weights,int days,int weight){
        int num = weight;
        int sum = 0;
        int i = 0;
        while(i<weights.length){
            sum++;
            while(i<weights.length&&weights[i]<=num){
                num-=weights[i];
                i++;
            }
            num = weight;
        }
        if(sum<=days)
        return true;
        else
        return false;
    }
}