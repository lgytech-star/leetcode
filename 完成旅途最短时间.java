class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long left = 1,right = 0;
        for(int i = 0; i<time.length;i++){
            right = Math.max((long)time[i]*totalTrips,right);
        }
        while(left<=right){
            long mid = left + (right - left) / 2;
            if(check(time,totalTrips,mid)){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
    public boolean check(int []time,int totalTrips,long num){
        long sum = 0;
        for(int i = 0; i<time.length;i++){
            sum+=num/(long)time[i];
        }
        if(sum>=totalTrips)
        return true;
        else
        return false;
    }
}