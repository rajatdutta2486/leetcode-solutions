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
    int rootpos;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<inorder.length;i++) {
            map.put(inorder[i],i);
        }
        rootpos = postorder.length-1;
        return build(inorder,postorder,0,inorder.length-1, map);
    }
    
    public TreeNode build(int[] inorder,int[] postorder,int i,int j, HashMap<Integer,Integer> map) {
        //base case
        if( i > j )
            return null;
        
        int root = postorder[rootpos];
        rootpos-=1;// Move onto next element
        int rootInorderVal = map.get(root); // this will get the id of the root from inorder
        TreeNode rootNode = new TreeNode(root); // Creating root node now
        
        
        TreeNode right = build(inorder,postorder,rootInorderVal+1,j,map); //This could be null or an actual node
        TreeNode left = build(inorder,postorder,i,rootInorderVal-1,map); //This could be null or an actual node 
        
        rootNode.left = left;
        rootNode.right = right;
        
        return rootNode;                        
    }
    
    
    
    
}
