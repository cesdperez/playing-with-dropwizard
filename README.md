This project is based on this tutorial: [part I](https://www.sitepoint.com/tutorial-getting-started-dropwizard/), [part II](https://www.sitepoint.com/tutorial-getting-started-dropwizard-crud/). Then I made some other changes for playing around.

I added [lombock](https://projectlombok.org/) so you will need the proper plugin for supporting it in your IDE.

# Events

How to start the Events application
---

1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/playing-with-dropwizard-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`
