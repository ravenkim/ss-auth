package ssauthserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext
import org.springframework.core.env.Environment

@SpringBootApplication
open class SsAuthServerApplication

fun main(args: Array<String>) {
    val applicationContext = runApplication<SsAuthServerApplication>(*args)

    val environment = applicationContext.getBean(Environment::class.java)
    val activeProfiles = environment.activeProfiles
    val isLocal = activeProfiles.contains("local")

    if (isLocal) {
        val webServerAppCtxt = applicationContext as ServletWebServerApplicationContext
        val port = webServerAppCtxt.webServer.port
        val applicationName = environment.getProperty("spring.application.name")

        println("\n----------------------------------------------------------")
        println("Application '$applicationName' is running!")
        println("Access URL:")
        println("Local: http://localhost:$port")
        println("----------------------------------------------------------\n")
    }
}
