// https://matcomgrader.com/problem/9718/queries-on-graphs/
/**
 **/
// Definition for a Graph node.
class GraphNode(val index: Int, var `val`: Int) {
    var adjacents: Set<GraphNode> = setOf()
}

fun main(args: Array<String>) {
    val inputLine1 = readLine()!!.trimEnd().split(" ").map{it.toInt()}.toList()
    val n: Int = inputLine1.get(0)
    val e: Int = inputLine1.get(1)
    val ws: List<Int> = readLine()!!.trimEnd().split(" ").map{it.toInt()}.toList()
    val listNodes: List<GraphNode> = getListNodes(n, ws)
    addEdges(e, listNodes)
    val q: Int = readLine()!!.trimEnd().toInt()
    processQueries(q, listNodes)
}


fun getListNodes(n: Int, ws: List<Int>, index: Int = 1, listOfNones: List<GraphNode> = listOf()): List<GraphNode> {
    if (n <= 0) {
        return listOfNones
    }
    else {
        return getListNodes(n-1, ws.drop(1), index+1, listOfNones + GraphNode(index, ws.first()))
    }
}

fun addEdges(n: Int, listOfNones: List<GraphNode> = listOf()): Unit {
    if (n <= 0) {
        return
    }
    else {
        val input: List<Int> = readLine()!!.trimEnd().split(" ").map{it.toInt()}.toList()
        val u: Int = input.get(0)
        val v: Int = input.get(1)

        listOfNones.get(u-1).adjacents = listOfNones.get(u-1).adjacents + listOfNones.get(v-1)
        listOfNones.get(v-1).adjacents = listOfNones.get(v-1).adjacents + listOfNones.get(u-1)
        addEdges(n-1, listOfNones)
    }
}

fun dfs(graphNode: GraphNode?, index: Int, visited: Set<Int> = setOf()): GraphNode? {
    if (graphNode == null) {
        return null
    }
    else if (graphNode.index == index) {
        return graphNode
    }
    else if (visited.contains(graphNode.index)){
        return null
    }
    else if(graphNode.adjacents.isEmpty()){
        return null
    }
    else {
        val adjacentsDfs: List<GraphNode?> = graphNode.adjacents.map {dfs(it, index, visited + graphNode.index)}.filterNotNull()

        if (adjacentsDfs.isEmpty()){
            return null
        }
        else {
            return adjacentsDfs.first()
        }
    }
}

fun get(v: Int, root: GraphNode): Int {
    val targetGraphNode: GraphNode? = dfs(root, v)

    if (targetGraphNode == null){
        return -1
    }
    else {
        return targetGraphNode.`val`
    }
}

fun add(v: Int, x: Int, listOfNones: List<GraphNode>): Unit {
    val root: GraphNode = listOfNones.get(0)
    val targetGraphNode: GraphNode? = dfs(root, v)

    if (targetGraphNode == null){
        return
    }
    else {
        //targetGraphNode.adjacents.map { it.`val` += x }
        listOfNones.filter { it.adjacents.map{it.index}.contains(v) }.map { it.`val` += x }
    }
}

fun processQueries(q: Int, listOfNones: List<GraphNode>): Unit {
    if (q <= 0) {
        return
    }
    else {
        val input: List<Int> = readLine()!!.trimEnd().split(" ").map{it.toInt()}.toList()

        if(input.get(0) == 2) {
            val v: Int = input.get(1)
            println(get(v, listOfNones.get(0)))
        }
        else {
            val v: Int = input.get(1)
            val x: Int = input.get(2)
            add(v, x, listOfNones)
        }

        processQueries(q-1 , listOfNones)
    }
}
