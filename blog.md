Welcome to the second of a series of blog posts about Scala.

As discussed in the first post [An Introduction](https://davidainslie.github.io/scala-blog-introduction/), [Scala](http://www.scala-lang.org/) just might be your best programming investment.

This blog will present a very simple Scala application. Scala is huge and picking a first example could easily cover too much and overwhelm any newbie. At the same time, it would be nice to have an example that may interest someone who is already using Scala.

Here is my attempt...

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