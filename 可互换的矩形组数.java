class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        long ans = 0;
        Map<Double,Long> map = new HashMap<>(); 
        map.put((double)rectangles[0][0]/rectangles[0][1],(long)1);
        for(int i=1;i<rectangles.length;i++){
            if(map.get((double)rectangles[i][0]/rectangles[i][1])!=null){
                double x = (double)rectangles[i][0]/rectangles[i][1];
                ans+=map.get(x);
                map.put(x,map.get(x)+1);
            }else{
                map.put((double)rectangles[i][0]/rectangles[i][1],(long)1);
            }
        }
        return ans;
    }
}