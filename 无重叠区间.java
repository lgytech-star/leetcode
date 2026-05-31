class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length==1)
        return 0;
        Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
        int ans = 0;
        int mx = intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]<mx){
                ans++;
                mx = Math.min(intervals[i][1],mx);
            }else{
                mx = intervals[i][1];
            }
        }
        return ans;
    }
}