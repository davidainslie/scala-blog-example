# Scala took a while to get going. *If you haven't, it's time to get going with Scala.*

[**Scala**](http://www.scala-lang.org/) just might be your best programming investment.

The world of programming languages has long been dominated by the likes of C, C++ and Java. New languages seem to pop up every other week but never get anywhere. Languages that have made it to the top got there because of being in the right place at the right time. This timing is very difficult or lucky - some languages have acquired a position that it seems we are stuck with them, even though we would like something better.

We seem to be in a bit of a conundrum. (Programming) Languages should be seen as milestones. They provide us (programmers) with something useful, and then we would like to move onto something better – everything should go forward.
However, we write millions of lines of code. Spend hours and hours getting systems into production, which of course requires a lot of money.

We would like the next big technology (programming language) to be able to build on what we have already done i.e. we would like to always move forward, without always having to throw away the hard work and money that has already been invested. At the same time, we would like the next big thing to work with us i.e. grow, and be adaptable, and work easily with our ever changing needs.

Most (new) programming languages, like to just butt in – try to make a market and forget everything that is going on and what is already in place. This has proved to be a bad approach. People, companies, governments, are not just going to drop everything and put all their faith into something completely new, unknown, and often unproven.

Scala took a while to get going, but now it is being rapidly adopted.
The UK Home Office, and indeed many other Government departments, are using Scala now, and more and more projects are choosing to go with Scala. Even banks, and especially investment banks that have millions and millions invested in technologies (mainly C, C++ and Java) have got onto the Scala bandwagon - this is very significant, because they will only adopt technology that they see as the future.

Scala is the language that seems to do everything. You can start as small as you like, from just a shell script, yes a shell script in Scala, up to a full stack web application, all the way up to a distributed big data cruncher.

And yet Scala manages to allow you to not throw away history and your resources and at the same time move forward to better quality more maintainable future proof applications.

Could Scala break the hold of the top languages and how did it become a viable challenger?

What is Scala? The benefits? How are we using it at the [UK Home Office (another blog)](https://davidainslie.github.io/scala-blog-uk-home-office)?

Topics covered in this blog:
- Scala Introduction
- Scala Small to Big
- Scala 101
- Scala Example
- Scala Resources

## Scala Introduction
Scala was created by [Martin Odersky](https://en.wikipedia.org/wiki/Martin_Odersky) and backed by [Lightbend](https://www.lightbend.com/) (formerly known as Typesafe).

Scala was first released in 2004. The name stands for “scalable language” - Scala was designed to grow with the demands of its users (we'll come back to this).

It was built to run on the JVM, just like Java. The JVM is the Java Virtual Machine. Most languages have their code (the English like text that a programmer writes) compiled/interpreted (well, really translated) to the language that the computer understands (the computer that your program will run on). The JVM is an intermediary layer, between computer language and the English like source code, which provides many benefits (for another blog). However, in short it allows your code to be portable (there are many different computers and operating systems) and it can actually optimize/improve your code when it runs.

Because of its association with Java, Scala has a familiar syntax to many developers, but most of its ideas have come from the [Haskell](https://www.haskell.org/) programming language, for solid, dependable, future proof code.

So, developers should be able to get on board with Scala because of the Java connection, but write much better, high quality, robust, scalable, maintainable and future proof code because of the Haskell connection. Note that this connection with Haskell is for another blog. However, just for your information, Haskell is a purely functional programming language - we'll discuss "functions" later.

As a side note, to get the best out of Scala, you must treat it as its own language, just like you would any other language. If you make the mistake of trying to use Scala as a super duper much better version of Java, you'll miss out on many of the benefits, where these benefits come in the form of ideas/methodologies and not syntax.

Let's find out why you should be using Scala.

## Scala Small to Big

As mentioned, Scala is "the" scalable language.

All applications have one thing in common (regardless of language) - they grow.
For me, Scala is the best language to manage that growth.

We don’t want to write; have problems; throw away; and then start again.
**We want to manage, adapt, and constantly improve.**

A few benefits of the Scala language (with some covered in more detail later):
- Applications grow seamlessly with user/business demands.
- The language works with you (not against you). Any number of classes in the same file; sound defaults such as everything immutable; code written for you etc.
- Easily scale up (on a single machine) and scale out (to many machines).
- Type safe language (statically typed) with the benefits of dynamic languages, such as type inference and even dynamic programming that should be used with caution, because you may as well be writing Ruby.
- Embraces and makes it easy to program with the best methodologies such as Test Driven Development (TDD); Expression Oriented Programming; Functional Programming; Object Oriented Programming; Reactive Programming (including Asynchronous and Event Driven Development); Aspect Oriented Programming; and much more.
- Internal and external DSLs.
- Thread safety (concurrency) while using all resources efficiently.
- Concise, high quality code.
- All the advantages of the JVM.
- Transparent interaction with Java code.
- Utilise any available Java library.
- Add functionality to third party code without having to inherit from it, or actually open up the source code to physically alter it.
- Powerful libraries/frameworks that embrace modern programming and methodologies, all based on the fact that Scala has been designed for this modern world.

Before we get into the language itself, let's start small and aim big, mentioning a few libraries along the way.

### Small Scala
As mentioned, you can write your shell scripts in Scala.
By the way, all the top languages have their own build tool e.g. Ant, Maven, Gradle, to mention a few. Scala has [SBT](http://www.scala-sbt.org/).

SBT is more than just a build tool. It is also a powerful interactive environment for a developer - act as Scala playground or even interact with your application. There are hundreds of plugins for this build tool, where [Ammonite Shell](http://www.lihaoyi.com/Ammonite/#Ammonite-Shell) can help with shell scripting.

### Medium Scala
A standalone Scala app that uses standard Scala, which we'll discuss later, or maybe a standalone app with a UI using [ScalaFX](http://www.scalafx.org/).

Scala is perfect for the web because Scala and appropriate libraries are reactive, just like the web itself. You can even go full stack with Scala.

There are several web libraries such as
- [Play](https://playframework.com/), which is most often used, and is a favourite of Government projects.
- [Scalatra](http://scalatra.org/), a simpler and smaller competitor to Play.
- [Lift](http://liftweb.net/), which is apparently the most secure web framework and so favoured by banks.
- [Spray](http://spray.io/), for building RESTful microservices, which is being merged into the powerful Akka and renamed as Akka HTTP.
- [Scala.js](https://www.scala-js.org/), which allows you to write your JavaScript in Scala and so provide all the benefits of Scala while avoiding the pitfalls of JavaScript.

### Big Scala
Often your application will end up being distributed - it may be split up and communicate with itself from different boxes/nodes/machines (i.e. computers), or your applications send requests to other services again on different boxes. The buzzword is microservices, but this is just a fancy word for distributed applications that have been around for a long time... it's just how do you manage these types of applications? And how do you (automatically) test these types of applications? How do you design/program for robust, fault tolerant systems, and how do they perform when handling potentially millions of transactions?

- [Akka](http://akka.io/), to build highly concurrent, distributed, and resilient message driven applications. Akka is built around the [Actor methodology](https://en.wikipedia.org/wiki/Actor_model) and provides many libraries for the likes of clustering, persistence, reactive streams and RESTful services. You can even write automated tests for anything provided such as a cluster.
- [Spark](http://spark.apache.org/), for lightning fast cluster computing. [Why Scala is taking over the big data world](http://www.slideshare.net/deanwampler/why-scala-is-taking-over-the-big-data-world).
- [Kafka](http://kafka.apache.org/), designed to allow a single cluster to serve as the central data backbone for a large organization. It can be elastically and transparently expanded without downtime.

## Scala 101
I can only give you a taster of Scala, and just pick a few random topics.

The best way to follow along, is to have Scala installed, which I discuss in the Footnote at the end of this blog.

Check that all is working i.e. you indeed have Scala. At a command prompt:
```
$ scala
```

You can now play around with Scala as you have started up the Scala REPL (Read, Eval, Print, Loop) - this REPL allows you to write code that is immediately interpreted, and is a useful tool for testing/experimenting Scala. Go ahead, type some Scala e.g.
```scala
scala> 1 + 1
res0: Int = 2

scala> 1 + res0
res1: Int = 3

// Transform each number from 1 to 10 by multiplying each by 2,
// where the _ is a placeholder for the current element being "mapped" e.g. 10 * 2
scala> (1 to 10) map { _ * 2 }
res0: scala.collection.immutable.IndexedSeq[Int] = Vector(2, 4, 6, 8, 10, 12, 14, 16, 18, 20)

// Add all the numbers from 1 to 10 by reducing (to a single value),
// where the two _ are placeholders for two arguments being added e.g. 1 + 2
scala> (1 to 10) reduce { _ + _ }
res1: Int = 55

scala> (1 to 10) sum
res2: Int = 55

// Filter a list of numbers into two categories based on a criteria using partition.
// This example creates two lists of students based on their test scores, where a pass is 60 and above
scala> val (passed, failed) = List(49, 58, 76, 82, 88, 90) partition { _ >= 60 }
passed: List[Int] = List(76, 82, 88, 90)
failed: List[Int] = List(49, 58)
```

Within a Scala project, instead of typing "scala" at the command prompt, you would type "sbt", to enter Scala's interactive build tool. From there you could type "console" to once again be in the Scala REPL, but this time have access to everything in your Scala project e.g. you could interact with your Scala application.

You could now try out the Activator that was also installed with Homebrew. First, take a look at the [Activator](https://www.lightbend.com/community/core-tools/activator-and-sbt) website. Activator allows you to start almost any Scala project from a template that is already to run - the template often comes with an explanation/tutorial. For example, at the command prompt type:
```
$ activator ui
```

Your browser will open up the "templates" page where you scroll through templates to chose from, and then create your project. This page also provides you with a lightweight IDE where you can code, continuing from where the template left off, and even build and run.

Now for a bit of Scala...

### **Expression Oriented Programming**
Languages such as Java and JavaScript are not expression oriented (though ECMAScript 6 is trying). The easiest example (and so explaining this concept) is the "if" statement. In Java and JavaScript "if" is a statement, but in Scala it is an expression. In Java:
```java
if ("me".equals("you")) "scary"
```
This doesn't give us much! And how do we test this?

(Note, please disregard the fact that **?** could be used in Java, which is a gimmick for this particular example, and though there is so much more to Expression Oriented Programming, this example merely provides the easiest explanation).

Now for the Scala version (start up your REPL):
```scala
$ scala
scala> val result = if ("me" == "you") "scary"
result: Any = ()
```
Mmm... Is Scala not giving us much either? Well it is giving us an "Any", which can be thought of as Java's Object i.e. the top-level mother of all objects.
Ah! So it is giving us something. It is an expression i.e. Scala does give us expressions instead of merely statements (a la Java, JavaScript). However, Scala is actually giving back **()**. Eh? Well, **()** basically stands for an empty result, which Scala calls **Unit**. Because the "if" of the expression has not been satisfied, there is nothing to do.

If we have an "else" for the "if", things become a little clearer. In the Java, JavaScript world there is no change, but see what happens with Scala:
```scala
scala> val result = if ("me" == "you") "scary" else "phew"
result: String = phew
```

A slightly more involved example uses Scala's pattern matching. A Java developer first views pattern matching as a more powerful form of the Java switch statement. However, pattern matching is much more, including being an expression. Look at the following:
```scala
val here = "italy" match {
  case "Scotland" | "Northern Ireland" | "Wales" | "England" => "United Kingdom"
  case country if country.matches("[a-z].*") => s"Little $country"
  case _ => "Rest of the world"
}

here: String = Little italy
```
I hope I don't have to explain the above example. Well... just in case.

So, we want to find a match for "italy". We take one **case** at a time, where the first matching case would complete the match and its result assigned to the variable **here**.

Does the String "italy" match "Scotland" or "Northern Ireland" etc.? No.

Let's suppose that "italy" did not match the second case (which it does). The final case matches anything - a kind of catch all. The case that does match has a "guard" i.e. a check, which in this instance is an "if" expression using a regex.

A result of a case is given after a **=>**. Again, a bit like a function i.e. the right hand side of "=>" gives the result. Also, note in the matching case, the result uses **s** in front of the string result. This is string interpolation, which replaces text with special markup. The example shows that "country" has the special markup of **$**. So **$country** will be replaced with whatever country is set in the case itself i.e. **case country** will actually be **case "italy"**.

Because expression oriented programming results in something generated from executing, what would be an instruction in the Java world, we have "output" resulting from processing, which leads into functional programming. Functions take input and produce an output, as does our expression, and so we are given output to work with, and so test against. Expression oriented programming, along with Functional Programming, leads to easier Test Driven Development.

### **Functional Programming**
Using the "functional" methodology in Scala is very important. In the simplest of terms, we deal with functions, where a function takes input, processes it, and produces output. Remember one of the original computing terms: "Garbage in, garbage out"? That is a function.

```
     function
input   =>   output (the result)
```

Why are functions to important?

Well, there is testing, which will lead us into TDD (Test Driven Development).

We write a test for a function; write the function; and we prove that the function works by asserting (checking) the result i.e. the output from the function. Upon creating more and more functions, we can compose those functions i.e. make them work together e.g. input A goes into function 1 resulting in output B, which is then used as the input to function 2, resulting in output C.

```scala
  f1   f2
A => B => C
```

That is composition, and because f1 and f2 have been tested separately, then we know this composition will work... always. With one caveat.
f1 and f2 must only work on their given input and not anything outside e.g. there may be some other data (apart from A and B) named Z, that is hanging around somewhere. If our functions use Z, it could influence the result, and instead of ending up with a C, we end up with a S and another time we may end up with T.

So Scala, like any other functional language, promotes pure functions (they only act on their input) and so can have no side effects. Hand in hand with this idea is the concept of data being immutable. Mutable data is dangerous. If something always stays the same, you can deal with it, but if it is changing, then you run the risk of ending up with a result you didn't expect. This simple idea overcomes many random/unknown issues that happen in production. It mainly boils down to "race conditions" where data changes unexpectedly because of "time" - something may happen the same way 99 times out of 100, but just once in a while it does not, and that can be fatal. Imagine having your bank account wiped clean, simply because something that could rarely happen, does indeed happen, and in terms of programming, this situation could be almost impossible to replicate! But we don't want to be trying to replicate issues, we should be avoiding them happening in the first place - solid practices of functional programming with TDD is one giant step towards achieving this.

Most non-functional languages work with mutable data all the time: Java, JavaScript, Ruby etc.

Let's say you are playing football and the goal posts are your programming language.
Given a penalty, the normal rules of the game apply when the goal posts are Scala (or Haskell). Regarding Java, the goal posts will move around! Regarding JavaScript, sometimes the goal posts are not even there!

Let's define a function using the above discussions/illustrations, where syntax is similar to the above explanation of a function:

```scala
val here = (country: String) => country match {
  case "Scotland" | "Northern Ireland" | "Wales" | "England" => "United Kingdom"
  case c if c.matches("[a-z].*") => s"Little $country"
  case _ => "Rest of the world"
}

here("italy")

here: String => String = <function1>
res3: String = Little italy
```
The end result is the same: "Little italy".

The second last line shows that we have defined **here** to be a function that takes a String as its input, to produce a String as its output i.e. it is of type **function1** meaning that it is a function that takes one argument.

In the definition itself, we have indeed stated that **country** is the input of type String, where we can now use said named variable in the function itself i.e. the processing that begins **country match**.

And finally, to apply (well, call) the function, we give it the input that we wish to be processed, in this case "italy".

### **Test Driven Development**
Scala makes TDD easy. If testing an application is awkward, specially writing unit/integration tests, developers tend to avoid/by-pass writing tests before source code and then try to retro fit an unreadable/unmaintainable test afterwards.

Note that test code, that does indeed test your source code, should actually just be a side effect (a by product) of what they actually start out as... When writing a test first, you are actually describing, how some functionality should behave - you are driving i.e. designing your source code with a test. Once the source is written, low and behold you can immediately test it.

When thinking about tests in this way, your code naturally leans towards being functional, because the test needs something, a result, to assert against; each test must be completely independent i.e. there cannot be any test interference; and of course, for a given set of test data, the result must always be the same and so side effects need to be avoided (remember immutability).

Scala test code uses either [TDD](http://techblog.net-a-porter.com/2016/06/tdd-bdd-and-specs2-a-testing-strategy-for-scala/) and [BDD](https://prezi.com/1cuqragi-7cs/behavior-driven-development-with-scala/). Here's a noddy example before we touch on TDD and BDD:

```scala
class ExampleSpec(implicit ev: ExecutionEnv) extends Specification {
  "Futures composition" should {
    "run processes in parallel and combine the results" in {
      val xCalc = Future {
        println("I'm working on producing a 2")
        2 // This value is returned since it is the last expression
      }

      val yCalc = Future {
        println("I'm working on producing a 4")
        4 // This value is returned since it is the last expression
      }

      println("Workers should be working...")

      val outcome = for {
        x <- xCalc
        y <- yCalc
      } yield x + y

      outcome must beEqualTo(6).await
    }
  }
}
```

In the Scala world, we usually use either [Specs2](https://etorreborre.github.io/specs2/) or [ScalaTest](http://www.scalatest.org/) libraries to help us do TDD. (Most languages have something similar). Here we are using Specs2, which adopts a very functional style to testing, and also leans towards doing BDD and not just TDD, where BDD stands for Behaviour Driven Development. We'll save a discussion of BDD and TDD related to Scala for another blog. However, in short, both methodologies emphasis writing test code before source code.

The above test states **Futures composition should run processes in parallel and combine the results** i.e. tells us what the test is doing. As the Scala Example that follows later, is a demonstration about being reactive, now seems like a good time to introduce its basic concept that utilises a Scala Future - work that will eventually be done.

Regarding our test, we have two calculations kicked off, and then combine their results in a "for comprehension" (that's the bit that involves **for { ... } yield**). And we **await** for the result to be asserted (we don't know when the two processes will complete and we shouldn't actually care). The **println**s show that indeed, we do not know the order of processing e.g.
```
I'm working on producing a 2
Workers should be working...
I'm working on producing a 4

```

### **... And there are so many more useful methodologies to work with**
Scala provides so much more, but the above three methodologies show that by working together, we can attain high quality, more readable code, which is easier to test.
Often developers don't practice TDD because testing is cumbersome. A language such as Scala allows for easier testing.

# Scala Example
Scala has been created, from the very beginning, to be in tune with the modern world of programming - all centred around the idea of a scalable language i.e. the language that grows with you and your needs.

One of the modern, and it would seem, one of the most important, types of programming, is **Reactive Programming**. This is extremely important because of the **web**. And Scala (and other languages) brings an extra level of sophistication to this methodology: **Functional Reactive Programming**.

Reactive programming will often include:
- Interact with a database without blocking
- Send a SOAP request to some legacy system without blocking
- Make a RESTful call without blocking
- Interact with streams without blocking

So let's finish off with a full, but simple example, to illustrate this idea. To keep things as simple as possible, I've taken short cuts and so the solution is far from perfect e.g. I don't care about errors (even though Scala exception handling strategies are far better than most mainstream languages); I treat any price as GBP; I won't really get different price quotes; I would have preferred to use a concept called Type Classes, but that would be too advanced for our whirlwind introduction to the world of Scala. Also for brevity, I've omitted "imports". However, the full project will be on github for you to play around with. At some point, I may even publish a nicer solution on github.

I'm a stock broker (not really), and I'm going to make calls to RESTful web services from two different banks. Actually, I'm going to cheat and simply call Yahoo Finance to represent one bank, and Google Finance to represent the other. We get free delayed price quotes of stocks.

Two examples - the first will ask for two quotes at the same time, and accept the first quote that comes back; the second will again ask for two quotes at the same time, but accept the best quote i.e. we will need both quotes instead of just the first one.

We will make two Future calls using a RESTful client and compose those Futures.

Eh! Say what?

In Scala, we can call functionality asynchronously i.e. kick off some processing but not wait for said processing to begin... we just carry on, knowing that a result will appear either now, or in the future... but the clever part, is that we can write code as if we are just dealing with synchronous calls, and most developers feel much more comfortable with this. We achieve this, by composing the Futures, which kind of means the composed code will only run, when the result of a future is available... but again, the developer is pretty well unaware of this.

Now, a RESTful call is essentially, a Future call i.e. it is a non-blocking, asynchronous call. You can make a RESTful call synchronously, but that is a bad idea, because you would be wasting resources - you would not be reactive (which goes against, how the web works).

For our RESTful call, we shall use Play, a Scala web library. Wait! Use a web library, just to make a RESTful call. Well, Play is split up into modules (as all good projects are) and you only use what you need, in this case the web service module.

### Common Code for the Examples

First we'll need some banking stuff:
```scala
trait Bank {
  def name: String

  def quote(symbol: String)(implicit ws: WSClient): Future[Quote]
}
```

For all you budding Java developers, think of a **trait** as an interface. So a bank will have to define its **name** and perform its own price quoting.

That **quote** method will probably make you think, "what a weird signature, and it would seem that the method takes two argument lists".

Firstly, the method return of **Future[Quote]**. Essentially, this method is asynchronous; when it is called, it immediately returns, and the body of the method runs at some point to produce a (price) **Quote**. That Future is **composable**, as we will see. Again, let me reiterate, that this whole example is somewhat noddy and naive, but should get the point across about Reactive Programming, making calls over the internet etc. can be concise and easy to read, as it is done in Scala.

Secondly, the **implicit ws: WSClient**. Well **WSClient** is provided by Play's web services module to easily invoke RESTful services - you just provide WSClient with a URL and then either **get**, **post** (some data), **put** (some data) and **delete**. As for **implicit**. Well that is really for another blog (again since this is an introduction). However, it means that you don't have to call **quote** with a **WSClient**, there just has to be one available somewhere, and this comes down to the clever Scala compiler (there are rules to learn about where to look for something required).

A bank needs to be able to provide a **Quote** (the result of a future call):
```scala
case class Quote(bank: Bank, price: Money)
```

Case classes (**case class**) are usually used in Scala to represent "domain/business data". In this case, the quote has a price, where **Money** is e.g. £45.78 or $21.00, and this comes from some bank.

A **case class** is thus named, because it is a class (something that can be instantiated) that, as it is, can be used in a **pattern match**. Again, to keep is simple, a pattern match can be thought of as a powerful switch statement (a bunch of if/else statements), where one path will be taken - each path is defined by a **case**. Please refer to the pattern match example previously given.

Finally we need two banks to provide quotes:
```scala
object CreditSuisse extends Bank {
  val name = "Credit Suisse"

  def quote(symbol: String)(implicit ws: WSClient) = 
    ws.url(s"http://finance.yahoo.com/d/quotes.csv?s=$symbol&f=snl1").get().map { response =>
      /* Body of response is of form: "AAPL","Apple Inc.",94.40 */
      Quote(this, GBP(response.body.split(",")(2).toDouble))
    }
}
```
Given a WSClient, we make a **get** RESTful call to Credit Suisse. As you can see, I'm cheating and just calling **Yahoo Finance** and then parsing the text CSV response. Note that we are returning a **Quote** but not actually stipulating **return** - this goes hand in hand with Expression Oriented Programming, where the last line of some functionality is the result to return.

And here is JP Morgan, where under the hood, we use **Google Finance** and parse the **JSON** response (though it is not pure JSON, as we have to remove some text first).
```scala
object JPMorgan extends Bank {
  implicit val formats = DefaultFormats

  val name = "JP Morgan"

  def quote(symbol: String)(implicit ws: WSClient) = 
    ws.url(s"http://finance.google.com/finance/info?client=ig&q=NASDAQ:$symbol").get().map { response =>
      /* Body of respone is of the form: // [{"id": "22144", "t" : "AAPL" ,"e" : "NASDAQ" ,"l" : "94.40" ...}]*/
      Quote(this, GBP((parse(response.body.replaceAll("""[// \[|\]]""", "")) \ "l").extract[String].toDouble))
    }
}
```

Note that these two banks are **object** instead of **class**. Think of an **object** as a singleton version of **class** and so, should not be abused, because of the singleton anti pattern.

### Example 1
Buy the **first** quote that we are given. We shall ask Credit Suisse and JPMorgan at the same time, and our application will not block anywhere. The quotes we get back from these banks, wrapped in a **Future** will be composed with **or**, where we want one quote or the other - in this case, the first **Future** that completes (we are in a hurry to buy):
```scala
object WebServiceExample1App extends App with System {

  val creditSuisseQuote = CreditSuisse quote "AAPL"

  val jpMorganQuote = JPMorgan quote "AAPL"

  (creditSuisseQuote or jpMorganQuote) map { quote =>
    println(s"I'll accept the FIRST received price of ${quote.price} from ${quote.bank.name}")
  } onComplete { result =>
    if (result.isFailure) println("Ignoring the fact that we have no quote")
    sys.exit()
  }
}
```
An example of the output we will get is:
```
I'll accept the FIRST received price of 94.40 GBP from JP Morgan
```
Note that the code uses **map**, which is very big in functional programming.

This is actually a function and it takes a function. (Ye! Will definitely have to do a blog on this stuff). The name is actually very appropriate. Developers deal a lot with the data structure Map. A Map is a container of key/value pairs. Given a key, give me back a value. That is what **map** does. In our example, given a **Quote** give me back, whatever my code decides. Regarding Map, the key and value can be of the same type of data or not. Same with the **map** function. But what is interesting in our example, is that **map** is called on a **Future**! What happens here, is that the function input (like the key in a Map) will be the result of a Future, and the result (like the value in a Map) will be wrapped in a Future. That's one of the cornerstones of **Future** - it keeps its shape - we write code and pretend that Future is just not there; we only deal with what is inside the Future. And a Future constitutes time - but we take time out of the equation, because time is a problem and messes things up (especially a developer's brain).

### Example 2
Buy the **best** quote that we are given. We shall ask Credit Suisse and JPMorgan at the same time, and our application will not block anywhere. The quotes we get back from these banks, wrapped in a **Future** will be composed in a **for comprehension**, where we need both quotes to decide which one to choose:
```scala
object WebServiceExample2App extends App with System {

  val creditSuisseQuote = CreditSuisse quote "AAPL"

  val jpMorganQuote = JPMorgan quote "AAPL"

  val bestQuote = for {
    csQuote <- creditSuisseQuote
    jpQuote <- jpMorganQuote
  } yield bestBuy(csQuote, jpQuote)

  bestQuote map { quote =>
    println(s"I'll accept the BEST received price of ${quote.price} from ${quote.bank.name}")
  } onComplete { result =>
    if (result.isFailure) println("Ignoring the fact that we have no quote")
    sys.exit()
  }
}
```

where the function **bestBuy** is the following simple and naive way of deciding what quote would be the best (lowest price):
```scala
def bestBuy(atLeastOneQuote: Quote, quotes: Quote*) = 
  quotes.foldLeft(atLeastOneQuote) { (best, quote) =>
    if (best.price <= quote.price) best else quote
  }
```

where **foldLeft** is a much used functional way of taking a sequence (list, array etc.) and ending up with one item according to a given function i.e. our anonymous function of:
```scala
(best, quote) => best OR quote
i.e.
(Quote, Quote) => Quote
```

Note that **foldLeft** is related to **foldRight**, **fold**, **reduce**, **reduceLeft** and others, that all encapsulate the important functional concept of [recursion](http://alvinalexander.com/scala/scala-recursion-examples-recursive-programming).

An example of the output we will get is:
```
I'll accept the BEST received price of 94.40 GBP from JP Morgan
```

First thing to note about the **for comprehension**, is that it appears to be some sort of **for** loop you see in the likes of Java or JavaScript. It can be used in that way, but notice the **yield**. A for comprehension comes from Haskell's **list comprehension**. Without going into too much detail, we are actually performing another **map**, and also something called **flatMap**, which is like **map**. (Flat mapping is definitely for another blog).

Secondly, the code could be viewed as making standard synchronous, blocking calls e.g. let's pretend the for comprehension was:
```scala
val csQuote = creditSuisseQuote
val jpQuote = jpMorganQuote

val bestQuote = bestBuy(csQuote, jpQuote)
```

What we have achieved with the **for comprehension** is to once again, not concern ourselves with time. We are reactive. Our two RESTful calls are performed non-blocking and in parallel, and only when both Futures complete does the **yield** expression provide a result - if one or both RESTful calls fail, then the **yield** will not be executed, and the completed Future given to **bestQuote** will contain the error.

# Scala Resources
[Scala](http://www.scala-lang.org/) is not only a language that grows with user/developer/team needs, it is evolving at a rapid rate. In fact, the Scala compiler is being rewritten. The current compiler is one of the most powerful compilers, as it does a lot for a developer - it really does help/assist the developer (and as a result, some people complain about the speed of the compiler). The new compiler named [DOTTY](http://dotty.epfl.ch/) takes compilers to a whole new level.

As mentioned, Lightbend, the company behind Scala, set up the brilliant [Activator](https://www.lightbend.com/community/core-tools/activator-and-sbt) to get a Scala project up a running in minutes.

A great starting point for any newbie to Scala, but also very useful for any Scala developer is [The Neophyte's Guide to Scala](http://danielwestheide.com/scala/neophytes.html).

Free Scala courses can be found at the [Scala Centre](https://scala.epfl.ch/)

[Coursera](https://www.coursera.org/), which has hundreds of brilliant free and paid courses, has [5 Scala courses](https://www.coursera.org/courses?languages=en&query=scala) with video lectures, assignments and certificates. The first one, [Functional Programming Principles in Scala](https://www.coursera.org/learn/progfun1), is a must for any Scala developer.

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

### Installing Scala on your computer

To install Scala, either go to the [Scala website](http://www.scala-lang.org/download/) or, if you are lucky to have a Mac with Homebrew installed, then the following (from a command console) will install the latest version of Scala:
```
$ brew install scala
$ brew install sbt
$ brew install typesafe-activator
```

From these the above commands: Scala is... well, you can guess.

SBT is Scala's interactive build tool.

Activator is briefly discussed in the blog.