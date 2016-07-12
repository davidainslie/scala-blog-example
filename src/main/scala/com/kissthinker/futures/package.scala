package com.kissthinker

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Future, Promise}
import scala.util.Try

package object futures {
  implicit class FutureOps[T](val self: Future[T]) {
    def or(other: Future[T]): Future[T] = {
      val p = Promise[T]()

      val completePromise = (t: Try[T]) => p tryComplete t

      self onComplete completePromise
      other onComplete completePromise

      p.future
    }
  }
}