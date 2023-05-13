
// https://leetcode.com/problems/find-center-of-star-graph/
class Solution {
    fun findCenter(edges: Array<IntArray>): Int {
        val firstTwoEdges = edges.get(0) + edges.get(1)
        var result = -1
        firstTwoEdges.forEach {
            if (firstTwoEdges.count{x -> x == it} > 1) {
                result = it
            }
        }
        return result
    }
}