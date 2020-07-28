“Clearing Feed”

•	GitHub URL: https://github.com/aishkul1012/CITIBRIDGE

•	Technology Used:
1.	Angular
2.	MongoDb
3.	Spring Boot
4.	JUnit testing is used to test the validation functions

•	MongoDb Installation and Setup:
1.	Go to https://www.mongodb.com/download-center/community and download the installation package.
2.	Once the package download, click on it and installer wizard will open.
3.	Click on Next straight away and it will take to agreement page.
4.	Accept the agreement by clicking on the checkbox and click on next.
5.	In choose setup type window, click on complete setup button. Custom type is for advanced users.
6.	In service configuration window (under complete) you specify optional settings. But do not change anything and click on next.
7.	In this window, wizard will ask if you want to install MongoDB compass or not, check this checkbox, will take time.
8.	Click on Install and you are ready to install MongoDb.
9.	Once installation is completed, set default port number of mongoDB to “27017”.

•	Angular installation:
1.	To install the Angular CLI, open a terminal window and run the following command:
    npm install -g @angular/cli

2.	To create a new workspace and initial starter app, Run the CLI command ng new and provide the name my-app, as shown here:
   ng new my-app

3.	Navigate to workspace folder such as
  cd my-app
  To generate new component in existing app:
  ng generate c componentName

  to create new service:
  ng generate s serviceName

4.	To run the application:
    Navigate to application folder
    cd my-app
    then type following command
    ng serve

•	Spring Boot setup:
1.	To start with spring Boot, you need java SDK v1.6 or higher.
    So first check out java version:
   $java –version
2.	You can use Spring Boot in the same way as any standard java library. Simply include the appropriate spring-boot-*.jar files on your class path. Spring Boot does not require any special tools integration, so you can use any IDE or text editor; and there is nothing special about a Spring Boot application, so you can run and debug as you would any other Java program.
3.	Maven installation:
    Spring Boot is compatible with Apache Maven 3.0 or above. If you don’t already have Maven installed you can follow the instructions at http://maven.apache.org
4.	Typically your Maven POM file will inherit from the spring-boot-starter-parent project and declare dependencies to one or more “Starter POMs”. Spring Boot also provides an optional Maven plugin to create executable jars.

	Steps for starting application:
1.	Open maven project -> right click on project -> select maven ->” update project”.
2.	Right click on application folder-> select “run as” -> “maven clean”.
3.	Open “SpringBootHelloWorldApplication.java” ->right click ->select run as “java application”.
4.	You will see output like -> all transaction data in json format.
5.	After successful running of project db. will get update.
6.	Go to command prompt and perform following commands.
    >cd firstpg
    >ng serve
7.	Type http://localhost:4200/ on browser 
    You will able to use working project.
    Password for admin login= ” Admin@123”


	Different Pages and their URLS:
1.	Header page: http://localhost:4200/header
2.	To see all transaction table: http://localhost:4200/admin
3.	To check passed transactions only: http://localhost:4200/passedTr
4.	To check failed transactions only: http://localhost:4200/failedTr
