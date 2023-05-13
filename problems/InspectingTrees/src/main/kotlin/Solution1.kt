//// https://matcomgrader.com/problem/9714/inspecting-trees/
///**
//my test cases:
// test case 1:
//6
//1 2 3 4 5 6
//1 2
//1 3
//1 4
//2 5
//2 6
//8
//1 1 3
//1 2 5
//2 1
//2 2
//2 3
//2 4
//2 5
//2 6
//
//
//test case 2:
//10
//1 2 3 4 5 6 7 8 9 10
//1 2
//1 3
//1 4
//2 5
//2 6
//5 7
//7 8
//7 9
//7 10
//10
//2 1
//2 2
//2 3
//2 4
//2 5
//2 6
//2 7
//2 8
//2 9
//2 10
//
//
//test case 3:
//17
//1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17
//1 2
//1 3
//2 4
//2 5
//3 6
//3 7
//4 8
//4 9
//5 10
//5 11
//6 12
//6 13
//7 14
//7 15
//8 16
//15 17
//17
//2 1
//2 2
//2 3
//2 4
//2 5
//2 6
//2 7
//2 8
//2 9
//2 10
//2 11
//2 12
//2 13
//2 14
//2 15
//2 16
//2 17
//* */
//// Definition for a tree node.
//class TreeNode(val index: Int, var `val`: Int) {
//    var father: TreeNode? = null
//    var children: Set<TreeNode> = setOf()
//}
//
//fun main(args: Array<String>) {
//    val n: Int = readLine()!!.trimEnd().toInt()
//    val ws: List<Int> = readLine()!!.trimEnd().split(" ").map{it.toInt()}.toList()
//    val listNodes: List<TreeNode> = getListNodes(n, ws)
//    addEdges(n-1, listNodes)
//    val q: Int = readLine()!!.trimEnd().toInt()
//    processQueries(q, listNodes)
//}
//
//
//fun getListNodes(n: Int, ws: List<Int>, index: Int = 1, listOfNones: List<TreeNode> = listOf()): List<TreeNode> {
//    if (n <= 0) {
//        return listOfNones
//    }
//    else {
//        return getListNodes(n-1, ws.drop(1), index+1, listOfNones + TreeNode(index, ws.first()))
//    }
//}
//
//fun addEdges(n: Int, listOfNones: List<TreeNode> = listOf()): Unit {
//    if (n <= 0) {
//        return
//    }
//    else {
//        val input: List<Int> = readLine()!!.trimEnd().split(" ").map{it.toInt()}.toList()
//        val u: Int = input.get(0)
//        val v: Int = input.get(1)
//
//        listOfNones.get(u-1).children = listOfNones.get(u-1).children + listOfNones.get(v-1)
//        listOfNones.get(v-1).father = listOfNones.get(u-1)
//        addEdges(n-1, listOfNones)
//    }
//}
//
//fun dfs(treeNode: TreeNode?, index: Int): TreeNode? {
//    if (treeNode == null) {
//        return null
//    }
//    else if (treeNode.index == index) {
//        return treeNode
//    }
//    else if(treeNode.children.isEmpty()){
//        return null
//    }
//    else {
//        val childrenDfs: List<TreeNode?> = treeNode.children.map {dfs(it, index)}.filterNotNull()
//
//        if (childrenDfs.isEmpty()){
//            return null
//        }
//        else {
//            return childrenDfs.first()
//        }
//    }
//}
//
//fun get(v: Int, root: TreeNode): Int {
//    val targetTreeNode: TreeNode? = dfs(root, v)
//
//    if (targetTreeNode == null){
//        return -1
//    }
//    else {
//        return targetTreeNode.`val`
//    }
//}
//
//fun add(v: Int, x: Int, listOfNones: List<TreeNode>): Unit {
//    val root: TreeNode = listOfNones.get(0)
//    val targetTreeNode: TreeNode? = dfs(root, v)
//
//    if (targetTreeNode == null){
//        return
//    }
//    else {
//        targetTreeNode.children.map { it.`val` += x }
//
//        if (targetTreeNode.father != null) {
//            targetTreeNode.father!!.`val` += x
//        }
//    }
//}
//
//fun processQueries(q: Int, listOfNones: List<TreeNode>): Unit {
//    if (q <= 0) {
//        return
//    }
//    else {
//        val input: List<Int> = readLine()!!.trimEnd().split(" ").map{it.toInt()}.toList()
//
//        if(input.get(0) == 2) {
//           val v: Int = input.get(1)
//           println(get(v, listOfNones.get(0)))
//        }
//        else {
//            val v: Int = input.get(1)
//            val x: Int = input.get(2)
//            add(v, x, listOfNones)
//        }
//
//        processQueries(q-1 , listOfNones)
//    }
//}
