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
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        if(root==null)
        return -1;
        q.offer(root);
        int ans = root.val;
        int size = q.size();
        while(!q.isEmpty()){
            for(int i=0;i<size;i++){
               TreeNode node = q.peek();
               ans = node.val;
               if(node.right!=null)
               q.offer(node.right);
               if(node.left!=null)
               q.offer(node.left);
               q.removeFirst();
            }
            size = q.size();
        }
        return ans;
    }
}