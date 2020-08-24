import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.3.3.RELEASE"
	id("io.spring.dependency-management") version "1.0.10.RELEASE"
	kotlin("jvm") version "1.3.72"
	kotlin("plugin.spring") version "1.3.72"
}

group = "me.tigranes"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}

	val kotlinVersion = "1.3.72"

//	Spring Context will provide our application with the following: Core support for dependency injection,
//	Core support for transaction management, Core support for web applications, Core support for data access,
//	Core support for messaging, Core support for testing, Miscellaneous.
	implementation( "org.springframework:spring-context")

//	In addition to this, Spring Boot Starter Web (spring-boot-starter-web) adds the dependencies needed for
//	building web applications. This includes RESTful applications using Spring MVC, which is exactly what we need.
//	Tomcat is used as the default embedded container for our application. Without it, we wouldn't be able to run
//	our application.
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-web")

//	Spring AOP will provide us with support for aspect-oriented programming. Spring Actuator
//	is a sub-project of Spring Boot. It adds several important services to your Spring application.
//	When the Actuator is configured in your Spring Boot application, you can perform interaction
//	and monitor your application behavior by executing misc HTTP endpoints exposed by Spring Boot
//	Actuator. Actuator offers the following out-of-the-box endpoints: Application health, Bean details,
//	Version details, Configurations, Logger details, and many more.
	implementation("org.springframework:spring-aop")
	implementation("org.springframework.boot:spring-boot-starter-actuator")

//	Spring Web and Web MVC will provide our application with access to Spring MVC, request mapping, and
//	all related features. It's important to note that since we didn't perform a test, it is thanks to the
//	Spring Boot Gradle plugin that we achieved the following benefits: Collecting all JARs on the classpath
//	and building a single, runnable JAR, Searching for the main() application method to flag as a runnable
//	class that is an entry point to our application, Providing a dependency resolver that sets the version
//	number to match Spring Boot dependencies
	implementation ("org.springframework:spring-web")
	implementation ("org.springframework:spring-webmvc")

	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:${kotlinVersion}")
	implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}
