package com.peterpotts.sample

import scala.util.Random

/**
  * Creates a sample of randomly generated integers uniformly distributed from 0 to (2 ^^ numberOfBits - 1) inclusive.
  *
  * @param numberOfBits Number of bits
  */
class SampleBigInt(numberOfBits: Int) extends Sample[BigInt] {
  def next(): BigInt = BigInt(numberOfBits, Random)

  def withSign(): Sample[BigInt] = SampleShuffle(this, map(-_))
}

object SampleBigInt extends SampleBigInt(256) {
  def apply(numberOfBits: Int) = new SampleBigInt(numberOfBits)
}
