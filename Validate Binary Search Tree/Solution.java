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

/*
[Case 1]:   
            2
           / \
          1   3

Input: [2,1,3]
Output: true
----------------------------
[Case 2]: 
         5
        / \
       1   4 
          / \
         3   6
       
Input: [5,1,4,null,null,3,6]    
Output: false
----------------------------
[Case 3]:

        3
       / \
      2   5
     / \ 
    1   4
Input: [3,2,5,1,4]
Output: false

  /*
                v(3,null,null)
                   /        \ 
            v(2,null,3)   v(5,3,null )
            /      \ 
    v(1,null,2)   v(4,2,3)
        */
           
class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null );
    }        
    
    public boolean validate(TreeNode root, TreeNode left, TreeNode right ) {
        //base case
        if(root == null)
            return true;
        
        if(left!=null && left.val >= root.val)
            return false;
        
        if(right!=null && right.val <=root.val)
            return false;
        
        boolean l = validate(root.left,left , root );
        boolean r = validate(root.right, root, right );
        
        return l && r; 
       
    }
}
