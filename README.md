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