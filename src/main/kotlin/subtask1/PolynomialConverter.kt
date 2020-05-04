package subtask1

import java.lang.StringBuilder

class PolynomialConverter {

    // TODO: Complete the following function
    fun convertToStringFrom(numbers: Array<Int>): String? {
        var list = mutableListOf<String>()
        for (i in numbers) {
            list.add(i.toString())
        }
        if (numbers.isEmpty()) return null
        else if (!numbers.contains(0)) {
            var exponent = list.size - 1
            for (i in list.indices) {
                if (!list[i].contains('-') && i != 0) {
                    list[i] = " + " + list[i]
                } else if (list[i].contains('-')) {
                    list[i] = " - ${list[i].get(1)}"
                }
            }
            for (i in 0 until list.size - 1) {
                list[i] = list[i] + "x^${exponent}"
                exponent--
            }
            for (i in list.indices) {
                if (list[i] == " - 1x^1") list[i] = " - x"
                else if (list[i] == " + 1x^1") list[i] = " + x"
            }
            val outputStr = StringBuilder()
            for (i in list) outputStr.append(i)
            return outputStr.toString()
        }
        var exponent = 2
        for (i in numbers) {
            if (i != 0) {
                exponent++
            } else break
        }
        if (list.size == 4) {
            val listWithout0: MutableList<String> = list.filter { it != "0" } as MutableList<String>
            for (i in listWithout0.indices) {
                if (exponent == 2) break
                listWithout0[i] = "${listWithout0[i]}x^${exponent-1}"
                exponent--
            }
            for (i in listWithout0.indices) {
                if (listWithout0[i].contains('-')) {
                    listWithout0[i] = listWithout0[i].filter { it != '-' }
                    listWithout0[i] = " - ${listWithout0[i]}"
                } else if (!listWithout0[i].contains('-') && i != 0){
                    listWithout0[i] = " + ${listWithout0[i]}"
                }
            }
            val outputStr = StringBuilder()
            for (i in listWithout0) outputStr.append(i)
            return outputStr.toString()

        }
        val listWithout0: MutableList<String> = list.filter { it != "0" } as MutableList<String>
        for (i in listWithout0.indices) {
            if (exponent == 2) break
            listWithout0[i] = "${listWithout0[i]}x^${exponent}"
            exponent--
        }
        for (i in listWithout0.indices) {
            if (listWithout0[i].contains('-')) {
                listWithout0[i] = listWithout0[i].filter { it != '-' }
                listWithout0[i] = " - ${listWithout0[i]}"
            } else if (!listWithout0[i].contains('-') && i != 0) {
                listWithout0[i] = " + ${listWithout0[i]}"
            }
        }
        listWithout0[listWithout0.size-2] = "${listWithout0[listWithout0.size-2]}x"
        val outputStr = StringBuilder()
        for (i in listWithout0) outputStr.append(i)
        return outputStr.toString()
    }
}
