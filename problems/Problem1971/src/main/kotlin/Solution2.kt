// https://leetcode.com/problems/find-if-path-exists-in-graph/
class Solution2 {
    fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
        var adj: List<Set<Int>> = transformEdgesToAdj(edges, n)

        return dfs(adj, source, destination)
    }

    fun transformEdgesToAdj(edges: Array<IntArray>,n: Int, index: Int = 0,  adj: List<Set<Int>> = listOf()): List<Set<Int>> {
        if(index >= n) {
            return adj
        }
        else {
            val sourceEdges: List<IntArray> = edges.filter { it.contains(index) }
            val adjacentsNodes: List<Int> = sourceEdges.map { it.filter { it != index }.first() }
            return transformEdgesToAdj(edges, n , index + 1, adj + listOf(adjacentsNodes.toSet()) )
        }
    }

    fun dfs(adj: List<Set<Int>>, source: Int, destination: Int, visited: Set<Int> = setOf()): Boolean {
        if (source == destination) {
            return true
        }
        else if (visited.contains(source))  {
            return false
        }
        else {
            val adjacentsNodes: Set<Int> = adj.get(source)

            if ( adjacentsNodes.isEmpty()){
                return false
            }
            else {
                return adjacentsNodes.fold(false,
                    {acc, it -> acc || dfs(adj, it, destination, visited + source)} )
            }
        }
    }

}

fun main(args: Array<String>) {
    val solution = Solution2()

    val n = 6
    val edges = arrayOf(intArrayOf(0,1), intArrayOf(0,2), intArrayOf(3,5), intArrayOf(5,4), intArrayOf(4,3))
    val source = 0
    val destination = 5

    println(solution.validPath(n, edges, source, destination))
}