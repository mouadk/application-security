package com.applicationsec

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("index")
class Controller {

    private val logger: Logger = LogManager.getLogger(Controller::class.java)

    @GetMapping
    @ResponseBody
    fun index(@RequestParam name: String): String {
        logger.info("received a new index request for $name")
        return "index"
    }

}