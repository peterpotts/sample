package com.peterpotts.sample

import scala.util.Random

case object SampleBoolean extends Sample[Boolean] {
  def next(): Boolean = Random.nextBoolean()
}
