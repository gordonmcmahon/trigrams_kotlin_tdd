import java.lang.IllegalArgumentException

class Parser {
    fun parse(input: String): Map<Pair<String, String>, List<String>> {

        val words = input.split("\\s+".toRegex())
        val MIN_NUMBER_OF_WORDS = 3

        if (words.size < MIN_NUMBER_OF_WORDS) {
            throw IllegalArgumentException()
        }

        var result = mutableMapOf<Pair<String, String>, MutableList<String>>()

        for (currentIndex in 0..words.size - MIN_NUMBER_OF_WORDS) {
            var currentPair = Pair(words[currentIndex], words[currentIndex + 1])
            val orPut = result.getOrPut(currentPair) { mutableListOf<String>() }
            orPut.add(words[currentIndex + 2])
        }


        return result
    }
}