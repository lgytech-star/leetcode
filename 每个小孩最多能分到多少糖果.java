class Solution {
    public int maximumCandies(int[] candies, long k) {
        long left = 1,right = 0;
        for(int i = 0;i<candies.length;i++){
            right = Math.max(right,(long)candies[i]);
        }
        while(left<=right){
            long mid = left + (right - left) / 2;
            if(check(candies,k,mid)){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return (int)left-1;
    }
    public boolean check(int []candies,long k,long num){
        long a = 0;
        for(int i = 0;i<candies.length;i++){
            a+=((long)candies[i])/num;
        }
        if(a>=k)
        return true;
        else
        return false;
    }
}