class Solution {
    public int[] getStrongest(int[] arr, int k) {
        if(arr.length==1)
        return new int[]{arr[0]};
        int []a = new int[k];
        int n = 0;
        Arrays.sort(arr);
        int i = 0,j = arr.length-1;
        int m = arr[(arr.length-1)/2];
        while(n<k){
            if(Math.abs(arr[j]-m)>=Math.abs(arr[i]-m)){
            a[n] = arr[j];
            j--;
            n++;
            }
            else{
            a[n] = arr[i];
            i++;
            n++;
        }
        } 
        return a;
    }
}