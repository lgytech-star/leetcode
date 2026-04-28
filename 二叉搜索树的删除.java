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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        TreeNode cur = root;
        if(root == null)
        return root;
        while(true){
            if(cur.val>val){
                if(cur.left==null){
                    cur.left = node;
                    break;
                }
                cur = cur.left;
            }
            else{
                if(cur.right==null){
                    cur.right = node;
                    break;
                }
                cur = cur.right;
            }
        }
        return root;
    }
}