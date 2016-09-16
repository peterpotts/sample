package com.peterpotts.sample

import scala.util.Random

object SampleBigDecimal extends Sample[BigDecimal] {
  def next(): BigDecimal = Random.nextDouble()
}
