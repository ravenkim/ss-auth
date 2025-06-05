package ssauthserver.health

import org.springframework.stereotype.Service

@Service
class HealthCheckService {
    fun getHealthStatus(): Map<String, String> {
        return mapOf("status" to "UP")
    }
}
