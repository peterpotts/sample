package com.peterpotts.sample

import scala.util.Random

case class SampleBytes(size: Int) extends Sample[Array[Byte]] {
  def next(): Array[Byte] = SampleBytes.bytes(size)
}

case object SampleBytes extends Sample[Array[Byte]] {
  def next(): Array[Byte] = bytes(defaultSampleSize)

  private def bytes(size: Int): Array[Byte] = {
    val bytes = new Array[Byte](size)
    Random.nextBytes(bytes)
    bytes
  }
}
