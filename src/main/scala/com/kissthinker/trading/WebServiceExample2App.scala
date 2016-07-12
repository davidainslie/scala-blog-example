package com.kissthinker.trading

import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Example output:
  * I'll accept the BEST received price of 94.40 GBP from JP Morgan
  */
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