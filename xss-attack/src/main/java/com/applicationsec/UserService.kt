package com.applicationsec

import org.springframework.stereotype.Service
import java.util.concurrent.ConcurrentHashMap

@Service
class UserService {

    private val map: ConcurrentHashMap<String, User> = ConcurrentHashMap()

    fun addUser(user: User) {
        map[user.name] = user
    }

    fun findByName(name: String) = map[name]

}

