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
    public List<String> binaryTreePaths(TreeNode root) {
       List<String> ll=new ArrayList<>();
       if(root==null)return ll;
       solve(ll,"",root);
    return ll;
    }
    public void solve(List<String> ll,String s,TreeNode root ){
        if(root==null)return;
        if(root.right==null && root.left==null){
            s+=Integer.toString(root.val);
            ll.add(s);
            return;
        }
        
        solve(ll,s+Integer.toString(root.val)+"->",root.left);
        solve(ll,s+Integer.toString(root.val)+"->",root.right);
    }
}