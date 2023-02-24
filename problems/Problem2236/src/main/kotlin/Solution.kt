// https://leetcode.com/problems/root-equals-sum-of-children/


 // Example:
 var ti = TreeNode(5)
 var v = ti.`val`
 // Definition for a binary tree node.
  class TreeNode(var `val`: Int) {
      var left: TreeNode? = null
      var right: TreeNode? = null
  }
class Solution {
    fun checkTree(root: TreeNode?): Boolean {
        if(root == null) {
            return false
        }
        else {
            if (root.left != null && root.right != null) {
                return root.`val` == root.left!!.`val` + root.right!!.`val`
            }
            else {
                return false
            }
        }
    }
}