package ssauthserver.health

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthCheckController(
    private val healthCheckService: HealthCheckService
) {

    @GetMapping("/health")
    fun checkHealth(): Map<String, String> {
        return healthCheckService.getHealthStatus()
    }
}
