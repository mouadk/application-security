
package com.applicationsec
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import javax.servlet.http.HttpServletResponse


@Controller
class HelloController {

    @GetMapping("/")
    fun welcome(model: Model): String {
        model.addAttribute("message", "iamvulnerable")
        return "welcome"
    }

    @GetMapping("/iamvulnerable")
    fun iamVulnerable(@RequestParam input: String): String {
        return "user/$input/welcome" //template path is tainted
    }

    @GetMapping("/iamvulnerable/{id}")
    fun iamVulnerable2(@PathVariable id: String) {
        //returns void
    }
}