package io.github.edsonzucchi.demomongodb.infra.repository

import io.github.edsonzucchi.demomongodb.infra.database.User
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : MongoRepository<User, String> {

    fun findByUsername(username: String): User?
}