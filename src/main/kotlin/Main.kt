package fr.rozanc.playground

import java.io.PrintStream

class Main(
    private val out: PrintStream = System.out
) {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Main().helloWorld()
        }
    }

    fun helloWorld() {
        out.println("Hello, World!")
    }
}
