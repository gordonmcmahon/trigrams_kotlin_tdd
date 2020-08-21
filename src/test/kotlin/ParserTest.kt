import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import java.util.*
import kotlin.test.assertEquals


class ParserTest {

    lateinit var testee: Parser

    @Before
    fun setUp(){
        testee = Parser()
    }


    @Test
    fun inputHasMultipleSpaces(){
        var input = "  a \n\n   \tb  c "
        var actual = testee.parse(input)

        val key = Pair("a", "b")

        var words = actual.get(key)

        assertEquals(1, words?.size)

        assertEquals(true, words?.contains("c"))
    }

    @Test
    fun trigramsWithMultipleValuesGeneratedFromInput(){
        var input = "a b c a b d"
        var actual = testee.parse(input)

        val key = Pair("a", "b")

        var words = actual.get(key)

        assertEquals(2, words?.size)

        assertEquals(true, words?.contains("c"))
        assertEquals(true, words?.contains("d"))
    }

    @Test
    fun multipleTrigramsGeneratedFromInput(){
        var input = "a b c d"
        var actual = testee.parse(input)

        val firstKey = Pair("a", "b")
        val secondKey = Pair("b", "c")

        assertEquals(2, actual.size)

        assertTrue(actual.keys.contains(firstKey))
        assertTrue(actual.keys.contains(secondKey))

        assertEquals(actual.get(firstKey), Collections.singletonList("c"))
        assertEquals(actual.get(secondKey), Collections.singletonList("d"))
    }


    @Test
    fun singleTrigramConstructedFromSimplestInput(){
        var input = "a b c"
        var actual = testee.parse(input)

        val key = Pair("a", "b")

        assertEquals(1, actual.size)

        var expected = mapOf(key to listOf("c"))
        var result = actual.keys.first()

        assertEquals(expected, actual)
        assertEquals(key, result)
    }


    @Test
    fun exceptionNotThrownWhenSufficientWordsToConstructATrigramInInput(){
        var input = "one two three"


        testee.parse(input)
    }

    @Test(expected = IllegalArgumentException::class)
    fun exceptionThrownWhenNotEnoughWordsToConstructATrigramInInput(){
        var input = "one two"

        testee.parse(input)
    }

}