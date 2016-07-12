# Scala Blog Example

We present a very simple Scala application. See the [blog](https://davidainslie.github.io/scala-blog-example).

If you don't have Scala set up on your machine, see the footnote below.

To run the examples (from a command prompt at the root of this project):
```
$ sbt run
```

As there are two examples and we have not stipulated which to run, sbt will tell us that indeed two are available by presenting:
```
Multiple main classes detected, select one to run:

 [1] com.kissthinker.trading.WebServiceExample1App
 [2] com.kissthinker.trading.WebServiceExample2App
^JEnter number: 
```

# Footnote

Scala runs on the JVM. You need Java installed, and then install Scala.

The following notes are for Mac users. Regarding other platforms, please see the links provided.

### Installing Homebrew for Mac
The following installations use [Homebrew](http://brew.sh/). Paste the the following at a command/terminal prompt:
```
$ /usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
```

### Installing Java on your computer

To install Java, either go to the [Java website](http://www.oracle.com/technetwork/java/javase/downloads/index.html) or, if you are lucky to have a Mac with Homebrew installed, then the following (from a command console) will install the latest [Open JDK](http://openjdk.java.net/):
```
$ brew update
$ brew tap caskroom/cask
$ brew install brew-cask
$ brew cask install java
```

### Installing Scala on your computer

To install Scala, either go to the [Scala website](http://www.scala-lang.org/download/) or, if you are lucky to have a Mac with Homebrew installed, then the following (from a command console) will install the latest version of Scala:
```
$ brew install scala
$ brew install sbt
```

From these the above commands: Scala is... well, you can guess.

SBT is Scala's interactive build tool.










Global Entry Integration Service
================================
Importing published "application submissions" formatted as JSON into Registered Traveller Caseworker and interfacing with Global Entry modules which deal with USA web services.

Application built with the following (main) technologies:

- Scala

- SBT

- Akka

- Spray

- MongoDB

Introduction
------------
TODO

Application
-----------
The application is configured as per any Akka application, where the default configuration file is "application.conf".
This default file can be overridden with other "conf" files and then given to the application upon boot with the following example Java option:
```bash
-Dconfig.file=test-classes/application.test.conf
```

Individual configuration properties can be overridden again by Java options e.g. to override which Mongodb to connect:
```bash
-Dmongo.db=some-other-mongo
```

where this overrides the default in application.conf.

Booting the application (uk.gov.homeoffice.vet.registeredtraveller.Boot) exposes a RESTful API e.g. the following URL could be given in a browser, a browser's REST client plugin or curl:
```bash
http://localhost:9100/registered-traveller
```

this would get back JSON that simply shows the application is alive.

Build and Deploy
----------------
The project is built with SBT. On a Mac (sorry everyone else) do:
```bash
brew install sbt
```

It is also a good idea to install Typesafe Activator (which sits on top of SBT) for when you need to create new projects - it also has some SBT extras, so running an application with Activator instead of SBT can be useful. On Mac do:
```bash
brew install typesafe-activator
```

To compile:
```bash
sbt compile
```

or
```bash
activator compile
```

To run the specs:
```bash
sbt test
```

Note: Do not turn off the CONSOLE logging in test/resources/logback.xml as there are Specs that rely on this

To actually run the application, first "assemble" it:
```bash
sbt assembly
```

This packages up an executable JAR - Note that "assembly" will first compile and test.

Then just run as any executable JAR, with any extra Java options for overriding configurations.

For example, to use a config file (other than the default application.conf) which is located on the file system (in this case in the boot directory)
```bash
java -Dconfig.file=test-classes/my-application.conf -jar <jar name>.jar
```

Note that the log configuration file could also be included e.g.
```bash
-Dlogback.configurationFile=path/to/my-logback.xml
```

So a more indepth startup with sbt itself could be:
```bash
sbt '; set javaOptions ++= Seq("-Dconfig.file=target/scala-2.11/test-classes/application.test.conf", "-Dlogback.configurationFile=target/scala-2.11/test-classes/logback.test.xml"); run'
```

And to run with SSL:
```bash
sbt '; set javaOptions += "-Dconfig.resource=application.ssl.conf"; run'
```

And other examples:

Run with Amazon SQS and without GES schedulers:
```bash
sbt '; set javaOptions ++= Seq("-Dakka.pollers.poll=false", "-Damazon.sqs.subscribe=on"); run'
```

booting from project root:
```bash
java -Dspray.can.server.port=8080 -jar target/scala-2.11/<jar name>.jar
```

and running from directory of the executable JAR using a config that is within said JAR:
```bash
java -Dconfig.resource=application.uat.conf -jar <jar name>.jar
```

Finally you can perform a quick test of the application by calling one of the monitor API e.g. making a cURL call to the application:
```bash
curl http://localhost:9100/mongodb 
```
