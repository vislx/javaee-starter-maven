# JavaEE quick-starter with Maven
This quick-starter aims to facilitate fast set up for JavaEE (J2EE) projects with Netbeans IDE. The configuration is usually one blocker for beginner to enjoy JavaEE. This quick-starter minimize the configuration for basic development purpose. For advanced development, you are not recommended to set up your project by using this quick-starter.

## Updates
_(For non-maven version: [vislx/javaee-starter](https://github.com/vislx/javaee-starter))_

- JDBC/JPA persistent (23 Aug 2017)
- Webserices/RESTful APIs (23 Aug 2017)
- NamedQuery (24 Aug 2017)
- Basic fullstack CRUD (24 Aug 2017)


## Requirement
- Skip this section if you have already set up the environment for JaveEE development
- Java (7 or 8)
- Maven (3.5 or compatible)
- Netbeans IDE (8.0 or higher) with Glassfish Server. To verify proper installation of Netbeans IDE and Glassfish Server, run Glassfish Server and access admin console by [localhost:4848](http://localhost:4848/)
- Database:
    + Local or cloud jdbc-compatiable databases. MySQL is preferred.
    + Get the following parameters prepared: **host**, **port**, **database name**, **username** and **passowrd**. Make sure all rights are granted for the dabases to the user.
    + Create proper JDBC connection pool in Glassfish server admin console (by default can be accessed by [localhost:4848](http://localhost:4848/)) with the parameter above. Click 'Ping' button on the page to test connectivity.
    + Create proper JDBC resource with the connection pool created in previous step. Conventionally, JDBC resource should name like 'jdbc/XXXX'.

## Deploy
1. Clone the repo to your local and open in Netbeans IDE (prefered):
    ```
    git clone https://github.com/vislx/javaee-starter.git
    ```
    or download the repo as .zip file
2. Under ```javaee-starter-mvn/javaee-starter-mvn-classlib/src/main/resources/META-INF/persistence.xml``` in your file system (or ```javaee-starter-mvn-classlib/Other Sources``` in Netbeans IDE project browser), find ```persistence.xml```. Change 'Data Source' to the JDBC resources created in the previous step.
3. In Netbeans IDE, start Glassfish server. Then in project browser, right click on **javaee-starter-mvn** project and click 'Clean and Build', after finish right click on **javaee-starter-mvn-ear** project and click 'Run'.
