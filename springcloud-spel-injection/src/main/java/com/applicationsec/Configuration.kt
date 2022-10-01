package com.applicationsec

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import reactor.core.publisher.Flux
import java.util.*

@Configuration
open class Configuration {

    @Bean
    open fun uppercase(): Function<Flux<String>> = { flux: Flux<String> -> flux.map { value -> value.uppercase(Locale.getDefault()) } }

}