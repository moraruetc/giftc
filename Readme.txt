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