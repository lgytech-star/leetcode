class Solution {
    public int maxArea(int[] height) {
        int left=0,right= height.length-1;
        int max=0;
        while(left<right){
            max=Math.max((right-left)*Math.min(height[left],height[right]),max);
            if(height[right]<height[left]){
                right--;
            }
            else
            left++;
        }
            return max;
    }
}