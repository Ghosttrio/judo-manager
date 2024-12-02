## 유도매니저(Judo Manager)

---

### 프로젝트 목적
- 유도장에서 관원 관리나, 회비 관리 등에서 불편함이 있는 문제를 해결하기 위해 개발.
- 여러 상황에서 다양한 기술 및 방법론 적용 연습을 위해 개발.

### Architecture

Monolithic Architecture -> Gradle Multi Module -> MSA 흐름으로 구성했습니다.

![전체아키텍처.png](docs%2Fimg%2F%EC%A0%84%EC%B2%B4%EC%95%84%ED%82%A4%ED%85%8D%EC%B2%98.png)

### Tech Stack
Java, Spring Boot, Spring Security, Spring Batch, Spring Validation, Spring Cloud, Elasticsearch, Kibana, Logstash, Redis, MySQL, Kafka, Zookeeper, Docker, Jenkins, SonarQube, Spring Data JPA, QueryDSL, Grafana, Prometheus, Zipkin, RabbitMQ, JUnit, Mockito, Fixture Monkey, Swagger

### Service
```markdown
judo-manager-admin          관리자 서비스
judo-manager-apigateway     API Gateway 서버
judo-manager-attendance     출석 서비스
judo-manager-auth           인증 서비스
judo-manager-batch          배치 서비스
judo-manager-board          게시판 서비스
judo-manager-chat           채팅 서비스
judo-manager-configuration  Configuration 서버
judo-manager-dojo           도장 서비스
judo-manager-eurekaserver   유레카 서버
judo-manager-notice         공지사항 서비스
judo-manager-payment        결제 서비스
judo-manager-schedule       스케줄 서비스
judo-manager-search         검색 서비스
judo-manager-user           유저 서비스
```

### Package
Hexagonal Architecture(Port & Adapter) 를 적용했습니다.
```markdown
├─ config
├─ domain
├─ application
│  ├─ port
│  │  ├─ in
│  │  └─ out
│  └─ service
├─ adapter
│  ├─ in 
│  └─ out
├─ common
└─ mapper
```
### CI/CD
![cicd.png](docs%2Fimg%2Fcicd.png)

### Auth Sequence
![auth.png](docs%2Fimg%2Fauth.png)

### Chat
![chat.png](docs%2Fimg%2Fchat.png)

### Search
![search.png](docs%2Fimg%2Fsearch.png)

### Payment Sequence
![payment.png](docs%2Fimg%2Fpayment.png)

### Logging
![logging.png](docs%2Fimg%2Flogging.png)

### Monitoring
![monitoring.png](docs%2Fimg%2Fmonitoring.png)