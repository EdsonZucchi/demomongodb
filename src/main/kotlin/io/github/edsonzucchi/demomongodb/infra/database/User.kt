package io.github.edsonzucchi.demomongodb.infra.database

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.UUID

@Document(collection = "users")
data class User(
    @Id var id: UUID? = null,
    var username: String? = null,
) {
}