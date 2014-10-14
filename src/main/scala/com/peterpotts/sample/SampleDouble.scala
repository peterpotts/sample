package com.peterpotts.sample

import scala.util.Random

case object SampleDouble extends Sample[Double] {
  def next(): Double = Random.nextDouble()
}
