package ssauthserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class SsAuthServerApplication

fun main(args: Array<String>) {
    runApplication<SsAuthServerApplication>(*args)
}
