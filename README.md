


```
ss-auth/
│
├── auth-core/                          # 인증과 인가 관련 서비스 코드
│   ├── src/                            # Kotlin 코드
│   │   ├── main/                   
│   │   │   ├── kotlin/                 # 주요 Kotlin 소스 코드
│   │   │   │   ├── com/authserver/      
│   │   │   │   │   ├── config/         # Spring Security 설정 및 OAuth2 설정
│   │   │   │   │   ├── controller/     # 인증 관련 API (로그인, 로그아웃 등)
│   │   │   │   │   ├── service/        # 인증 로직 서비스
│   │   │   │   │   ├── model/          # 엔티티, DTO 등 모델 클래스
│   │   │   │   │   ├── repository/     # 데이터베이스 관련 JPA Repository
│   │   │   │   │   ├── util/           # JWT 처리, OAuth2 로그인 처리 등 유틸리티 클래스
│   │   │   │   │   ├── security/       # SecurityConfig, JWT 필터 등
│   │   │   │   │   ├── exception/      # 예외 처리
│   │   │   │   │   └── oauth/          # 외부 인증 (카카오, 구글, 깃허브 등)
│   │   │   └── resources/
│   │   │       ├── application.yml     # 애플리케이션 설정 파일
│   │   │       └── db/                 # 데이터베이스 관련 설정 파일
│   ├── build.gradle.kts                # Gradle 설정
│   ├── gradlew                         # Gradle wrapper 파일
│   └── gradlew.bat                     # Windows용 Gradle wrapper 파일
│       
├── db/                                 # DB 설정 및 초기화 파일
│   ├── docker/                         # DB Docker 설정 (docker-compose 등)
│   ├── migrations/                     # 데이터베이스 마이그레이션 스크립트
│   └── schema.sql                      # DB 초기 스키마 파일
│       
├── docker-compose.yml                  # Docker 관련 설정 파일 (DB 포함)
├── README.md                           # 프로젝트 설명
└── .gitignore                          # Git에서 무시할 파일들

```


.
├── main
│   ├── kotlin
│   │   └── com
│   │       └── ssauthserver
│   │           ├── SsAuthServerApplication.kt
│   │           ├── auth
│   │           ├── config
│   │           │   └── DevStartupLogger.kt
│   │           └── healthcheck
│   │               ├── controller
│   │               │   └── HealthCheckController.kt
│   │               └── service
│   │                   └── HealthCheckService.kt
│   └── resources
│       ├── application-dev.properties
│       └── application.properties
└── test
└── kotlin
└── com
└── ssauthserver
└── SsAuthServerApplicationTests.kt



당신의 프로젝트 도메인생기면 

추천 패키지명: kr.limelab.ssauthserver
폴더 구조: src/main/kotlin/kr/limelab/ssauthserver