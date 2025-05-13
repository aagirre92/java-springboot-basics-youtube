# Java Spring Boot Notes

## Java Build Tools

- **Maven** (most commonly used, easy to learn)
- **Gradle** (used in A360 SDK)

**Maven** uses a `pom.xml` file in the root directory to define dependencies (similar to `requirements.txt` in Python).

To add new packages:
1. Visit [Maven Central](https://central.sonatype.com)
2. Copy/paste the dependency snippet into `pom.xml`
3. Click the Maven refresh icon (top-right in IntelliJ)

We used this to add the Spring Web dependency.
> ✅ You can also add dependencies directly in IntelliJ: in `pom.xml`, under `<dependencies>`, right-click → *Add Starters* — very intuitive.

**Best practice:** remove `<version>` tags from Spring Boot dependencies — let the parent handle it.

### Dependencies added in this project

- `spring-boot-starter-web` (includes Tomcat, Web, Jackson, etc.)
- `spring-boot-devtools` for auto-reload (similar to `debug=True` in Flask; Java takes ~10 seconds to refresh)

---

## How to Start a Spring Boot Project

### Option 1: Via [https://start.spring.io](https://start.spring.io)

- Choose project type (Maven/Gradle), language, Spring Boot version, JDK, and dependencies
- Download the generated ZIP → import into IDE

### Option 2: Via IntelliJ (Ultimate Edition only)

- Create a new Spring Boot project directly inside IntelliJ
- Select dependencies, language, SDK, etc.

---

## Project Structure

- Main code goes in `/src`
- `/resources` contains:
    - Static files (HTML, etc.)
    - `application.properties` (like `config.py` in Flask — used for key-value pairs)

---

## Core Concepts

### Spring MVC

**Model-View-Controller pattern** for building web apps.

- **Model**: Data/Business logic
- **View**: Frontend (HTML, Thymeleaf, etc.)
- **Controller**: Handles HTTP requests

```java
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, Spring Boot!";
    }
}
```

---

### Debugging Spring Boot Applications

- Set breakpoints in IntelliJ and run using **Debug** mode.
- Use `spring-boot-devtools` for automatic app reload on code changes.  
  ⚠️ Note: In Java, reload typically takes around 10 seconds.

- print statements CLAVE

```
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

private static final Logger logger = LoggerFactory.getLogger(MyClass.class);

logger.info("Debug message here");
```

Control log levels in *application.properties* file:
```text
logging.level.org.springframework=DEBUG
```
### Configuring App properties

Use *application.properties* in the /resources folder to store key/value pairs:

```text
spring.application.name=my-app
```

Inject a property in the code with the ```@Value``` annotation:

```java
import org.springframework.beans.factory.annotation.Value;

@Value("${spring.application.name}")
private String appName;
```

### Dependency Injection (IMPORTANT)

**Importance of using Interfaces with Classes**

https://youtu.be/gJrjgg1KVL4?t=2869

- Spring core
- IOC container
- Beans with annotations