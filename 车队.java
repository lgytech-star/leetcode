class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double [][]car = new double[position.length][2];
        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0;i < position.length;i++){
                car[i][0]=position[i];
                car[i][1]=(double)(target-position[i])/speed[i];                
        }
        Arrays.sort(car,(a,b)->Double.compare(a[0],b[0]));
        int ans = 0;
        double lastTime = -1; 
        for (int i = car.length - 1; i >= 0; i--) {
        double time = car[i][1];   
        if (time > lastTime) {     
            ans++;                 
            lastTime = time;       
        }

        }
        return ans;
    }
}