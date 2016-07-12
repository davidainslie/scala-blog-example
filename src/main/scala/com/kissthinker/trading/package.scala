package com.kissthinker

package object trading {
  def bestBuy(atLeastOneQuote: Quote, quotes: Quote*) = quotes.foldLeft(atLeastOneQuote) { (best, quote) =>
    if (best.price <= quote.price) best else quote
  }
}