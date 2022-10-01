package com.applicationsec

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping
class Controller(private val properties: ConfigProperties) {

    @GetMapping("/")
    @ResponseBody
    fun index(): String = ""
}

@Configuration
@ConfigurationProperties(prefix = "config")
open class ConfigProperties {
    val hostName: String? = null
}