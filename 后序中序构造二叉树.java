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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0||postorder.length==0)
        return null;
        int n = inorder.length;
        TreeNode root = new TreeNode(postorder[n-1]);
        int index = -1;
        for(int i=0;i<n;i++){
            if(inorder[i]==postorder[n-1])
            index = i;
        }
        int []left_inorder = Arrays.copyOfRange(inorder,0,index);
        int []left_postorder = Arrays.copyOfRange(postorder,0,index);
        root.left=buildTree(left_inorder,left_postorder);
        int []right_inorder = Arrays.copyOfRange(inorder,index+1,n);
        int []right_postorder = Arrays.copyOfRange(postorder,index,n-1);
        root.right = buildTree(right_inorder,right_postorder);
        return root;
    }
}