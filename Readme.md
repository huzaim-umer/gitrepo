## **Morell CRM**
#### **Requirements**

For building and running the application you need:

- JDK 11 or above

- Maven

#### **Running the application locally?**

There are several ways to run a Spring Boot application on your local machine. One way is to execute the main method in the com.morelllcrm.MorellCrmApplication class from your IDE.

Alternatively you can use the Spring Boot Maven plugin like so:

    mvn spring-boot:run

Or you can run the code by run tab in the main menu.

#### Refer to the below api documentation
https://documenter.getpostman.com/view/7575451/TzmBDuMT#b1d9206a-03db-40c5-b0e6-d14f524c0ddd

#### If you want to drop tables and start from fresh
Set this property to "create-drop" in the application.properties file. Later chnage it to "update"

##### Hibernate ddl auto (create, create-drop, update)
    spring.jpa.hibernate.ddl-auto = create-drop   # backendjava
# backendjava
