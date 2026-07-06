class Solution {
    public int numOfSubarrays(int[] arr) {
        long ans = 0;
        int MOD = 1000000007;
        long sum = 0,oushu=1,jishu=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(sum%2==0){
                oushu++;
                ans+=jishu;
            }else{
                jishu++;
                ans+=oushu;
            }
        }
    return (int)(ans%MOD);
    }
}