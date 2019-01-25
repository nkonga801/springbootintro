### Spring Boot Fundamentals 


Objects are backbones of any application.
Beans (Objects) are managed by Spring.
Beans and Dependency Injection (IoC Container)

Bean Configuration
- XML (Integrating with third party applications)
- Annotations
- Java Bean Configuration (Clean)
- Groovy Bean Conf.

Bean Scope ```@Scope(“session”)```
- *Singleton*
- Prototype
- Request
- Session
- Global Session

Dependency Injection ```@Autowired```
- Property based (not test compatible)
- *Setter method based*
- *Constructor based.*

```java
@SpringBootApplication
//@Configuration. (Application Scope or Global)
//@EnableAutoConfiguration
//@ComponentScan({“com.abc", “com.def”})
public class SpringBeansApplication {
  public static void main(String[] args) {
    ApplicationContext ctx = SpringApplication.run(SpringBeansApplication.class, args);
    String[] beanNames = ctx.getBeanDefinitionNames();
    Arrays.sort(beanNames);
    for (String name : beanNames ) {
      System,out.println(name);
    }
  }
}
```
@ComponentScan(“list of packages”)
Manages all the class that have the following annotations

- Controller
- RestController
- Service (customName)
- Repository
- Component

You can define a POJO class and declare it as a @Bean in main class and use it - application scope.
```java
@Bean
public User user() {
  return new User(“Dan”, “Vega”);
}
System.out.println( ctx.getBean(“user”).toString() );
```
**Externalized Configuration** – prioritized based on the following order.
 1. Command Line Arguments JNDI Attributes from java:comp/env Java
 2. System properties (System.getProperties()) OS Environment variables.
 3. A RandomValuePropertySource random.* only.
 4. Profile-specific application properties outside packaged jar say application-{profile}.properties
 5. Profile-specific application properties inside packaged jar say application-{profile}.properties
 6. Application properties outside of you packaged jar say application.properties
 7. Application properties inside of you packaged jar say application.properties
 8. @propertySource annotations on your @Configuration classes.
 9. Default properties (SpringApplication.setDefaultProperties)
    
```java
@Value(“${pageController.msg}”)
private String pageControllerMsg;
```
**Mapping Properties to POJOs**

@EnableConfigurationProperties. – main class\
@ConfigurationProperties.  - POJO\
Type Safe\
IDE Support\
Validation (@Valid)\
Note: Mapping Configuration to POJOs.

**Auto Configuration**

@SpringBootApplication (includes @EnableAutoConfiguration) .         
@EnableAutoConfiguration (exclude={DataSourceAutoConfiguration.class}) .  

How Auto Configuration works
- Where to find them: /META-INF/spring.factories
- When to use them: @Conditional

Displayed in the auto-configuration report:```--debug``` logs auto-configuration report

*Summary*
- Singleton is the default bean scope.
- Property based injection is valid method for auto wiring dependencies but it makes testing your application hard.
- YAML is a superset of JSON.
- You can use both application.properties and application.yaml files in the same project.
- If we have both an application.properties file and a application.yaml files get merged. Application.properties
WINS!.
- When defining properties using multiple property sources order does matter.
- Configuration key we use to define the current profile. ```spring.profiles.active=production```
- ```@Value``` annotation can we use to inject a property value into our components.

Ref: 
[Learn Spring Boot - Rapid Spring Application Development](https://www.udemy.com/spring-boot-intro/)
