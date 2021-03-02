# Advance Java 

Banuprakash C

Full Stack Architect,

Co-founder Lucida Technologies Pvt Ltd.,

Corporate Trainer,

Email: banu@lucidatechnologies.com; banuprakashc@yahoo.co.in

https://www.linkedin.com/in/banu-prakash-50416019/

https://github.com/BanuPrakash/ciscoadv
-----------------------------------------------------------------
Softwares Required:
1) Java 8+
	https://www.oracle.com/in/java/technologies/javase/javase-jdk8-downloads.html
2) Eclipse for JEE  
	https://www.eclipse.org/downloads/packages/release/2020-03/m1/eclipse-ide-enterprise-java-developers
3) MySQL  [installation details on GIT: https://github.com/BanuPrakash/ciscoadv ]
----------------------------------------------------------------------------------

Java 8 streams and annotations
JEE web components ==> Servlets, JSP and JDBC to MySQL
Spring, Spring Boot, JPA using Hibernate ==> Web and RESTful web service
========================================================================

	Annotation ==> Metadata

	1) Who uses it?
		=> Compiler
		=> Classloader
		=> JRE
	2) Where can i use it?

	@Override 

	class Base {
			public void doTask() {

			}
	}

	class Derived extends Base {
			@Override
			public void daTask() {

			}
	}
=======================
	Annotations

	@interface Override {
	}

	they dont have fields and methods; can have only properties

	@interface Sample{
		String name();
	}

	name is a property

	name ="Tim"; setter


	@RequestMapping(value="/api/products")

	Here "name" is a property
	  
==================================

@Table
and 
@Column

@Table(name="products")
public class Product {
	@Column(name="pid", type="NUMERIC(10)")
	private int id;
	@Column(name="prd_name")
	private String name;
	@Column(name="amount", type="NUMERIC(12,2"))
	private double price;
	
	private String category;
=========================================

	
	@Box(name="hathway")
	public class Channels {

	}

	@Retention(CLASS)
	@interface Box {

	}

	Hathway settop box classloader ==> loadClass()  
=========================================================================

Java 8 streams
==============

Functional interface?
	Any interface with only one abstract method

	@FunctionalInterface
	interface Runnable {
		void run();
	}

	interface Sample {
		void doTask();
		public default void someTask() {
			// code
		}
	}
================================

interface Flyable {
	void fly();
}

class Bird implments Flyable {
	// state and behivour

	public void fly() {
		//
	}
}


Flyable f = new Bird();
// Anonymous class
Flyable f = new Flyable() {
	public void fly() {
		// code here
	}
};
==============================
 

OOP ==> we write methods which are tightly coupled to state of object

class Account {
	deposit(amt) { this.balance += amt; }
	withdraw(amt) { this.balance -= amt;}
}


Functional style of Programming: functions which are not tightly coupled to any object

High Order Functions:
	1) Any function which accepts other functions as arguments
	2) function return a function

Commonly used HOF with streams:
		1) filter ==> gives a subset based on predicate
		2) map ==> transform data
		3) reduce ==> aggregate [ max, min, avg, count, sum, ..]
		4) forEach ==> iterate takes consumer as function


Java 8 streams ==> from file, network, collection, database [ RxJDBC , mongodb tail]
========================================================================================

JDBC ==> Java Database connectivity
integration API to interact with RDBMS

Java provides interfaces; Database vendors provide implementation classes [jar file]

1) We need to load vendor specific classes into JVM

	Class.forName("driver class");

	Class.forName("oracle.jdbc.OracleDriver");

	Class.forName("com.mysql.jdbc.Driver");

2) Establish a database Connection
	DriverManager or DataSource

	DriverManager literally opens and closes connection ==> not good for enterpirse application

	DataSource ==> pool of database connection

	Connection con = DriverManager.getConnection(url, username, pwd);

3) interfaces to send SQL
	a) Statement
		SQL which doesn't depend on IN parameters
		BAD code:
		String query = "SELECT * FROM accounts WHERE custID='" + request.getParameter("id") + "'";
		http://example.com/app/accountView?id=' or '1'='1
	b) PreparedStatement
		SQL with IN parameters
		String query = "SELECT * FROM accounts WHERE custID=?"

		pstmt.setInt(1,20);

	c) CallableStatement	
		use for StoredProcedures

4) ResultSet
	cursor to traverse thro the fetched records
==========================================

mysql> create database cisco_db;
mysql> use cisco_db;
mysql> create table products (id int PRIMARY KEY AUTO_INCREMENT, name VARCHAR(100), price double, category VARCHAR(50), quantity int);

 insert into products values (0, 'iPhone 12', 120000.00, 'mobile',100);
 insert into products values (0, 'Sony Bravia', 135000.00, 'tv',100);
===========================================================

ORM Hibernate, iBatis ==> JDBC ==> RDBMS
==========================================

JEE --> Java Enterprise Edition --> Web Components

JEE WebComponents:
1) Servlet
2) JSP
3) Filter
4) Listener
5) HTML, CSS and JS
===========================================

	Servlets are server side java code; they are singleton and multithreaded by default
1) execute based on client request
Servlet ==> Controller
JSP ==> Presentation [ static + dynamic]
Filter ==> Interceptor pattern [ Security / Logging / Encrption / profile /..]

2) events within engine
Listener ==> for event based execution
==============

war ==> Web Archive ==> app.war ==> engine


web.xml

	<servlet>
		<servlet-name>Login</servlet-name>
		<servlet-class>com.cisco.prj.web.LoginServlet</servlet-name>
	</servlet>

	<servlet-mapping>
			<servlet-name>Login</servlet-name>
			<url-pattern>/login</url-servlet>
	</servlet-mapping>

Annoation

@WebServlet("/login")	
class LoginServlet extends HttpServlet {

}


Run As => Maven Build ==> Goals: jetty:run

http://localhost:8080


	Servlet should not have presentation logic [ locus , carrier of data]

	JSP ==> dynamic content [ Traditional web application]
===================

Server side redirection:
Multi stage processing of data
redirection happens within the engine


Client side redirection:
redirection is done by browser based on URL sent b server
response.sendRedirect("index.html");
can't carry data between resources
===================================================

	Application Logic ==> Servlet
	Presentation logic ==> JSP
==========================================
	Session Tracking:

	Http Protocol is a stateless protocol
	Request and Response objects are destryoed by engine/container once response is commited.

	Session Tracking ==> a mechanism to track converational state of client
=======================================
	Filter 

	SecurityFilter.java
	login.jsp
	LoginServlet.java
=============================
Servlet / JSP / Filter == > based on URL and client request

Listener ==> not based on URL; events
========================================================




	