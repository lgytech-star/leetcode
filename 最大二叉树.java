/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length==0)
        return null;
        if(nums.length==1)
        return new TreeNode(nums[0]);
        int []a = maxValue(nums);
        int index = a[1];
        int []left_num = Arrays.copyOfRange(nums,0,a[1]);
        int []right_num = Arrays.copyOfRange(nums,a[1]+1,nums.length);
        TreeNode root = new TreeNode(a[0]);
        root.left = constructMaximumBinaryTree(left_num);
        root.right = constructMaximumBinaryTree(right_num);
        return root;
    }
    public int[] maxValue(int []nums){
        int max = nums[0];
        int index = 0;
        for(int i=0;i<=nums.length-1;i++){
            if(max<nums[i]){
                max = nums[i];
                index = i;
            }
        }
        return new int[]{max,index};
    }
}