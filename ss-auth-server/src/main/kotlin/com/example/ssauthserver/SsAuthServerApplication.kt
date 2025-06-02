package com.example.ssauthserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SsAuthServerApplication

fun main(args: Array<String>) {
	runApplication<SsAuthServerApplication>(*args)
}
