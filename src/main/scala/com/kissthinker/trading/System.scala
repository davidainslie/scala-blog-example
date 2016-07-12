package com.kissthinker.trading

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import play.api.libs.ws.ahc.AhcWSClient

trait System {
  implicit val system = ActorSystem()

  implicit val materializer = ActorMaterializer()

  implicit val wsClient = AhcWSClient()
}