package com.ss.auth.config.security

import com.ss.auth.auth.traditional.TraditionalAuthService
import com.ss.auth.config.oauth.OAuth2AuthenticationSuccessHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
open class SecurityConfig(
    private val traditionalAuthService: TraditionalAuthService,
    private val oAuth2AuthenticationSuccessHandler: OAuth2AuthenticationSuccessHandler
) {

    @Bean
    @Order(2)
    open fun defaultSecurityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf { it.disable() }
            .authorizeHttpRequests { authorize ->
                authorize
                    .requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/api/health", "/api/info", "/api/auth/traditional/login", "/oauth2/**", "/login/oauth2/code/**").permitAll()
                    .anyRequest().authenticated()
            }
            .oauth2Login { oauth2Login ->
                oauth2Login
                    .userInfoEndpoint { userInfo ->
                        userInfo.userService(traditionalAuthService)
                    }
                    .successHandler(oAuth2AuthenticationSuccessHandler)
            }
            .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
        return http.build()
    }

    @Bean
    open fun authenticationManager(authenticationConfiguration: AuthenticationConfiguration): AuthenticationManager {
        return authenticationConfiguration.authenticationManager
    }
}

