package com.peterpotts.sample

import scala.util.Random

case class SampleShuffle[T](samples: Sample[T]*) extends Sample[T] {
  def next(): T = samples(Random.nextInt(samples.size)).next()
}
