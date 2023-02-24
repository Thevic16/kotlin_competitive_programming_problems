fun main(args: Array<String>) {
    val input = readLine()!!.trimEnd().split(" ").map{it.toString()}.toTypedArray()
    val ab: List<String> = input.take(2)
    val cd: List<String> = input.drop(2).take(2)

    if (cd.contains(ab.get(0)) ||  cd.contains(ab.get(1))){
        println("YES")
    }
    else {
        println("NO")
    }
}