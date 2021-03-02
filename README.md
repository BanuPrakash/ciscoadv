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
 



