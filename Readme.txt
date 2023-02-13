MVN default dependencies are for developing in localhost with local MySQL
run with
mvn spring-boot:run -Dspring-boot.run.profiles=dev

MVN <cloud> profile & spring prod profile are adding the libraries required by GCP env
run with
mvn spring-boot:run -Dprofile=cloud -Dspring-boot.run.profiles=prod