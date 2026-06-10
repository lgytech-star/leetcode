class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int mid = (n + 1) / 2;   // 右半部分的起始下标
        int i = 0, j = mid;
        int count = 0;
        while (i < mid && j < n) {
            if (2 * nums[i] <= nums[j]) {
                count += 2;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return count;
    }
}