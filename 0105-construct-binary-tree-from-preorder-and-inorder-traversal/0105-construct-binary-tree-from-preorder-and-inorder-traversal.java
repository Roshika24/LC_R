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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            mp.put(inorder[i],i);
        }
        return build(preorder,0,0,inorder.length-1,mp);
    }
    private TreeNode build(int[] preorder, int prest, int ins,int inend,HashMap<Integer,Integer> mp){
        if(ins>inend)return null;
        int r=preorder[prest];
        TreeNode root=new TreeNode(r);
        int rid=mp.get(r);
        int ls=rid-ins;
        root.left=build(preorder, prest+1,ins,rid-1,mp);
        root.right=build(preorder,prest+ls+1,rid+1,inend,mp);
        return root;
    }

}