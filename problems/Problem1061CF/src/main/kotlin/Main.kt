// https://codeforces.com/problemset/problem/1061/C

var memo = mutableMapOf<List<Pair<Int, Int>>, Int>()

fun main(args: Array<String>) {
    val n: Int = readLine()!!.trimEnd().toInt()
    val a: List<Int> = readLine()!!.trimEnd().split(" ").map{it.toInt()}.toList()

    println(dp(getAWithIndex(a)))
}

fun getAWithIndex(a: List<Int>, i: Int = 0 , acc: List<Pair<Int, Int>> = listOf()): List<Pair<Int, Int>> {
    if(a.isEmpty()){
        return acc
    }
    else {
        return getAWithIndex(a.drop(1), i+1, acc + Pair(a.first(), i))
    }
}

fun dp(a: List<Pair<Int, Int>>, b: List<Pair<Int, Int>> = listOf(), i: Int = 1, count: Int = 0): Int {
    if (a.isEmpty()){
        return count
    }
    else {
        //println("a: " + a +" i: "+ i + "  count: "+ count)

        val filterA = if (b.isNotEmpty()){
            a.filter {it.second >= b.first().second && it.first % i == 0}
        }
        else {
            a.filter {it.first % i == 0}
        }

        if (filterA.isEmpty()){
            return count
        }
        else {
            return filterA.fold(count,
                {acc: Int, ai: Pair<Int, Int> -> acc + dp(a - ai, b + ai, i+1,  1) })
        }
    }
}