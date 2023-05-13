// https://leetcode.com/problems/find-if-path-exists-in-graph/
class Solution3 {
    fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
        var adj: List<Set<Int>> = transformEdgesToAdj(edges, n)

        return dfs(adj, source, destination, hashSetOf<Int>().also { it.add(source) })
    }

    fun transformEdgesToAdj(edges: Array<IntArray>,n: Int): List<Set<Int>> {
        val graph = MutableList(n){ hashSetOf<Int>() }

        for ((u, v) in edges){
            graph[u].add(v)
            graph[v].add(u)
        }

        return graph
    }

    fun dfs(adj: List<Set<Int>>, current: Int, destination: Int, visited: HashSet<Int> = hashSetOf()): Boolean {
        if (current == destination) {
            return true
        }
        for(next in adj[current]){
            if(visited.add(next))
                if(dfs(adj, next, destination, visited))
                    return true
        }
        return false
    }
}

fun main(args: Array<String>) {
    val solution = Solution3()

    val n = 6
    val edges = arrayOf(intArrayOf(0,1), intArrayOf(0,2), intArrayOf(3,5), intArrayOf(5,4), intArrayOf(4,3))
    val source = 0
    val destination = 5

    println(solution.validPath(n, edges, source, destination))
}