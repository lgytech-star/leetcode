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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        if(root==null)
        return res;
        q.offer(root);
        int size = q.size();
        while(!q.isEmpty()){
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<size;i++){  
                TreeNode p = q.peek();
                if(p.left!=null)
                q.offer(p.left);
                if(p.right!=null)
                q.offer(p.right);
                list.add(p.val);
                q.removeFirst();
            }
            res.add(new ArrayList<>(list));
            size = q.size();
        }
        return res;
    }
}