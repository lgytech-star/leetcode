class Solution {
    public int hIndex(int[] citations) {
        // 在区间 [left, right] 内询问
        int n = citations.length;
        int left = 1;
        int right = n;
        while (left <= right) { 
            int mid = (left + right) >>> 1;
            if (citations[n - mid] >= mid) {
                left = mid + 1; 
            } else {
                right = mid - 1; 
            }
        }
        return left-1;
    }
}

