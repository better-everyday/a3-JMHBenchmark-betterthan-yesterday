# Assignment 3 - JMH Micro-Benchmark

* **Author**: [William Pol](polw@mcmaster.ca)
* **Program**: B. Eng. In Software Engineering
* **Course code**: SFWRENG 2AA4
* **Course Title**: Software Design I - Introduction to Software Development
* Term: *Level II - Winter 2024*

## Setup
Creating the JMH project was quite simple with the help of the JMH
github page: [JMH Github](https://github.com/openjdk/jmh/blob/master/README.md)

Micro-benchmarks were set up with the help of this [Baeldung article](https://www.baeldung.com/java-microbenchmark-harness)

The created benchmarks are very similar to my test cases in the [A3 assignment](
https://github.com/2AA4-W24/a3-maze-runner-take-two-betterthan-yesterday).
The example mazes used were also from the same repository.

To build the program
```bsh
$ mvn clean package
$ java -jar target/benchmarks.jar
```

## Issues
For some reason, the program did not recognize A3 as a dependency even
though it was added to the `pom.xml` file.
I found the fix [here](https://github.com/spring-projects/spring-boot/issues/6792),
which required adding a
```xml
<classifier>exec</classifier>
```
line to the Springboot plugin.

Initially it was 
```xml
<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
    <version>3.2.0</version>
    <executions>
        <execution>
            <goals>
                <goal>repackage</goal>
            </goals>
            <configuration>
                <mainClass>${mainClass}</mainClass>
            </configuration>
        </execution>
    </executions>
</plugin>
```
now it is
```xml
<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
    <version>3.2.0</version>
    <executions>
        <execution>
            <goals>
                <goal>repackage</goal>
            </goals>
            <configuration>
                <classifier>exec</classifier>
                <mainClass>${mainClass}</mainClass>
            </configuration>
        </execution>
    </executions>
</plugin>
```

I also had to physically comment out loggers in the maze runner code because the loggers
were throwing errors.