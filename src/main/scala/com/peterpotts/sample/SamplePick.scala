package com.peterpotts.sample

import scala.collection.immutable.IndexedSeq
import scala.util.Random

class SamplePick[T](values: IndexedSeq[T]) extends Sample[T] {
  def next(): T = values(Random.nextInt(values.size))
}

object SamplePick {
  def apply[T](values: IndexedSeq[T]) = new SamplePick(values)
}
