package com.applicationsec
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.context.config.annotation.RefreshScope


@SpringBootApplication
open class Application {
  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
      SpringApplication.run(Application::class.java, *args)
    }
  }

}