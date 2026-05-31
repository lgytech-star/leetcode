class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int ans = 0;
        int sum = 0;
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        if(sum>=threshold*k)
        ans++;
        int i = 0,j=i+k-1;
        while(j<arr.length){
            if(i==0){
                i++;
                j++;
                continue;
            }
            sum-=arr[i-1];
            sum+=arr[j];
            if(sum>=threshold*k)
            ans++;
            i++;
            j++;
        }
        return ans;
    }
}