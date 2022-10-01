import java.io.BufferedReader
import java.io.InputStreamReader

class CommandInjectionMain {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            val input = "https://google.com&whoami"
            // if plugged as it is injection occurs, this is the impact of running commands thought OS shell interpreters such as sh, bash, cmd.exe and powershell.exe
            val process = ProcessBuilder("sh", "-c", "ping $input").start()
            val inReader = BufferedReader(InputStreamReader(process.inputStream))
            inReader.lines().forEach { x: String? -> println(x) }
        }
    }

}