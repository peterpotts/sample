package com.peterpotts.sample

case object SampleUnit extends Sample[Unit] {
  def next(): Unit = ()
}
