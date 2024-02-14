import fr.rozanc.playground.Main
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.test.Test
import kotlin.test.assertEquals

class MainTest {

    val out = ByteArrayOutputStream()
    val main = Main(PrintStream(out))

    @Test
    fun test() {
        main.helloWorld()
        assertEquals("Hello, World!${System.lineSeparator()}", out.toString())
    }
}
