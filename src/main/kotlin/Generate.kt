import java.lang.IllegalArgumentException

class Generate {

    fun generate(seedKey: Pair<String, String>, inputMap: Map<Pair<String, String>, MutableList<String>>): List<String> {

        if(!inputMap.containsKey(seedKey)){
            throw IllegalArgumentException()
        }

        var result = mutableListOf(seedKey.first, seedKey.second)
        var currentKey = seedKey
        var currentValue: String?

        do{
            currentValue = inputMap.get(currentKey)?.get(0) 
            if(!currentValue.isNullOrBlank()) {
                result.add(currentValue)
                currentKey = Pair(currentKey.second, currentValue)
            }
        }while (currentValue != null)







        // set seed key to current key, and select one of it's values for output

        // update the current key to include last value on output



        return result
    }

}
