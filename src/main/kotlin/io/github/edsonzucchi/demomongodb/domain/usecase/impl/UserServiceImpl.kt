package io.github.edsonzucchi.demomongodb.domain.usecase.impl

import io.github.edsonzucchi.demomongodb.domain.entity.request.UserDto
import io.github.edsonzucchi.demomongodb.domain.usecase.UserService
import io.github.edsonzucchi.demomongodb.infra.database.User
import io.github.edsonzucchi.demomongodb.infra.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl (
    private val userRepository: UserRepository
) : UserService {

    override fun save(user: UserDto): User? {
        if (user.username.isNullOrEmpty()) {
            throw IllegalArgumentException("Username cannot be null or empty")
        }

        val find = findByUsername(user.username)
        if (find != null) {
            throw IllegalArgumentException("Username is in use")
        }

        return userRepository.save(User(id = UUID.randomUUID(), username = user.username))
    }

    override fun list(): List<User> {
        return userRepository.findAll()
    }

    override fun findByUsername(username: String): User? {
        return userRepository.findByUsername(username)
    }
}