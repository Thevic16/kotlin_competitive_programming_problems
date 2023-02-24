// https://matcomgrader.com/problem/9712/go-kill-the-monsters/


fun main(args: Array<String>) {
    val input1 = readLine()!!.trim().split(" ").map{it.toInt()}.toIntArray()
    val n = input1.get(0)
    val k = input1.get(1)
    val strengths = readLine()!!.trim().split(" ").map{it.toInt()}.toList()
    strengths.sorted()

    println(solution(k.toLong(), strengths))
}

fun solution(k: Long, strengths: List<Int>, cost: Long = 0): Long {
    val half: Int = strengths.size / 2
    val strengthsHalfSum = strengths.take(half).sum()

    if (strengths.isEmpty()){
        return cost
    }
    else if (half == 0){
        return solution(k, listOf(), cost + strengths.get(0))
    }
    else if (strengthsHalfSum > k){
        return solution(k, strengths.drop(half), cost + k)
    }
    else {
        return solution(k, strengths.drop(half), cost + strengthsHalfSum)
    }
}


