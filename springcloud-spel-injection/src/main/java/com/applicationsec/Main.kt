package com.applicationsec;

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import reactor.core.publisher.Flux
import java.util.*


@SpringBootApplication
open class Application {
  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      SpringApplication.run(Application::class.java, *args)
    }
  }

}