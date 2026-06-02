class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int num = 0;
        int i = 0, j = plants.length-1;
        int a = capacityA;
        int b = capacityB;
        while(i<j){
            if(a>=plants[i])
                a-=plants[i];
            else{
                num++;
                a = capacityA;
                a -= plants[i];
            }
            if(b>=plants[j])
                b-=plants[j];
            else{
                num++;
                b = capacityB;
                b-=plants[j];
            }
            i++;
            j--;
        }
        if(i==j){
            if(a<plants[i]&&b<plants[i])
            num++;
        }
        return num;
    }
}