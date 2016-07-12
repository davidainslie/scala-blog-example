package com.kissthinker.futures

import scala.concurrent.Future
import org.specs2.concurrent.ExecutionEnv
import org.specs2.mutable.Specification

class FuturesSpec(implicit ev: ExecutionEnv) extends Specification {
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