package com.ss.auth.controller

import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthController {

    @GetMapping("/")
    fun home(): String {
        return "<h1>Home</h1>"
    }

    @GetMapping("/hello")
    fun hello(): String {
        return "<h1>Hello, World!</h1>"
    }

    @GetMapping("/me")
    fun me(@AuthenticationPrincipal jwt: Jwt): Map<String, Any> {
        return jwt.claims
    }
}
