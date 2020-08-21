import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.util.*

class GenerateTest {

    lateinit var testee: Generate

    @Before
    fun setUp(){
        testee = Generate()
    }


    @Test
    fun multipleEntrysWithSingleEntriesInTheirLists_givesPredictableOutput(){
        val seedKey = Pair("a", "b")
        var inputMap = mutableMapOf(seedKey to Collections.singletonList("c"))
        inputMap.put(Pair("b", "c"), Collections.singletonList("d"))

        val actual = testee.generate(seedKey, inputMap)

        assertEquals(4, actual.size)
        assertEquals("a", actual.get(0))
        assertEquals("b", actual.get(1))
        assertEquals("c", actual.get(2))
        assertEquals("d", actual.get(3))
    }

    @Test
    fun singleEntryProducesSimplestOutput(){
        val seedKey = Pair("a", "b")
        var inputMap = mapOf(seedKey to Collections.singletonList("c"))

        val actual = testee.generate(seedKey, inputMap)

        assertEquals(3, actual.size)
        assertEquals("a", actual.get(0))
        assertEquals("b", actual.get(1))
        assertEquals("c", actual.get(2))
    }



    @Test
    fun whenSeedKeyIsFound_exceptionNOTThrown(){
        val seedKey = Pair("a", "b")
        var inputMap = mapOf(seedKey to Collections.singletonList("c"))

        testee.generate(seedKey, inputMap)
    }

    @Test(expected = IllegalArgumentException::class)
    fun whenSeedKeyIsNotFound_exceptionThrown(){
        val seedKey = Pair("a", "b")
        var inputMap = mapOf(Pair("x", "y") to Collections.singletonList("c"))

        testee.generate(seedKey, inputMap)
    }


}
