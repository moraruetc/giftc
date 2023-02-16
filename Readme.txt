MVN default dependencies are for developing in localhost with local MySQL
run command:
mvn spring-boot:run -Dspring-boot.run.profiles=dev

package command:
mvn package 

MVN <cloud> profile & spring prod profile are adding the libraries required by GCP env
run command:
mvn spring-boot:run -Dprofile=cloud -Dspring-boot.run.profiles=prod

package command:
mvn package -Dprofile=cloud 






-----
<!--doar pentru GCP testing-->
			<plugin>
				<groupId>com.google.cloud.tools</groupId>
				<artifactId>jib-maven-plugin</artifactId>
				<version>3.3.1</version>
				<configuration>
					<container>
                     <jvmFlags>
                         <jvmFlag>-Dspring.profiles.active=prod</jvmFlag> // spring.run.profiles
						 <jvmFlag>-Dspring.config.location=classpath:/application.properties, classpath:/application-prod.properties</jvmFlag>
                    </jvmFlags>  
                    </container>
				</configuration>
			</plugin>

adauga si:
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

mvn package -Dprofile=cloud  -DskipTests - nu e nevoie

mvn compile jib:build -Dimage=gcr.io/moro-1-373510/giftcc:v1 -Dprofile=cloud  |||  gcr.io/moro-1-373510/giftcc:v1

kubectl create deployment giftcc-deployment \
  --image=gcr.io/moro-1-373510/giftcc:v1


docker run --rm -p 8080:8080  gcr.io/moro-1-373510/giftcc:v1


FROM maven:3.6.3-jdk-11 AS build-env
COPY ./pom.xml ./pom.xml
RUN mvn dependency:go-offline -B
COPY ./src ./src
RUN mvn package

FROM gcr.io/distroless/java:11
COPY --from=build-env /target /app
WORKDIR /app
EXPOSE 8080
CMD ["testapp-0.0.1-SNAPSHOT.jar"]