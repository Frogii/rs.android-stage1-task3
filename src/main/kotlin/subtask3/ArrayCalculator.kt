package subtask3

class ArrayCalculator {

    // TODO: Complete the following function
    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {
        var intList: MutableList<Int> = itemsFromArray.filter { it is Int } as MutableList<Int>
        if (intList.isEmpty()) return 0
        var outputNum: Int = intList.first()
        if (numberOfItems > intList.size) {
            for (i in 1 until intList.size) outputNum *= intList[i]

            return outputNum
        }
        var positiveNums = mutableListOf<Int>()
        var negativeNums = mutableListOf<Int>()
        for (i in intList){
            if (i < 0)negativeNums.add(i)
            else positiveNums.add(i)
        }
        positiveNums.sortWith(reverseOrder())
        negativeNums.sortWith(reverseOrder())

        if (negativeNums.size<=2){
            outputNum = positiveNums.first()
            for (i in 1 until  numberOfItems){
                outputNum*=positiveNums[i]
            }
            return outputNum
        }
        outputNum = positiveNums.first()
        outputNum*=positiveNums[1]

        for (i in 1..2){
            outputNum*=negativeNums[i]
        }
        return outputNum

    }
}
