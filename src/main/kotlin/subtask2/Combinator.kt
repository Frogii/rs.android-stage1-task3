package subtask2

class Combinator {

    // TODO: Complete the following function
    fun checkChooseFromArray(array: Array<Int>): Int? {

        val a = array.first()
        val b = array.last()
        if (a == b) return 1
        var facN:Long = 1
        var facK:Long = 1
        var facN_K:Long = 1

        for (i in 1..b) facN *= i
        for (i in 1..b / 2) facK *= i
        for (i in 1..b - b / 2) facN_K *= i

        val x:Int = (facN / (facN_K * facK)).toInt()
        return if (x==a) b / 2
        else null
    }
}
