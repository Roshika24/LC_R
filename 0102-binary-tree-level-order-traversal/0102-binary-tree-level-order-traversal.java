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
        Queue<TreeNode > q=new ArrayDeque<>();
        List<List<Integer>> ll=new ArrayList<>();
     
        if(root==null)return ll;
        q.add(root);
        while(!q.isEmpty()){
            int s=q.size();
            List<Integer> l=new ArrayList<>();
            for(int i=0;i<s;i++){
                TreeNode temp=q.poll();
               l.add(temp.val);
              if(temp.left!=null) q.offer(temp.left);
              if(temp.right!=null) q.offer(temp.right);
            }
            ll.add(l);
        }
          return ll;
    }
}