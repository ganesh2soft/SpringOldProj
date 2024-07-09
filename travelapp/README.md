<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>3.0.5</version>
		<relativePath /> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.villi</groupId>
	<artifactId>ems33jwt</artifactId>    lombok,spring-boot-starter-data-jpa spring-boot-starter-data-jdbc -security devtools er-web mysql-connector-j
	<version>0.0.1-SNAPSHOT</version>
	<name>ems33jwt</name>
	<description>Demo project for Spring Boot</description>
	<properties>
		<java.version>17</java.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			 <scope>provided</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-actuator</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jdbc</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>com.mysql</groupId>
			<artifactId>mysql-connector-j</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.apache.tomcat.embed</groupId>
			<artifactId>tomcat-embed-jasper</artifactId>
			<scope>provided</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>jakarta.servlet.jsp.jstl</groupId>
			<artifactId>jakarta.servlet.jsp.jstl-api</artifactId>
		</dependency>
		<dependency>
			<groupId>org.glassfish.web</groupId>
			<artifactId>jakarta.servlet.jsp.jstl</artifactId>
		</dependency>
	</dependencies>
	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>
</project>




Traveller Entity
Table name: tbl_traveller
Class: TRTraveller.java

travellerid  11 (auto)
travellername john
travellerpwd dfd
roles domesticcustomer, premiumcustomer

Request Local tour entity
Table Name: tbl_local
Class: TRLocalTour.java

localid (auto)
travellerid (foreign key)
location ooty, mysore
nofpeople  4

Request Foreign tour entity
Table Name: tbl_foreign
Class: TRForeignTour.java

foreignid (auto)
travellerid (foreign key)
location Italy , Singapore
noofpeople  4
isPassportValid

/listtour-- get Logged in travellers (Colllections in JAVA)
/welcome --get ..permitall
/addtraveller  -- POST by admin  permitall 
/login--login user permitall 
/requestlocaltour-- POST for domestic ..authenticated
/requestforeigntour- POST for foreign..authenticated
/listtravellers --- GET by admin



/addtraveller------------

{
    "travellername": "john",
    "travellerpwd": "a",
    "roles": "domesticcustomer"
} 

{
    "travellername": "mary",
    "travellerpwd": "a",
    "roles": "foreigncustomer"
}

/requestlocaltour------------------
{
    "location": "Mysore",
    "noofpeople": "4"
}
{
    "location": "Ooty",
    "noofpeople": "3"
}

/requestforeigntour----------------

{
    "country": "Italy",
    "noofpeople": "5",
    "isPassportValid": "false"
}
{
    "country": "Singapore",
    "noofpeople": "2",
    "isPassportValid": "true"
}

/listtour----------------------
pack : wonder
type : local
location : mysore
costperhead : 35000
passport:NR

pack: honeymoon
type: foreign
location: sweden
costperhead:400000
passport:required

pack :family
type: local
location: tirupati
costperhead:2000
passport:NR

pack:senior
type:foreign
location:Malaysia
costperhead:500000
passport:required