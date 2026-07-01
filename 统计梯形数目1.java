class Solution {
    public int countTrapezoids(int[][] points) {
        final int MOD = 1000000007;
        HashMap<Integer,Integer> map = new HashMap<>();
        long ans = 0,sum = 0;
        for(int i=0;i<points.length;i++){
            map.put(points[i][1],map.getOrDefault(points[i][1],0)+1);
        }
        for(int c : map.values()){
            long k = (long)c *(c-1)/2;
            ans+=sum*k;
            sum+=k;
        }
        return (int)(ans%MOD);
    }
}