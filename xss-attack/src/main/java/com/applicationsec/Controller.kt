package com.applicationsec

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class Controller(private val service: UserService) {

    @PostMapping
    fun save(@RequestBody user: User){
        service.addUser(user)
    }

    // this is bad // content type would not be json and an xss may be experienced
    @GetMapping
    fun get(@RequestParam name: String): String = ObjectMapper().writeValueAsString(service.findByName(name))

}

data class User(val name: String, val job: String)


@EnableWebSecurity
open class WebSecurityConfig : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http.csrf().disable() // !!  PLEASE never use this - its only for demonstrating the attack it should always be enabled
        http.authorizeRequests { request ->
            request.antMatchers( "/users").permitAll().anyRequest().authenticated()
        }.headers()
                .xssProtection().xssProtectionEnabled(false).block(false) // !! never use this its only for demonstraing the attack it should always be enabled

    }
}