# microservices
Basic overview of spring cloud based micro-services

Goals of Spring Cloud is to provide libraries needed to apply common pattens needed in distributed applications.
  1)  Distributed/ Versioned/ Centralized Configuration Management  
  2)  Service Registration and Discovery
  3)  Load Balancing
  4)  Service to service calls
  5)  Circuit Breakers
  6)  Routing, etc.

Applications involve many external configurations(not the ones in application.properties) such as 
1) Connections to other resources, other applications
2) Where resources are located
3) How to connect to the DB etc. 

Application configuration can be setup using the following strategies:

● Package configuration files with application(jar/war contains config information) but this requires rebuild, restart every time any change has been made

● Configuration files in common file system but this cannot be replicated on cloud(as opposed to windows and unix boxes)

● Use environment variables but this needs to be done differently on different platforms. Configuration on Linux is different from windows, etc. It is problematic when we have large number of individual variables to manage / duplicate

● Use a cloud-vendor specific solution but has an effect of making our application coupled to specific environment


We want external configurations to:

● Be able to cater to large number of dependent services(usually requires a lot of manual work)

● Ensure dynamic updates without restage/restart

● Ensure proper version control for traceability


Above mentioned challenges can be mitigated by using the following desired solutions for configuration by making it:

● Platform, Cloud-Independent and Language-independent

● Centralized

● Dynamic to update settings while an application is running

● Controllable

● Passive by the virtue of which services (Applications) should do most of the work themselves by self-registering



Finally, the solution can be found as under:

● Use Spring Cloud Config for external configuration management. This provides centralized, externalized, secured, easy-to-reach source of application configuration

● Use Spring Cloud Bus to provide a simple way to notify the clients to config changes(no restage/restart needed)

● Use Spring Cloud Netflix Eureka to ensure "Service Discovery" which allows applications to register themselves as clients

For more information on these topics, refer to projects section which covers these concepts in detail. 
Link: https://github.com/vikaskundarapu/microservices/projects
