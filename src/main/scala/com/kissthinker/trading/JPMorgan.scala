package com.kissthinker.trading

import scala.concurrent.ExecutionContext.Implicits.global
import play.api.libs.ws.WSClient
import org.json4s.DefaultFormats
import org.json4s.jackson.JsonMethods._
import squants.market.GBP

object JPMorgan extends Bank {
  implicit val formats = DefaultFormats

  val name = "JP Morgan"

  def quote(symbol: String)(implicit ws: WSClient) =
    ws url s"http://finance.google.com/finance/info?client=ig&q=NASDAQ:$symbol" get() map { response =>
      /* Body of respone is of the form: // [{"id": "22144", "t" : "AAPL" ,"e" : "NASDAQ" ,"l" : "94.40" ...}]*/
      Quote(this, GBP((parse(response.body.replaceAll("""[// \[|\]]""", "")) \ "l").extract[String].toDouble))
    }
}