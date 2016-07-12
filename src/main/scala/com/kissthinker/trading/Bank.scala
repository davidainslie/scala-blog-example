package com.kissthinker.trading

import scala.concurrent.Future
import play.api.libs.ws.WSClient

trait Bank {
  def name: String

  def quote(symbol: String)(implicit ws: WSClient): Future[Quote]
}