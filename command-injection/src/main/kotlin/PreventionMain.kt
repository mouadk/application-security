import java.io.BufferedReader
import java.io.InputStreamReader

class PreventionMain {


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val arg = "https://google.com&whoami"
            val pb = ProcessBuilder("ping",arg)
            // command injection fails - ping: cannot resolve https://google.com&whoami: Unknown host
            val process = pb.start()
            val errorReader = BufferedReader(InputStreamReader(process.errorStream))
            errorReader.lines().forEach { x: String? -> println(x) }
        }}
}