package io.github.edsonzucchi.demomongodb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemomongodbApplication

fun main(args: Array<String>) {
    runApplication<DemomongodbApplication>(*args)
}
