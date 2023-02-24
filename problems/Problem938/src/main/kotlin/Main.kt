// https://leetcode.com/problems/range-sum-of-bst/


 //Definition for a binary tree node.
  class TreeNode(var `val`: Int) {
     var left: TreeNode? = null
     var right: TreeNode? = null
 }

class Solution {
    fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
        return dfs(root, low, high)
    }

    fun dfs(root: TreeNode?, low: Int, high: Int): Int {
        if (root == null){
            return 0
        }
        else if (root.right == null && root.left == null) {
            return getValByRange(root.`val`, low, high)
        }
        else if (root.right != null && root.left != null) {
            if (root.`val` in low .. high){
               return root.`val` + dfs(root.left, low, high) + dfs(root.right, low, high)
            }
            else if (root.`val` < low){
                return dfs(root.right, low, high)
            }
            else {
                return dfs(root.left, low, high)
            }
        }
        else if(root.right != null && root.left == null){
            if (root.`val` in low .. high){
                return root.`val` + dfs(root.right, low, high)
            }
            else if (root.`val` < low){
                return dfs(root.right, low, high)
            }
            else {
                return 0
            }
        }
        else {
            if (root.`val` in low .. high){
                return root.`val` + dfs(root.left, low, high)
            }
            else if (root.`val` < low){
                return 0
            }
            else {
                return dfs(root.left, low, high)
            }
        }
    }


    fun getValByRange(value: Int, low: Int, high: Int): Int {
        if (value in low..high){
            return value
        }
        else {
            return 0
        }
    }
}