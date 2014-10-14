package com.peterpotts.sample

import scala.util.Random

case object SampleInt extends Sample[Int] {
  def next(): Int = Random.nextInt()

  def apply(until: Int) = SamplePick(0 until until)
}
