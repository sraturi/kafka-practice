# Getting Started
### Docker
* `docker compose up zookeeper -d`
* `docker compose up kafka`
### Run application
* `./gradlew bootRun`
### Make requests
*  `curl -X POST http://localhost:8080/logs -H "Content-Type: application/json" -d '"Log message from Service B"'`


### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/3.3.2/gradle-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.3.2/gradle-plugin/packaging-oci-image.html)
* [Spring for Apache Kafka](https://docs.spring.io/spring-boot/docs/3.3.2/reference/htmlsingle/index.html#messaging.kafka)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

