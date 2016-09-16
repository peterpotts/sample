package com.peterpotts.sample

import scala.collection.immutable.IndexedSeq

object Alphanumeric {
  val values: IndexedSeq[Char] = ('0' to '9') ++ ('A' to 'Z') ++ ('a' to 'z')
}
