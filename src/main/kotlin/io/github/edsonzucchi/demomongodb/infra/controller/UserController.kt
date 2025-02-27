package io.github.edsonzucchi.demomongodb.infra.controller

import io.github.edsonzucchi.demomongodb.domain.entity.request.UserDto
import io.github.edsonzucchi.demomongodb.domain.usecase.UserService
import io.github.edsonzucchi.demomongodb.infra.database.User
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(
    private val userService: UserService
) {

    @PostMapping
    fun saveUser(@RequestBody user: UserDto): ResponseEntity<Any?> {
        try {
            return ResponseEntity.ok(userService.save(user))
        } catch (e: Exception) {
            return ResponseEntity.unprocessableEntity().body(e.message)
        }
    }

    @GetMapping
    fun listAll(): List<User> {
        return userService.list()
    }

    @GetMapping("/{username}")
    fun getUser(@PathVariable username: String): User? {
        return userService.findByUsername(username)
    }
}