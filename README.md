# e-commerce-platform-backend
E-Commerce website SpringBoot backend project.

## How to run
* Clone the repository
* Install JDK 17 and Maven 3.x
* Build project and run tests through `mvn clean package`
* Start application through:
```
 java -jar -Dspring.profiles.active=test target/ecommerce-0.0.1.jar
```
or 
```
mvn spring-boot:run -Drun.arguments="spring.profiles.active=test"  
```
If the application is starts, you should be able to see something 
like this:
```
2023-03-12T20:33:22.957+01:00  INFO 54268 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2023-03-12T20:33:22.974+01:00  INFO 54268 --- [           main] com.me.ecommerce.EcommerceApplication    : Started EcommerceApplication in 4.23 seconds (process running for 4.664)
```
