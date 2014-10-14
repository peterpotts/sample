package com.peterpotts.sample

import scala.util.Random

case class SamplePick[T](values: Seq[T]) extends Sample[T] {
  def next(): T = values(Random.nextInt(values.size))
}
