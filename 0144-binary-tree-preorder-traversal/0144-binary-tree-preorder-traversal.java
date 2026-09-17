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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ll=new ArrayList<>();
        pod(root,ll);
        return ll;
    }
    public void pod(TreeNode root,List<Integer> ll){
        if(root==null){
            //ll.add(null);
            return ;
        }
        ll.add(root.val);
       pod(root.left,ll);
       pod(root.right,ll);
    }
}