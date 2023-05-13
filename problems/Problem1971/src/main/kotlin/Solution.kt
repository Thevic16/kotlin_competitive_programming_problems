//// https://leetcode.com/problems/find-if-path-exists-in-graph/
//class Solution {
//    fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
//        return dfs(edges, source, destination)
//    }
//
//    fun dfs(edges: Array<IntArray>, source: Int, destination: Int, visited: Set<Int> = setOf()): Boolean {
//        if (source == destination) {
//            return true
//        }
//        else if (visited.contains(source))  {
//            return false
//        }
//        else {
//            val sourceEdges: List<IntArray> = edges.filter { it.contains(source) }
//            val adjacentsNodes: List<Int> = sourceEdges.map { it.filter { it != source }.first() }
//
//            if ( adjacentsNodes.isEmpty()){
//                return false
//            }
//            else {
//                return adjacentsNodes.fold(false,
//                    {acc, it -> acc || dfs(edges, it, destination, visited + source)} )
//            }
//        }
//    }
//}
//
//fun main(args: Array<String>) {
//    val solution = Solution()
//
//    val n = 6
//    val edges = arrayOf(intArrayOf(0,1), intArrayOf(0,2), intArrayOf(3,5), intArrayOf(5,4), intArrayOf(4,3))
//    val source = 0
//    val destination = 5
//
//    println(solution.validPath(n, edges, source, destination))
//}