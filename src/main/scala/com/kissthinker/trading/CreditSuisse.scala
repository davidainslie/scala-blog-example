package com.kissthinker.trading

import scala.concurrent.ExecutionContext.Implicits.global
import play.api.libs.ws.WSClient
import squants.market.GBP

object CreditSuisse extends Bank {
  val name = "Credit Suisse"

  def quote(symbol: String)(implicit ws: WSClient) = ws.url(s"http://finance.yahoo.com/d/quotes.csv?s=$symbol&f=snl1").get().map { response =>
    /* Body of response is of form: "AAPL","Apple Inc.",94.40 */
    Quote(this, GBP(response.body.split(",")(2).toDouble))
  }
}