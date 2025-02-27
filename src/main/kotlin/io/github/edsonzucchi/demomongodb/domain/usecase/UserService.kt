package io.github.edsonzucchi.demomongodb.domain.usecase

import io.github.edsonzucchi.demomongodb.domain.entity.request.UserDto
import io.github.edsonzucchi.demomongodb.infra.database.User

interface UserService {

    fun save(user: UserDto): User?

    fun list(): List<User>

    fun findByUsername(username: String): User?
}