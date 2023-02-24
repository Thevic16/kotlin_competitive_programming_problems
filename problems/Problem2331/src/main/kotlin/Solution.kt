
 // Example:
 var ti = TreeNode(5)
 var v = ti.`val`
 // Definition for a binary tree node.
 class TreeNode(var `val`: Int) {
      var left: TreeNode? = null
      var right: TreeNode? = null
  }
class Solution {
    fun evaluateTree(root: TreeNode?): Boolean {
        if (root == null) {
            return false
        }
        else if(root.left == null && root.right == null){
            return valueToBoolean(root.`val`)
        }
        else {
            if(root.`val` == 2) {
                return evaluateTree(root.left) || evaluateTree(root.right)
            }
            else {
                return evaluateTree(root.left) && evaluateTree(root.right)
            }
        }
    }

    fun valueToBoolean(value: Int): Boolean {
        return value == 1
    }
}