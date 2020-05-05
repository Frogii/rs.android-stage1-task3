package subtask5

import kotlin.reflect.KClass

class TelephoneFinder {

    // TODO: Complete the following function
    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        if (number.contains('-'))return null
        var phone = number.toCharArray()
        var phoneNumbers = mutableListOf<String>()
        val neighbor = mapOf(
            '1' to "24", '2' to "135", '3' to "26", '4' to "157", '5' to "2684",
            '6' to "359", '7' to "48", '8' to "5907", '9' to "68", '0' to "8"
        )
        for (num in phone.indices) {
            for (item in neighbor) {
                if (phone[num] == item.key) {
                    for (k in item.value.indices) {
                        phone[num] = item.value[k]
                        phoneNumbers.add(phone.joinToString(""))
                    }
                    phone = number.toCharArray()
                }
            }
        }
        return phoneNumbers.toTypedArray()
    }
}
